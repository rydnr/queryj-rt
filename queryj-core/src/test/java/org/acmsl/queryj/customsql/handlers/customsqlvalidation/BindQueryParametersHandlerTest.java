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
 * Filename: BindQueryParametersHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/15
 * Time: 08:03
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
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.Sql.Cardinality;
import org.acmsl.queryj.customsql.SqlElement;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.SqlParameterDAO;
import org.acmsl.queryj.metadata.TypeManager;
import org.acmsl.queryj.metadata.engines.JdbcTypeManager;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.powermock.api.easymock.PowerMock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/15 08:03
 */
@RunWith(JUnit4.class)
public class BindQueryParametersHandlerTest
{
    @Test
    public void binds_the_parameters_to_the_query()
        throws QueryJBuildException
    {
        @NotNull final BindQueryParametersHandler instance = new BindQueryParametersHandler();

        @NotNull final QueryJCommand parameters = new ConfigurationQueryJCommandImpl(new PropertiesConfiguration());

        @NotNull final Sql<String> sql =
            new SqlElement<>(
                "id", "dao", "name", "String", Cardinality.SINGLE, "all", false /* validation */, false, "description");

        @NotNull final Parameter<String, String> parameter =
            new ParameterElement<>("id", 1, )
        new QueryJCommandWrapper<Sql<String>>(parameters).setSetting(RetrieveQueryHandler.CURRENT_SQL, sql);

        // Add parameters to the command
        @NotNull final CustomSqlProvider t_CustomSqlProvider = PowerMock.createNiceMock(CustomSqlProvider.class);
        @NotNull final SqlParameterDAO t_SqlParameterDAO = PowerMock.createNiceMock(SqlParameterDAO.class);
        @NotNull final MetadataManager t_MetadataManager = PowerMock.createNiceMock(MetadataManager.class);
        @NotNull final Connection t_Connection = PowerMock.createNiceMock(Connection.class);
        @NotNull final PreparedStatement t_Statement = PowerMock.createNiceMock(PreparedStatement.class);
        @NotNull final ResultSet t_ResultSet = PowerMock.createNiceMock(ResultSet.class);
        EasyMock.expect(t_CustomSqlProvider.getSqlParameterDAO()).andReturn(t_SqlParameterDAO);
        EasyMock.expect(t_SqlParameterDAO.findByPrimaryKey("" + parameter.getName())).andReturn(parameter);

        EasyMock.replay(t_CustomSqlProvider);
        EasyMock.replay(t_SqlParameterDAO);
        EasyMock.replay(t_MetadataManager);
        EasyMock.replay(t_Connection);
        EasyMock.replay(t_Statement);
        EasyMock.replay(t_ResultSet);

        Assert.assertTrue(instance.handle(parameters));

    }
}
