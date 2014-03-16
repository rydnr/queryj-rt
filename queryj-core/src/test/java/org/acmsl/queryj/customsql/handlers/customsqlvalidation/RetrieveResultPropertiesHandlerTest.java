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
 * Filename: RetrieveResultPropertiesHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/15
 * Time: 16:34
 *
 */
package org.acmsl.queryj.customsql.handlers.customsqlvalidation;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.ConfigurationQueryJCommandImpl;
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Parameter;
import org.acmsl.queryj.customsql.ParameterElement;
import org.acmsl.queryj.customsql.ParameterRefElement;
import org.acmsl.queryj.customsql.Property;
import org.acmsl.queryj.customsql.PropertyElement;
import org.acmsl.queryj.customsql.PropertyRefElement;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.ResultElement;
import org.acmsl.queryj.customsql.ResultRefElement;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.Sql.Cardinality;
import org.acmsl.queryj.customsql.SqlElement;
import org.acmsl.queryj.customsql.handlers.CustomSqlProviderRetrievalHandler;
import org.acmsl.queryj.metadata.SqlParameterDAO;
import org.acmsl.queryj.metadata.SqlResultDAO;
import org.acmsl.queryj.tools.handlers.JdbcConnectionOpeningHandler;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.powermock.api.easymock.PowerMock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/15 16:34
 */
@RunWith(JUnit4.class)
public class RetrieveResultPropertiesHandlerTest
{
    @Test
    public void publishes_explicit_properties()
        throws  QueryJBuildException,
                SQLException
    {
        @NotNull final RetrieveResultPropertiesHandler instance = new RetrieveResultPropertiesHandler();

        @NotNull final QueryJCommand parameters = new ConfigurationQueryJCommandImpl(new PropertiesConfiguration());

        @NotNull final SqlElement<String> sql =
            new SqlElement<>(
                "id", "dao", "name", "String", Cardinality.SINGLE, "all", true /* validation */, false, "description");

        @NotNull final Property<String> property1 =
            new PropertyElement<>("name", "name", 1, String.class.getSimpleName(), false);
        @NotNull final Property<String> property2 =
            new PropertyElement<>("tmst", "tmst", 1, "Date", false);
        @NotNull final List<Property<String>> properties = new ArrayList<>(2);
        properties.add(property1);
        properties.add(property2);
        @NotNull final Result<String> t_Result = new ResultElement<>("r1", "Vo");
        t_Result.add(new PropertyRefElement("name"));
        t_Result.add(new PropertyRefElement("tmst"));

        sql.add(new ParameterRefElement("id"));
        sql.setResultRef(new ResultRefElement("r1"));
        new QueryJCommandWrapper<Sql<String>>(parameters).setSetting(RetrieveQueryHandler.CURRENT_SQL, sql);

        @NotNull final CustomSqlProvider t_CustomSqlProvider = PowerMock.createNiceMock(CustomSqlProvider.class);
        @NotNull final SqlResultDAO t_ResultDAO = PowerMock.createNiceMock(SqlResultDAO.class);
        @NotNull final ResultSet t_ResultSet = PowerMock.createNiceMock(ResultSet.class);
        @NotNull final PreparedStatement t_Statement = PowerMock.createNiceMock(PreparedStatement.class);
        new SetupPreparedStatementHandler().setCurrentPreparedStatement(t_Statement, parameters);
        EasyMock.expect(t_CustomSqlProvider.getSqlResultDAO()).andReturn(t_ResultDAO);
        EasyMock.expect(t_ResultDAO.findByPrimaryKey(t_Result.getId())).andReturn(t_Result);
        EasyMock.expect(t_Statement.executeQuery()).andReturn(t_ResultSet);

        new QueryJCommandWrapper<CustomSqlProvider>(parameters).setSetting(
            CustomSqlProviderRetrievalHandler.CUSTOM_SQL_PROVIDER, t_CustomSqlProvider);

        EasyMock.replay(t_CustomSqlProvider);
        EasyMock.replay(t_ResultDAO);
        EasyMock.replay(t_ResultSet);
        EasyMock.replay(t_Statement);

        new ExecuteQueryHandler().handle(parameters);

        Assert.assertFalse(instance.handle(parameters));

        EasyMock.verify(t_CustomSqlProvider);
        EasyMock.verify(t_ResultDAO);
        EasyMock.verify(t_ResultSet);
        EasyMock.verify(t_Statement);
    }
}
