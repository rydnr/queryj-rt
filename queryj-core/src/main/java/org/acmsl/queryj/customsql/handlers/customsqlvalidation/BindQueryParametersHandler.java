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
import org.acmsl.queryj.api.exceptions.InvalidCustomSqlParameterException;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.api.exceptions.UnsupportedCustomSqlParameterTypeException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Parameter;
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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

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
     * @param typeManager the type manager.
     * @throws QueryJBuildException if the sql is not valid.
     */
    public void validate(
        @NotNull final Sql<String> sql,
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final Connection connection,
        @NotNull final TypeManager typeManager)
        throws  QueryJBuildException
    {
        @Nullable final String t_strValue = sql.getValue();

        @Nullable final Log t_Log = UniqueLogFactory.getLog(CustomSqlValidationHandler.class);

        if (t_strValue != null)
        {
            @NotNull final String t_strSql = t_strValue.trim();

            @Nullable QueryJBuildException t_ExceptionToThrow = null;
            @Nullable SQLException t_ExceptionToWrap = null;

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

                    t_ExceptionToWrap = anotherSqlException;
                }
            }

            if  (t_ExceptionToWrap != null)
            {
                throw new InvalidCustomSqlException(sql, t_ExceptionToWrap);
            }
            else if (t_ExceptionToThrow != null)
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

    /**
     * Binds the query parameters to the {@link PreparedStatement}.
     * @param sql the query.
     * @param preparedStatement the PreparedStatement.
     * @param customSqlProvider the {@link CustomSqlProvider}.
     * @param typeManager the {@link TypeManager}.
     * @param conversionUtils the {@link ConversionUtils}.
     */
    protected void bindParameters(
        @NotNull final Sql<String> sql,
        @NotNull final PreparedStatement preparedStatement,
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final TypeManager typeManager,
        @NotNull final ConversionUtils conversionUtils)
    {
        throws  QueryJBuildException
        {
            @Nullable QueryJBuildException exceptionToThrow = null;

            int t_iParameterIndex = 0;

            for (@Nullable final Parameter<String, ?> t_Parameter :
                retrieveParameterElements(sql, customSqlProvider.getSqlParameterDAO()))
            {
                if  (t_Parameter == null)
                {
                    exceptionToThrow = new InvalidCustomSqlParameterException(t_iParameterIndex, sql);

                    break;
                }
                else
                {
                    bindParameter(
                        t_Parameter,
                        t_iParameterIndex,
                        sql,
                        statement,
                        typeManager,
                        conversionUtils);

                    t_iParameterIndex++;
                }
            }

            if  (exceptionToThrow != null)
            {
                throw exceptionToThrow;
            }
        }

        /**
         * Binds the parameters to given statement.
         * @param parameter the {@link Parameter}.
         * @param sql the sql.
         * @param statement the prepared statement.
         * @param typeManager the metadata type manager.
         * @param conversionUtils the <code>ConversionUtils</code> instance.
         * @param <T> the type.
         * @throws QueryJBuildException if some problem occurs.
         */
        @SuppressWarnings("unchecked")
        protected <T> void bindParameter(
        @NotNull final Parameter<String, T> parameter,
        final int parameterIndex,
        @NotNull final Sql<String> sql,
        @NotNull final PreparedStatement statement,
        @NotNull final TypeManager typeManager,
        @NotNull final ConversionUtils conversionUtils)
        throws QueryJBuildException
        {
            @Nullable QueryJBuildException exceptionToThrow = null;

            @Nullable final Log t_Log = UniqueLogFactory.getLog(CustomSqlValidationHandler.class);

            @Nullable final Method t_Method;

            @Nullable final Collection<Class<?>> t_cParameterClasses;

            @Nullable final Class<T> t_Type = retrieveType(parameter, typeManager);

            if  (t_Type != null)
            {
                if (typeManager.isPrimitiveWrapper(t_Type))
                {
                    t_cParameterClasses = Arrays.asList(Integer.TYPE, typeManager.toPrimitive(t_Type));
                }
                else
                {
                    t_cParameterClasses = Arrays.asList(Integer.TYPE, t_Type);
                }

                t_Method =
                    retrievePreparedStatementMethod(
                        parameter,
                        parameterIndex,
                        t_Type,
                        sql,
                        t_cParameterClasses);

                @Nullable final Object t_ParameterValue =
                    retrieveParameterValue(
                        parameter, parameterIndex, t_Type.getSimpleName(), t_Type, sql, conversionUtils);

                try
                {
                    t_Method.invoke(statement, parameterIndex + 1, t_ParameterValue);
                }
                catch  (@NotNull final IllegalAccessException illegalAccessException)
                {
                    if  (t_Log != null)
                    {
                        t_Log.warn(
                            COULD_NOT_BIND_PARAMETER_VIA
                            + PREPARED_STATEMENT_SET + t_Type.getSimpleName()
                            + "(int, " + t_Type.getName() + ")",
                            illegalAccessException);
                    }

                    exceptionToThrow =
                        new UnsupportedCustomSqlParameterTypeException(
                            t_Type.getSimpleName(),
                            parameterIndex + 1,
                            parameter.getName(),
                            sql,
                            illegalAccessException);
                }
                catch  (@NotNull final InvocationTargetException invocationTargetException)
                {
                    if  (t_Log != null)
                    {
                        t_Log.warn(
                            COULD_NOT_BIND_PARAMETER_VIA
                            + PREPARED_STATEMENT_SET + t_Type.getSimpleName()
                            + "(int, " + t_Type.getName() + ")",
                            invocationTargetException);
                    }

                    exceptionToThrow =
                        new UnsupportedCustomSqlParameterTypeException(
                            t_Type.getSimpleName(),
                            parameterIndex + 1,
                            parameter.getName(),
                            sql,
                            invocationTargetException);
                }
            }

            if  (exceptionToThrow != null)
            {
                throw exceptionToThrow;
            }
        }
        //To change body of created methods use File | Settings | File Templates.
    }
}
