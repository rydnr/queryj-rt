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
 * Filename: CustomSqlValidationChainTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/16
 * Time: 18:26
 *
 */
package org.acmsl.queryj.customsql.handlers;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.commons.patterns.Chain;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.BindQueryParametersHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.CacheValidationOutcomeHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.CheckResultSetGettersWorkForDefinedPropertiesHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.ExecuteQueryHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.GlobalValidationEnabledHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.QueryValidationEnabledHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.ReportMissingPropertiesHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.ReportUnusedPropertiesHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.RetrieveQueryHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.RetrieveResultPropertiesHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.RetrieveResultSetColumnsHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.SetupPreparedStatementHandler;
import org.acmsl.queryj.customsql.handlers.customsqlvalidation.SkipValidationIfCacheExistsHandler;
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

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/16 18:26
 */
@RunWith(JUnit4.class)
public class CustomSqlValidationChainTest
{
    @Test
    public void includes_required_handlers()
        throws QueryJBuildException
    {
        @NotNull final CustomSqlValidationChain instance = new CustomSqlValidationChain();

        @NotNull final Chain t_Chain = EasyMock.createNiceMock(Chain.class);

        @SuppressWarnings("unchecked")
        instance.buildChain(t_Chain);

        Assert.assertTrue(instance.contains(BindQueryParametersHandler.class));
        Assert.assertTrue(instance.contains(CacheValidationOutcomeHandler.class));
        Assert.assertTrue(instance.contains(CheckResultSetGettersWorkForDefinedPropertiesHandler.class));
        Assert.assertTrue(instance.contains(ExecuteQueryHandler.class));
        Assert.assertTrue(instance.contains(GlobalValidationEnabledHandler.class));
        Assert.assertTrue(instance.contains(QueryValidationEnabledHandler.class));
        Assert.assertTrue(instance.contains(ReportMissingPropertiesHandler.class));
        Assert.assertTrue(instance.contains(ReportUnusedPropertiesHandler.class));
        Assert.assertTrue(instance.contains(RetrieveQueryHandler.class));
        Assert.assertTrue(instance.contains(RetrieveResultPropertiesHandler.class));
        Assert.assertTrue(instance.contains(RetrieveResultSetColumnsHandler.class));
        Assert.assertTrue(instance.contains(SetupPreparedStatementHandler.class));
        Assert.assertTrue(instance.contains(SkipValidationIfCacheExistsHandler.class));
    }
}
