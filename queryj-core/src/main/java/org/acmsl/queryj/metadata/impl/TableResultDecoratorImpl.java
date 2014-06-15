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
 * Filename: TableResultDecoratorImpl.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/06/15
 * Time: 19:27
 *
 */
package org.acmsl.queryj.metadata.impl;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.metadata.DecoratedString;
import org.acmsl.queryj.metadata.ResultDecorator;
import org.acmsl.queryj.metadata.TableDecorator;
import org.acmsl.queryj.metadata.TableResultDecorator;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 *        Created: 2014/06/15 19:27
 */
@ThreadSafe
public class TableResultDecoratorImpl
    implements TableResultDecorator
{
    /**
     * The result.
     */
    @NotNull
    private Result<DecoratedString> m__Result;

    /**
     * The table.
     */
    @NotNull
    private TableDecorator m__Table;

    /**
     * Creates a new decorator.
     * @param item the {@link Result} to decorate.
     * @param table the {@link TableDecorator table}.
     */
    public TableResultDecoratorImpl(
        @NotNull final Result<DecoratedString> item, @NotNull final TableDecorator table)
    {
        immutableSetResult(item);
        immutableSetTable(table);
    }

    /**
     * Specifies the {@link Result result} to decorate.
     * @param result the result.
     */
    protected final void immutableSetResult(@NotNull final Result<DecoratedString> result)
    {
        this.m__Result = result;
    }

    /**
     * Specifies the {@link Result result} to decorate.
     * @param result the result.
     */
    @SuppressWarnings("unused")
    protected void setResult(@NotNull final Result<DecoratedString> result)
    {
        immutableSetResult(result);
    }

    /**
     * Retrieves the decorated {@link Result result}.
     * @return such instance.
     */
    @NotNull
    public Result<DecoratedString> getResult()
    {
        return this.m__Result;
    }

    /**
     * Specifies the {@link TableDecorator table}.
     * @param table such table.
     */
    protected final void immutableSetTable(@NotNull final TableDecorator table)
    {
        this.m__Table = table;
    }

    /**
     * Specifies the {@link TableDecorator table}.
     * @param table such table.
     */
    @SuppressWarnings("unused")
    protected void setTable(@NotNull final TableDecorator table)
    {
        immutableSetTable(table);
    }

    /**
     * Retrieves the {@link TableDecorator table}.
     * @return such instance.
     */
    @Override
    @NotNull
    public TableDecorator getTable()
    {
        return this.m__Table;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof TableResultDecoratorImpl))
        {
            return false;
        }

        TableResultDecoratorImpl that = (TableResultDecoratorImpl) o;

        if (!m__Result.equals(that.m__Result))
        {
            return false;
        }
        if (!m__Table.equals(that.m__Table))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = m__Result.hashCode();
        result = 31 * result + m__Table.hashCode();
        return result;
    }
}
