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
 * Filename: CacheValidationOutcomeHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/03/16
 * Time: 15:07
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
import org.acmsl.queryj.customsql.CustomSqlProviderTest.SemiMockedAbstractCustomSqlProvider;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.ResultElement;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.customsql.Sql.Cardinality;
import org.acmsl.queryj.customsql.SqlConnectionFlagsDAO;
import org.acmsl.queryj.customsql.SqlElement;
import org.acmsl.queryj.customsql.SqlResultSetFlagsDAO;
import org.acmsl.queryj.customsql.SqlStatementFlagsDAO;
import org.acmsl.queryj.customsql.handlers.CustomSqlCacheWritingHandler;
import org.acmsl.queryj.customsql.handlers.CustomSqlProviderRetrievalHandler;
import org.acmsl.queryj.metadata.SqlDAO;
import org.acmsl.queryj.metadata.SqlParameterDAO;
import org.acmsl.queryj.metadata.SqlPropertyDAO;
import org.acmsl.queryj.metadata.SqlResultDAO;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/03/16 15:07
 */
@RunWith(JUnit4.class)
public class CacheValidationOutcomeHandlerTest
{
    /**
     * A temporary folder for testing hash caches.
     */
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void caches_validation_outcome_to_disk()
        throws QueryJBuildException
    {
        @NotNull final CacheValidationOutcomeHandler instance = new CacheValidationOutcomeHandler();

        @NotNull final Sql<String> t_Sql =
            new SqlElement<>("sql-id", "dao", "sql-name", "select", Cardinality.SINGLE, "all", true, false, "fake sql");

        @NotNull final Result<String> t_Result1 = new ResultElement<>("p1", "class1");

        @NotNull final SqlDAO sqlDAO = EasyMock.createNiceMock(SqlDAO.class);
        @NotNull final SqlParameterDAO parameterDAO = EasyMock.createNiceMock(SqlParameterDAO.class);
        @NotNull final SqlPropertyDAO propertyDAO = EasyMock.createNiceMock(SqlPropertyDAO.class);
        @NotNull final SqlResultDAO resultDAO = EasyMock.createNiceMock(SqlResultDAO.class);
        @NotNull final SqlConnectionFlagsDAO connectionFlagsDAO = EasyMock.createNiceMock(SqlConnectionFlagsDAO.class);
        @NotNull final SqlStatementFlagsDAO statementFlagsDAO = EasyMock.createNiceMock(SqlStatementFlagsDAO.class);
        @NotNull final SqlResultSetFlagsDAO resultSetFlagsDAO = EasyMock.createNiceMock(SqlResultSetFlagsDAO.class);
        @NotNull final List<Sql<String>> sqlList = new ArrayList<>(1);
        sqlList.add(t_Sql);

        @NotNull final CustomSqlProvider t_CustomSqlProvider =
            new SemiMockedAbstractCustomSqlProvider(
                sqlDAO,
                parameterDAO,
                propertyDAO,
                resultDAO,
                connectionFlagsDAO,
                statementFlagsDAO,
                resultSetFlagsDAO);

        @NotNull final QueryJCommand t_Command = new ConfigurationQueryJCommandImpl(new PropertiesConfiguration());

        new QueryJCommandWrapper<File>(t_Command).setSetting(
            CustomSqlCacheWritingHandler.CUSTOM_SQL_OUTPUT_FOLDER_FOR_HASHES, tempFolder.getRoot());
        new QueryJCommandWrapper<CustomSqlProvider>(t_Command).setSetting(
            CustomSqlProviderRetrievalHandler.CUSTOM_SQL_PROVIDER, t_CustomSqlProvider);

        EasyMock.expect(resultDAO.findBySqlId("sql-id")).andReturn(t_Result1).anyTimes();
        EasyMock.replay(resultDAO);

        @NotNull final Charset t_Charset = Charset.defaultCharset();

        @NotNull final String hash = t_CustomSqlProvider.getHash(t_Sql, t_Charset.displayName());

        instance.handle(t_Command);

        Assert.assertTrue(new File(tempFolder.getRoot() + File.separator + hash).exists());

        EasyMock.verify(sqlDAO);
        EasyMock.verify(resultDAO);
    }

    /**
     * Checks the conventions used when building hash files.
     */
    @Test
    public void hash_path_follows_convention()
    {
        Assert.assertEquals(
            tempFolder.getRoot().getAbsolutePath() + File.separator + "abc",
            new CustomSqlCacheWritingHandler().hashPath(tempFolder.getRoot().getAbsolutePath(), "abc"));
    }

