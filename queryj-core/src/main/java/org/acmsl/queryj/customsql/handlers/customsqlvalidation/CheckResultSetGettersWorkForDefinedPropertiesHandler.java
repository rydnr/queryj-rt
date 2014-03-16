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
 * Filename: CheckResultSetGettersWorkForDefinedPropertiesHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/16
 * Time: 08:44
 *
 */
package org.acmsl.queryj.customsql.handlers.customsqlvalidation;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.exceptions.CustomResultWithInvalidNumberOfColumnsException;
import org.acmsl.queryj.api.exceptions.CustomResultWithNoPropertiesException;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.api.exceptions.UnsupportedCustomResultPropertyTypeException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Property;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.TypeManager;
import org.acmsl.queryj.tools.handlers.AbstractQueryJCommandHandler;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/16 08:44
 */
@ThreadSafe
public class CheckResultSetGettersWorkForDefinedPropertiesHandler
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
    public boolean handle(@NotNull final QueryJCommand command) throws QueryJBuildException
    {
        return true;
    }

    /**
     * Validates the result set.
     * @param resultSet the result set to validate.
     * @param sql the sql.
     * @param sqlResult the custom sql result.
     * @param customSqlProvider the <code>CustomSqlProvider</code> instance.
     * @param metadataManager the <code>MetadataManager</code> instance.
     * @param typeManager the <code>MetadataTypeManager</code> instance.
     * @throws java.sql.SQLException if the SQL operation fails.
     * @throws QueryJBuildException if the expected result cannot be extracted.
     */
    protected void validateProperties(
        @NotNull final ResultSet resultSet,
        @NotNull final List<Property<String>> properties,
        @NotNull final Sql<String> sql,
        @NotNull final Result<String> sqlResult,
        @NotNull final TypeManager typeManager,
        @NotNull final RetrieveResultPropertiesHandler handler)
        throws SQLException,
        QueryJBuildException
    {
        if (sql.getId().equalsIgnoreCase("find-product-types-by-draw-type-id"))
        {
            int debug = 1;
        }

        if  (resultSet.next())
        {
            @NotNull Method t_Method;

            for (@Nullable final Property<String> t_Property : properties)
            {
                if (t_Property != null)
                {
                    try
                    {
                        t_Method =
                            handler.retrieveMethod(
                                ResultSet.class,
                                handler.getGetterMethod(
                                    typeManager.getClass(t_Property.getType())),
                                new Class<?>[]
                                    {
                                        String.class
                                    });
                    }
                    catch  (@NotNull final NoSuchMethodException noSuchMethod)
                    {
                        throw
                            new UnsupportedCustomResultPropertyTypeException(
                                t_Property, sql, sqlResult, noSuchMethod);
                    }

                    new RetrieveResultPropertiesHandler().invokeResultSetGetter(
                        t_Method, resultSet, t_Property, sqlResult, sql);
                }
            }
        }
        else
        {
            @NotNull final ResultSetMetaData t_Metadata = resultSet.getMetaData();

            final int t_iColumnCount = t_Metadata.getColumnCount();

            if  (t_iColumnCount < properties.size())
            {
                throw
                    new CustomResultWithInvalidNumberOfColumnsException(
                        t_iColumnCount, properties.size());
            }

            @NotNull final List<Property<String>> t_lColumns = new ArrayList<>();

            for  (int t_iIndex = 1; t_iIndex <= t_iColumnCount; t_iIndex++)
            {
                t_lColumns.add(createPropertyFrom(t_Metadata, t_iIndex));
            }
        }
    }

}
