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
import org.acmsl.commons.utils.StringUtils;
import org.acmsl.queryj.Literals;
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.exceptions.InvalidCustomSqlException;
import org.acmsl.queryj.api.exceptions.InvalidCustomSqlParameterException;
import org.acmsl.queryj.api.exceptions.NoValidationValueForCustomSqlDateParameterException;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.api.exceptions.UnsupportedCustomSqlParameterTypeException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Parameter;
import org.acmsl.queryj.customsql.ParameterRef;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.handlers.CustomSqlValidationHandler;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.SqlParameterDAO;
import org.acmsl.queryj.metadata.TypeManager;
import org.acmsl.queryj.tools.handlers.AbstractQueryJCommandHandler;
import org.apache.commons.logging.Log;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    /**
     * Retrieves the type of the parameter.
     * @param parameter the {@link Parameter}.
     * @param typeManager the {@link org.acmsl.queryj.metadata.MetadataTypeManager}.
     * @param <T> the type.
     * @return the parameter type.
     */
    @SuppressWarnings("unchecked")
    protected <T> Class<T> retrieveType(
        @NotNull final Parameter<String, T> parameter, @NotNull final TypeManager typeManager)
    {
        return (Class<T>) typeManager.getClass(parameter.getType());
    }

    /**
     * Retrieves the method to invoke on {@link PreparedStatement} class to bind the parameter value.
     * @param parameter the {@link Parameter}.
     * @param parameterIndex the index of the parameter.
     * @param type the parameter type.
     * @param sql the sql.
     * @throws QueryJBuildException if some problem occurs.
     */
    @NotNull
    protected Method retrievePreparedStatementMethod(
        @NotNull final Parameter<String, ?> parameter,
        final int parameterIndex,
        @NotNull final Class<?> type,
        @NotNull final Sql<String> sql,
        @NotNull final Collection<Class<?>> parameterClasses)
        throws  QueryJBuildException
    {
        @Nullable QueryJBuildException exceptionToThrow = null;

        @Nullable Method result = null;

        try
        {
            result =
                retrieveMethod(
                    PreparedStatement.class,
                    getSetterMethod(type),
                    parameterClasses.toArray(new Class<?>[parameterClasses.size()]));
        }
        catch  (@NotNull final NoSuchMethodException noSuchMethodException)
        {
            exceptionToThrow =
                new UnsupportedCustomSqlParameterTypeException(
                    type.getSimpleName(),
                    parameterIndex + 1,
                    parameter.getName(),
                    sql,
                    noSuchMethodException);
        }

        if  (exceptionToThrow != null)
        {
            throw exceptionToThrow;
        }

        return result;
    }

    /**
     * Retrieves the validation value for given parameter.
     * @param parameter the {@link Parameter}.
     * @param parameterIndex the index of the parameter.
     * @param type the parameter type.
     * @param typeClass the class of the parameter type.
     * @param sql the {@link Sql}.
     * @param conversionUtils the {@link ConversionUtils} instance.
     * @return the validation value.
     * @throws QueryJBuildException if some problem occurs.
     */
    @SuppressWarnings("unchecked")
    protected <T> T retrieveParameterValue(
        @NotNull final Parameter<String, T> parameter,
        final int parameterIndex,
        @NotNull final String type,
        @NotNull final Class<T> typeClass,
        @NotNull final Sql<String> sql,
        @NotNull final ConversionUtils conversionUtils)
        throws  QueryJBuildException
    {
        @Nullable T result;

        if  (   ("Date".equals(type))
                && (parameter.getValidationValue() != null))
        {
            result = (T) new java.sql.Date(new Date().getTime());
        }
        else if (   (Literals.TIMESTAMP_U.equals(type.toUpperCase(new Locale("US"))))
                    && (parameter.getValidationValue() != null))
        {
            result = (T) new Timestamp(new Date().getTime());
        }
        else
        {
            result =
                retrieveParameterValue(
                    parameter, type, conversionUtils, StringUtils.getInstance());
        }

        if (result == null)
        {
            result = (T) assumeIsADate(parameter, sql);
        }

        if (result == null)
        {
            // We have only once chance: constructor call.
            result = createViaConstructor(parameter, parameterIndex, type, typeClass, sql);
        }

        return result;
    }

    /**
     * Retrieves the validation value for given parameter.
     * @param parameter the {@link Parameter}.
     * @param type the parameter type.
     * @param conversionUtils the {@link ConversionUtils} instance.
     * @param stringUtils the {@link StringUtils} instance.
     * @param <T> the type.
     * @return the validation value.
     * @throws QueryJBuildException if some problem occurs.
     */
    @SuppressWarnings("unchecked")
    protected <T> T retrieveParameterValue(
        @NotNull final Parameter<String, T> parameter,
        @NotNull final String type,
        @NotNull final ConversionUtils conversionUtils,
        @NotNull final StringUtils stringUtils)
        throws  QueryJBuildException
    {
        @Nullable T result = null;

        try
        {
            @Nullable final Method t_ParameterMethod;

            t_ParameterMethod =
                conversionUtils.getClass().getMethod(
                    "to" + stringUtils.capitalize(type),
                    CLASS_ARRAY_OF_ONE_STRING);

            if  (t_ParameterMethod != null)
            {
                result =
                    (T) t_ParameterMethod.invoke(
                        conversionUtils,
                        parameter.getValidationValue());
            }
        }
        catch  (@NotNull final NoSuchMethodException noSuchMethod)
        {
            // it's not a plain type.
        }
        catch  (@NotNull final SecurityException securityMethod)
        {
            // can do little
        }
        catch  (@NotNull final IllegalAccessException illegalAccessException)
        {
            // can do little
        }
        catch  (@NotNull final InvocationTargetException invocationTargetException)
        {
            // can do little
        }

        return result;
    }

    /**
     * Tries to retrieve a Date value from given parameter.
     * @param parameter the {@link Parameter}.
     * @param sql the {@link Sql}.
     * @return the {@link Date} value if it's a Date.
     * @throws QueryJBuildException if some problem occurs.
     */
    protected Date assumeIsADate(
        @NotNull final Parameter<String, ?> parameter,
        @NotNull final Sql<String> sql)
        throws  QueryJBuildException
    {
        @Nullable Date result = null;

        @Nullable QueryJBuildException exceptionToThrow = null;

        // let's try if it's a date.
        try
        {
            boolean t_bInvalidValidationValue = false;

            Object t_strValidationValue =
                parameter.getValidationValue();

            @NotNull final DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
            if  (t_strValidationValue == null)
            {
                t_strValidationValue = formatter.format(new Date());
                t_bInvalidValidationValue = true;
            }

            try
            {
                result = formatter.parse("" + t_strValidationValue);
            }
            catch (@NotNull final NumberFormatException invalidDate)
            {
                try
                {
                    result = new SimpleDateFormat(DATE_FORMAT_EN).parse("" + t_strValidationValue);
                }
                catch (@NotNull final NumberFormatException invalidEnglishDate)
                {
                    // It doesn't need to be a date.
                }
            }

            if  (t_bInvalidValidationValue)
            {
                exceptionToThrow =
                    new NoValidationValueForCustomSqlDateParameterException(
                        parameter, sql);
            }
        }
        catch  (@NotNull final ParseException parseException)
        {
            // It doesn't need to be a date.
        }

        if  (exceptionToThrow != null)
        {
            throw exceptionToThrow;
        }

        return result;
    }

    /**
     * Creates the validation value via constructor.
     * @param parameter the {@link Parameter}.
     * @param parameterIndex the index of the parameter.
     * @param type the parameter type.
     * @param typeClass the class of the parameter type.
     * @param sql the {@link Sql}.
     * @param <T> the type.
     * @return the parameter value.
     * @throws QueryJBuildException if some problem occurs.
     */
    protected <T> T createViaConstructor(
        @NotNull final Parameter<String, T> parameter,
        final int parameterIndex,
        @NotNull final String type,
        @NotNull final Class<T> typeClass,
        @NotNull final Sql<String> sql)
        throws  QueryJBuildException
    {
        @Nullable T result = null;

        @Nullable QueryJBuildException exceptionToThrow = null;

        // We have only once chance: constructor call.
        try
        {
            @Nullable final Constructor<T> t_Constructor =
                typeClass.getConstructor(CLASS_ARRAY_OF_ONE_STRING);

            if  (t_Constructor != null)
            {
                result =
                    t_Constructor.newInstance(
                        parameter.getValidationValue());
            }
        }
        catch  (@NotNull final NoSuchMethodException noSuchMethod)
        {
            exceptionToThrow =
                new UnsupportedCustomSqlParameterTypeException(
                    type,
                    parameterIndex + 1,
                    parameter.getName(),
                    sql,
                    noSuchMethod);
        }
        catch  (@NotNull final SecurityException securityException)
        {
            exceptionToThrow =
                new UnsupportedCustomSqlParameterTypeException(
                    type,
                    parameterIndex + 1,
                    parameter.getName(),
                    sql,
                    securityException);
        }
        catch  (@NotNull final IllegalAccessException illegalAccessException)
        {
            exceptionToThrow =
                new UnsupportedCustomSqlParameterTypeException(
                    type,
                    parameterIndex + 1,
                    parameter.getName(),
                    sql,
                    illegalAccessException);
        }
        catch  (@NotNull final InstantiationException instantiationException)
        {
            exceptionToThrow =
                new UnsupportedCustomSqlParameterTypeException(
                    type,
                    parameterIndex + 1,
                    parameter.getName(),
                    sql,
                    instantiationException);
        }
        catch  (@NotNull final InvocationTargetException invocationTargetException)
        {
            exceptionToThrow =
                new UnsupportedCustomSqlParameterTypeException(
                    type,
                    parameterIndex + 1,
                    parameter.getName(),
                    sql,
                    invocationTargetException);
        }

        if  (exceptionToThrow != null)
        {
            throw exceptionToThrow;
        }

        return result;
    }

    /**
     * Retrieves the parameters for given sql element.
     * @param sql such element.
     * @param parameterDAO the {@link org.acmsl.queryj.metadata.SqlParameterDAO} instance.
     * @return the parameter elements.
     */
    protected List<Parameter<String, ?>> retrieveParameterElements(
        @NotNull final Sql<String> sql, @NotNull final SqlParameterDAO parameterDAO)
    {
        @NotNull final List<Parameter<String, ?>> result = new ArrayList<>();

        Parameter<String, ?> t_Parameter;

        for (@Nullable final ParameterRef t_ParameterRef : sql.getParameterRefs())
        {
            if (t_ParameterRef != null)
            {
                t_Parameter = parameterDAO.findByPrimaryKey(t_ParameterRef.getId());

                if (t_Parameter != null)
                {
                    result.add(t_Parameter);
                }
            }
        }

        return result;
    }

    /**
     * Retrieves the setter method name.
     * @param type the data type.
     * @return the associated setter method.
     */
    protected String getSetterMethod(final Class<?> type)
    {
        return getAccessorMethod("set",  type, StringUtils.getInstance());
    }

    /**
     * Retrieves the getter method name.
     * @param type the data type.
     * @return the associated getter method.
     */
    @NotNull
    protected String getGetterMethod(@NotNull final Class<?> type)
    {
        return getAccessorMethod("get", type, StringUtils.getInstance());
    }
}
