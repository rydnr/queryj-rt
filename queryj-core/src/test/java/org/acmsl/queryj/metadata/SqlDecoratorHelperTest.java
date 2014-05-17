/*
                        QueryJ Core

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
 * Filename: SqlDecoratorHelperTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for SqlDecoratorHelper.
 *
 * Date: 2014/05/17
 * Time: 10:25
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Parameter;
import org.acmsl.queryj.customsql.ParameterElement;
import org.acmsl.queryj.customsql.ParameterRefElement;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.ResultElement;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.Sql.Cardinality;
import org.acmsl.queryj.customsql.SqlElement;
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

import java.util.List;

/**
 * Tests for {@link SqlDecoratorHelper}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/17 10:25
 */
@RunWith(JUnit4.class)
public class SqlDecoratorHelperTest
{
    /**
     * Tests getParameterTypes() returns no duplicates.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void getParameterTypes_returns_no_duplicates()
    {
        @NotNull final Sql<String> sql =
            new SqlElement<>("id1", "name1", "select", Cardinality.SINGLE, "all", false, false, "none", "desc1");

        @NotNull final Result<String> result =
            new ResultElement<>("r1", String.class.getSimpleName());

        @NotNull final Parameter parameter =
            new ParameterElement<String, String>("pid", 1, "paramName", "Date", null);

        sql.add(new ParameterRefElement("pid"));

        @NotNull final CustomSqlProvider customSqlProvider = EasyMock.createNiceMock(CustomSqlProvider.class);
        @NotNull final SqlResultDAO resultDAO = EasyMock.createNiceMock(SqlResultDAO.class);
        @NotNull final MetadataManager metadataManager = EasyMock.createNiceMock(MetadataManager.class);
        @NotNull final SqlParameterDAO parameterDAO = EasyMock.createNiceMock(SqlParameterDAO.class);

        EasyMock.expect(customSqlProvider.getSqlResultDAO()).andReturn(resultDAO);
        EasyMock.expect(customSqlProvider.getSqlParameterDAO()).andReturn(parameterDAO).anyTimes();
        EasyMock.expect(parameterDAO.findByPrimaryKey("pid")).andReturn(parameter).anyTimes();
        EasyMock.expect(resultDAO.findBySqlId(sql.getId())).andReturn(result);

        EasyMock.replay(customSqlProvider);
        EasyMock.replay(parameterDAO);
        EasyMock.replay(resultDAO);

        @NotNull final SqlDecorator instance =
            new AbstractSqlDecorator(sql, customSqlProvider, metadataManager) {};

        @NotNull final List<DecoratedString> parameterTypes = instance.getParameterTypes();

        Assert.assertEquals(1, parameterTypes.size());

        EasyMock.verify(customSqlProvider);
        EasyMock.verify(parameterDAO);
    }
}
