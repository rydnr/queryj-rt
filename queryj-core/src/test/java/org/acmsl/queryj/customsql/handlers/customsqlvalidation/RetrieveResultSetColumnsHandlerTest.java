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
 * Filename: RetrieveResultSetColumnsHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/16
 * Time: 11:07
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
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.SqlPropertyDAO;
import org.acmsl.queryj.metadata.SqlResultDAO;
import org.acmsl.queryj.metadata.TableDAO;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.Table;
import org.acmsl.queryj.tools.handlers.DatabaseMetaDataRetrievalHandler;
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

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/16 11:07
 */
@RunWith(JUnit4.class)
public class RetrieveResultSetColumnsHandlerTest
{
    @Test
    public void builds_a_list_of_properties_from_the_ResultSetMetadata()
        throws QueryJBuildException,
               SQLException
    {
        @NotNull final RetrieveResultSetColumnsHandler instance = new RetrieveResultSetColumnsHandler();

        @NotNull final QueryJCommand t_Parameters = new ConfigurationQueryJCommandImpl(new PropertiesConfiguration());

        @NotNull final ResultSet t_ResultSet = PowerMock.createNiceMock(ResultSet.class);
        @NotNull final ResultSetMetaData t_ResultSetMetaData = PowerMock.createNiceMock(ResultSetMetaData.class);

        EasyMock.expect(t_ResultSet.getMetaData()).andReturn(t_ResultSetMetaData);

        @NotNull final List<Property<String>> t_lProperties = new ArrayList<>(2);
        t_lProperties.add(new PropertyElement<>("name", "name", 1, String.class.getSimpleName(), false));
        t_lProperties.add(new PropertyElement<>("tmst", "tmst", 1, "Date", false));

        @NotNull final Result<String> t_Result = new ResultElement<>("r1", "Vo");
        t_Result.add(new PropertyRefElement("name"));
        t_Result.add(new PropertyRefElement("tmst"));

        for (@NotNull final Property<String> t_Property : t_lProperties)
        {
            EasyMock.expect(t_ResultSetMetaData.getColumnName(t_iIndex)).andReturn(t_Property.getColumnName());
            if (t_Property.getType().equals(String.class.getSimpleName()))
            {
                EasyMock.expect(t_ResultSet.getString(t_Property.getColumnName())).andReturn("1");
            }
            else if (t_Property.getType().equals("Date"))
            {
                EasyMock.expect(t_ResultSet.getDate(t_Property.getColumnName())).andReturn(new Date(new java.util.Date().getTime()));
            }
        }

        new QueryJCommandWrapper<Sql<String>>(t_Parameters).setSetting(RetrieveQueryHandler.CURRENT_SQL, t_Sql);
        new QueryJCommandWrapper<MetadataManager>(t_Parameters)
            .setSetting(DatabaseMetaDataRetrievalHandler.METADATA_MANAGER, t_MetadataManager);
        new QueryJCommandWrapper<CustomSqlProvider>(t_Parameters).setSetting(
            CustomSqlProviderRetrievalHandler.CUSTOM_SQL_PROVIDER, t_CustomSqlProvider);
        new QueryJCommandWrapper<Sql>(t_Parameters).setSetting(RetrieveQueryHandler.CURRENT_SQL, t_Sql);

        EasyMock.replay(t_CustomSqlProvider);
        EasyMock.replay(t_MetadataManager);
        EasyMock.replay(t_TableDAO);
        EasyMock.replay(t_Table);
        EasyMock.replay(t_PropertyDAO);
        EasyMock.replay(t_ResultDAO);
        EasyMock.replay(t_ResultSet);
        EasyMock.replay(t_Statement);

        new SetupPreparedStatementHandler().setCurrentPreparedStatement(t_Statement, t_Parameters);
        new ExecuteQueryHandler().handle(t_Parameters);
        new RetrieveResultPropertiesHandler().handle(t_Parameters);

        Assert.assertFalse(instance.handle(t_Parameters));

        EasyMock.verify(t_CustomSqlProvider);
        EasyMock.verify(t_MetadataManager);
        EasyMock.verify(t_TableDAO);
        EasyMock.verify(t_Table);
        EasyMock.verify(t_PropertyDAO);
        EasyMock.verify(t_ResultDAO);
        EasyMock.verify(t_ResultSet);
        EasyMock.verify(t_Statement);

    }
}
