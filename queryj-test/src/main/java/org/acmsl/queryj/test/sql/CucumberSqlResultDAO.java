/*
                        QueryJ Test

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
 * Filename: CucumberSqlResultDAO.java
 *
 * Author: Jose San Leandro Armendariz (chous)
 *
 * Description: A SqlResultDAO implementation wrapping a single or multiple
 *              Result instances.
 *
 * Date: 6/25/13
 * Time: 6:02 AM
 *
 */
package org.acmsl.queryj.test.sql;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.metadata.SqlResultDAO;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing JDK classes.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A {@link SqlResultDAO} implementation wrapping a single or multiple {@link Result} instances.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2013/06/25
 */
public class CucumberSqlResultDAO
    implements SqlResultDAO
{
    /**
     * The wrapped result list.
     */
    private List<Result<String>> m__lCustomResults;

    /**
     * Creates a DAO wrapping given result.
     * @param result such result.
     */
    public CucumberSqlResultDAO(@NotNull final Result<String> result)
    {
        immutableSetResultList(Arrays.asList(result));
    }

    /**
     * Creates a DAO wrapping given results.
     * @param results such results.
     */
    public CucumberSqlResultDAO(@NotNull final List<Result<String>> results)
    {
        immutableSetResultList(results);
    }

    /**
     * Specifies the custom result.
     * @param result such result.
     */
    protected final void immutableSetResultList(@NotNull final Result<String> result)
    {
        this.m__lCustomResults = result;
    }

    /**
     * Specifies the custom result.
     * @param result such result.
     */
    @SuppressWarnings("unused")
    protected void setResultList(@NotNull final Result<String> result)
    {
        immutableSetResultList(result);
    }

    /**
     * Retrieves the custom result.
     * @return such result.
     */
    @NotNull
    protected Result<String> getResultList()
    {
        return m__lCustomResults;
    }

    /**
     * Retrieves the {@link Result} matching given id.
     * @param id the result id.
     * @return such result.
     */
    @Nullable
    @Override
    public Result<String> findByPrimaryKey(@NotNull final String id)
    {
        return findByPrimaryKey(id, getResultList());
    }

    /**
     * Retrieves the {@link Result} matching given id.
     * @param id the result id.
     * @param customResult the custom result.
     * @return such result.
     */
    @Nullable
    protected Result<String> findByPrimaryKey(@NotNull final String id, @NotNull final Result<String> customResult)
    {
        @Nullable Result<String> result = null;

        if (id.equals(customResult.getId()))
        {
            result = customResult;
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public Result<String> findBySqlId(@NotNull final String sqlId)
    {
        return null;
    }

    /**
     * Finds the {@link Result} of given table.
     * @param table the table.
     * @return the result.
     */
    @NotNull
    @Override
    public Result<String> findByTable(@NotNull final String table)
    {
        return findByTable(table, getResultList());
    }

    /**
     * Finds nte {@link Result} of given type.
     * @param table the table name.
     * @param customResult the custom result.
     * @return the result.
     */
    @NotNull
    protected Result<String> findByTable(@NotNull final String table, @NotNull final Result<String> customResult)
    {
        @Nullable final Result<String> result;

        if (table.equals(customResult.getClassValue()))
        {
            result = customResult;
        }
        else
        {
            result = null;
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Result<String>> findAll()
    {
        return findAll(getResultList());
    }

    /**
     * Retrieves all custom {@link Result results}.
     * @param customResult the wrapped result.
     * @return a list of just that element.
     */
    @NotNull
    protected List<Result<String>> findAll(@NotNull final Result<String> customResult)
    {
        @NotNull final List<Result<String>> result = new ArrayList<>(1);

        result.add(customResult);

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public String toString()
    {
        return
              "{ \"class\": \"CucumberSqlResultDAO\""
            + ", \"result\": " + m__lCustomResults
            + ", \"package\": \"org.acmsl.queryj.test\""
            + " }";
    }
}
