/*
                        queryj

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
 * Filename: RetrieveResultSetColumnsHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/16
 * Time: 11:11
 *
 */
package org.acmsl.queryj.customsql.handlers.customsqlvalidation;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.exceptions.CustomResultWithInvalidNumberOfColumnsException;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.customsql.Property;
import org.acmsl.queryj.tools.handlers.AbstractQueryJCommandHandler;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/16 11:11
 */
@ThreadSafe
public class RetrieveResultSetColumnsHandler
    extends AbstractQueryJCommandHandler
{
    /**
     * Asks the handler to process the command. The idea is that each
     * command handler decides if such command is suitable of being
     * processed, and if so perform the concrete actions the command
     * represents.
     *
     * @param command the command to process (or not).
     * @return <code>true</code> if the handler actually process the command,
     *         or maybe because it's not desirable to continue the chain.
     */
    @Override
    public boolean handle(@NotNull final QueryJCommand command)
        throws QueryJBuildException
    {
        @NotNull final ResultSet t_ResultSet = new ExecuteQueryHandler().retrieveCurrentResultSet(command);

        @NotNull final List<Property<String>> t_lColumns =
        return true;
    }

    /**
     * Retrieves the columns from given {@link ResultSet}.
     * @param resultSet the ResultSet.
     * @return the list of {@link Property} columns.
     * @throws SQLException if any operation on the {@link ResultSetMetaData} fails.
     */
    protected List<Property<String>> retrieveColumns(
        @NotNull final ResultSet resultSet, @NotNull final RetrieveResultPropertiesHandler handler)
        throws SQLException
    {
        @NotNull final List<Property<String>> result = new ArrayList<>();

        @NotNull final ResultSetMetaData t_Metadata = resultSet.getMetaData();

        final int t_iColumnCount = t_Metadata.getColumnCount();

        for  (int t_iIndex = 1; t_iIndex <= t_iColumnCount; t_iIndex++)
        {
            result.add(handler.createPropertyFrom(t_Metadata, t_iIndex));
        }

        return result;
    }

}
