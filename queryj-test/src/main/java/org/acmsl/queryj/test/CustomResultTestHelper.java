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
 * Filename: CustomResultTestHelper.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Helper class for per-custom result Cucumber tests.
 *
 * Date: 2014/04/17
 * Time: 11:39
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

import java.util.List;
import java.util.Map;

/**
 * Helper class for per-custom result Cucumber tests.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/17 11:39
 */
@ThreadSafe
public class CustomResultTestHelper
{
    /**
     * Singleton implementation to avoid double-locking check.
     */
    protected static final class CustomResultTestHelperSingletonContainer
    {
        /**
         * The actual singleton.
         */
        public static final CustomResultTestHelper SINGLETON = new CustomResultTestHelper();
    }

    /**
     * Retrieves the singleton instance.
     *
     * @return such instance.
     */
    @NotNull
    public static CustomResultTestHelper getInstance()
    {
        return CustomResultTestHelperSingletonContainer.SINGLETON;
    }

    /**
     * Defines the input tables based on the information provided by the
     * feature.
     * @param tableInfo the information about the tables.
     * @param tables the table collection.
     */
    public void defineInputResults(
        @NotNull final DataCustomResult tableInfo,
        @NotNull final Map<String, CustomResult<String, Attribute<String>, List<Attribute<String>>>> tables)
    {
        @NotNull final List<Map<String, String>> tableEntries = tableInfo.asMaps();

        @Nullable CustomResult<String, Attribute<String>, List<Attribute<String>>> table;

        for (@NotNull final Map<String, String> tableEntry: tableEntries)
        {
            table = convertToCustomResult(tableEntry);

            if (table != null)
            {
                tables.put(table.getName(), table);
            }
        }
    }

    /**
     * Converts given table information to a {@link CustomResult}.
     * @param tableEntry the table information.
     * @return the {@link CustomResult} instance.
     */
    @Nullable
    protected CustomResult<String, Attribute<String>, List<Attribute<String>>> convertToCustomResult(
        @NotNull final Map<String, String> tableEntry)
    {
        @Nullable CustomResult<String, Attribute<String>, List<Attribute<String>>> result = null;

        @Nullable final String table =  tableEntry.get(AntCustomResultsElement.TABLE);

        if (table != null)
        {
            result =
                convertToCustomResult(
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
