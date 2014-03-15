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
 * Filename: BindQueryParametersHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/15
 * Time: 08:06
 *
 */
package org.acmsl.queryj.customsql.handlers.customsqlvalidation;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.commons.logging.UniqueLogFactory;
import org.acmsl.commons.utils.ConversionUtils;
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.exceptions.InvalidCustomSqlException;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.handlers.CustomSqlValidationHandler;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.TypeManager;
import org.acmsl.queryj.tools.handlers.AbstractQueryJCommandHandler;
import org.apache.commons.logging.Log;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/15 08:06
 */
@ThreadSafe
public class BindQueryParametersHandler
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
     * Validates given sql element.
     * @param sql such element.
     * @param customSqlProvider the custom sql provider.
     * @param connection the connection.
     * @param metadataManager the metadata manager.
     * @param typeManager the type manager.
     * @throws QueryJBuildException if the sql is not valid.
     */
    public void validate(
        @NotNull final Sql<String> sql,
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final Connection connection,
        @NotNull final MetadataManager metadataManager,
        @NotNull final TypeManager typeManager)
        throws  QueryJBuildException
    {
        @Nullable final String t_strValue = sql.getValue();

        @Nullable final Log t_Log = UniqueLogFactory.getLog(CustomSqlValidationHandler.class);

        if (t_strValue != null)
        {
            @NotNull final String t_strSql = t_strValue.trim();

            @Nullable SQLException t_ExceptionToWrap = null;

            @Nullable QueryJBuildException t_ExceptionToThrow = null;

            @Nullable PreparedStatement t_PreparedStatement = null;

            try
            {
                t_PreparedStatement = connection.prepareStatement(t_strSql);
            }
            catch  (@NotNull final SQLException sqlException)
            {
                t_ExceptionToWrap = sqlException;
            }

            if  (t_PreparedStatement != null)
            {
                try
                {
                    bindParameters(
                        sql,
                        t_PreparedStatement,
                        customSqlProvider,
                        typeManager,
                        ConversionUtils.getInstance());
                }
                catch  (@NotNull final SQLException sqlException)
                {
                    if (t_ExceptionToWrap == null)
                    {
                        t_ExceptionToWrap = sqlException;
                    }
                }
                catch  (@NotNull final QueryJBuildException buildException)
                {
                    t_ExceptionToThrow = buildException;
                }

                try
                {
                    t_PreparedStatement.close();
                }
                catch  (@NotNull final SQLException anotherSqlException)
                {
                    if  (t_Log != null)
                    {
                        t_Log.warn(
                            "Cannot close prepared statement.",
                            anotherSqlException);
                    }

                    if (t_ExceptionToWrap == null)
                    {
                        t_ExceptionToWrap = anotherSqlException;
                    }
                }
            }

            if  (t_ExceptionToWrap != null)
            {
                throw new InvalidCustomSqlException(sql, t_ExceptionToWrap);
            }
            else if  (t_ExceptionToThrow != null)
            {
                throw t_ExceptionToThrow;
            }
        }
        else
        {
            if (t_Log != null)
            {
                t_Log.warn("Non-select query with validate=\"true\": " + sql.getId());
            }
        }
    }
}