    /**
     * Checks the logic to test whether a file exist, works.
     */
    @Test
    public void file_check_works()
    {
        Assert.assertTrue(new CustomSqlCacheWritingHandler().existsAlready(tempFolder.getRoot().getAbsolutePath()));
    }

    /**
     * Tests whether the hash for a given SQL is written to disk.
     */
    @Test
    public void sql_hash_does_not_get_written_if_it_exists_already()
        throws QueryJBuildException
    {
        @NotNull final CustomSqlCacheWritingHandler instance =
            new CustomSqlCacheWritingHandler()
            {
                /**
                 * {@inheritDoc}
                 */
                @Override
                public boolean existsAlready(@NotNull final String path)
                {
                    return true;
                }
            };

        @NotNull final Sql<String> t_Sql =
            new SqlElement<>("sql-id", "dao", "sql-name", "select", Cardinality.SINGLE, "all", true, false, "fake sql");

        @NotNull final Result<String> t_Result1 = new ResultElement<>("p1", "class1");

        @NotNull final SqlDAO sqlDAO = EasyMock.createNiceMock(SqlDAO.class);
        @NotNull final SqlParameterDAO parameterDAO = EasyMock.createNiceMock(SqlParameterDAO.class);
        @NotNull final SqlPropertyDAO propertyDAO = EasyMock.createNiceMock(SqlPropertyDAO.class);
        @NotNull final SqlResultDAO resultDAO = EasyMock.createNiceMock(SqlResultDAO.class);
        @NotNull final SqlConnectionFlagsDAO connectionFlagsDAO = EasyMock.createNiceMock(SqlConnectionFlagsDAO.class);
        @NotNull final SqlStatementFlagsDAO statementFlagsDAO = EasyMock.createNiceMock(SqlStatementFlagsDAO.class);
        @NotNull final SqlResultSetFlagsDAO resultSetFlagsDAO = EasyMock.createNiceMock(SqlResultSetFlagsDAO.class);
        @NotNull final List<Sql<String>> sqlList = new ArrayList<>(1);
        sqlList.add(t_Sql);

        @NotNull final CustomSqlProvider t_CustomSqlProvider =
            new SemiMockedAbstractCustomSqlProvider(
                sqlDAO,
                parameterDAO,
                propertyDAO,
                resultDAO,
                connectionFlagsDAO,
                statementFlagsDAO,
                resultSetFlagsDAO);

        @NotNull final QueryJCommand t_Command = new ConfigurationQueryJCommandImpl(new PropertiesConfiguration());
        new QueryJCommandWrapper<File>(t_Command).setSetting(
            CustomSqlCacheWritingHandler.CUSTOM_SQL_OUTPUT_FOLDER_FOR_HASHES, tempFolder.getRoot());
        new QueryJCommandWrapper<CustomSqlProvider>(t_Command).setSetting(
            CustomSqlProviderRetrievalHandler.CUSTOM_SQL_PROVIDER, t_CustomSqlProvider);

        EasyMock.expect(sqlDAO.findAll()).andReturn(sqlList).anyTimes();
        EasyMock.expect(resultDAO.findBySqlId("sql-id")).andReturn(t_Result1).anyTimes();
        EasyMock.replay(resultDAO);
        EasyMock.replay(sqlDAO);

        @NotNull final Charset t_Charset = Charset.defaultCharset();

        @NotNull final String hash = t_CustomSqlProvider.getHash(t_Sql, t_Charset.displayName());

        @NotNull final String path = instance.hashPath(tempFolder.getRoot().getAbsolutePath(), hash);

        Assert.assertFalse(new File(path).exists());

        instance.handle(t_Command);

        Assert.assertFalse(new File(path).exists());

        EasyMock.verify(sqlDAO);
        EasyMock.verify(resultDAO);
    }
        @NotNull final CacheValidationOutcomeHandler instance = new CacheValidationOutcomeHandler();

        @NotNull final QueryJCommand t_Parameters = new ConfigurationQueryJCommandImpl(new PropertiesConfiguration());

        @NotNull final SqlElement<String> t_Sql =
            new SqlElement<>(
                "id",
                "dao",
                "name",
                String.class.getSimpleName(),
                Cardinality.SINGLE,
                "all",
                true /* validation */,
                false,
                "description");
        new RetrieveQueryHandler().setCurrentSql(t_Sql, t_Parameters);

        Assert.assertFalse(instance.handle(t_Parameters));
    }
}
