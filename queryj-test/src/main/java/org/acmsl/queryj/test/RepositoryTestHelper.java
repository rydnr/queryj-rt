/*
                        QueryJ Test

    Copyright (C) 2002-today  Jose San Leandro Armendariz
                              chous@acm-sl.org

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the License, or any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General Public License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

    Thanks to ACM S.L. for distributing this library under the GPL license.
    Contact info: jose.sanleandro@acm-sl.com

 ******************************************************************************
 *
 * Filename: RepositoryTestHelper.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Helper class for per-foreign key Cucumber tests.
 *
 * Date: 2014/04/17
 * Time: 11:33
 *
 */
package org.acmsl.queryj.test;

/*
 * Importing JetBrains annotations.
 */
import cucumber.api.DataTable;
import org.acmsl.queryj.Literals;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.Table;
import org.acmsl.queryj.tools.ant.AntTablesElement;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

/*
 * Importing JDK classes.
 */
import java.util.List;
import java.util.Map;

/**
 * Helper class for per-foreign key Cucumber tests.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/17 11:33
 */
@ThreadSafe
public class RepositoryTestHelper
{
    /**
     * Singleton implementation to avoid double-locking check.
     */
    protected static final class RepositoryTestHelperSingletonContainer
    {
        /**
         * The actual singleton.
         */
        public static final RepositoryTestHelper SINGLETON = new RepositoryTestHelper();
    }

    /**
     * Retrieves the singleton instance.
     * @return such instance.
     */
    @NotNull
    public static RepositoryTestHelper getInstance()
    {
        return RepositoryTestHelperSingletonContainer.SINGLETON;
    }

    /**
     * Defines the input tables based on the information provided by the
     * feature.
     * @param tableInfo the information about the tables.
     * @param tables the table collection.
     */
    public void defineInputTables(
        @NotNull final DataTable tableInfo,
        @NotNull final Map<String, Table<String, Attribute<String>, List<Attribute<String>>>> tables)
    {
        @NotNull final List<Map<String, String>> tableEntries = tableInfo.asMaps();

        @Nullable Table<String, Attribute<String>, List<Attribute<String>>> table;

        for (@NotNull final Map<String, String> tableEntry: tableEntries)
        {
            table = convertToTable(tableEntry);

            if (table != null)
            {
                tables.put(table.getName(), table);
            }
        }
    }

    /**
     * Converts given table information to a {@link Table}.
     * @param tableEntry the table information.
     * @return the {@link Table} instance.
     */
    @Nullable
    protected Table<String, Attribute<String>, List<Attribute<String>>> convertToTable(
        @NotNull final Map<String, String> tableEntry)
    {
        @Nullable Table<String, Attribute<String>, List<Attribute<String>>> result = null;

        @Nullable final String table =  tableEntry.get(AntTablesElement.TABLE);

        if (table != null)
        {
            result =
                convertToTable(
                    table,
                    tableEntry.get(Literals.COMMENT),
                    tableEntry.get(PARENT_TABLE),
                    tableEntry.get(STATIC),
                    !isNullOrBlank(tableEntry.get(DECORATED)) && Boolean.TRUE.equals(tableEntry.get(DECORATED)),
                    !isNullOrBlank(tableEntry.get(RELATIONSHIP)) && Boolean.TRUE.equals(tableEntry.get(RELATIONSHIP)));
        }

        return result;
    }

}