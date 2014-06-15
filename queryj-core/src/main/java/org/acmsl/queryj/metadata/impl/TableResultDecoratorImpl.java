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
 * Filename: TableResultDecoratorImpl.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Obvious implementation of TableResultDecorator.
 *
 * Date: 2014/06/15
 * Time: 19:27
 *
 */
package org.acmsl.queryj.metadata.impl;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.metadata.AbstractResultDecorator;
import org.acmsl.queryj.metadata.DecoratedString;
import org.acmsl.queryj.metadata.DecoratorFactory;
import org.acmsl.queryj.metadata.TableDecorator;
import org.acmsl.queryj.metadata.TableResultDecorator;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Obvious implementation of {@link TableResultDecorator}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/15 19:27
 */
@ThreadSafe
public class TableResultDecoratorImpl<V>
    extends AbstractResultDecorator<V>
    implements TableResultDecorator<V>
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
        @NotNull final Result<V> item,
        @NotNull final TableDecorator table,
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final DecoratorFactory decoratorFactory)
    {
        super(item, customSqlProvider, table.getMetadataManager(), decoratorFactory);
        immutableSetTable(table);
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
        final boolean result;

        if (this == o)
        {
            result = true;
        }
        else if (!(o instanceof TableResultDecoratorImpl))
        {
            result = false;
        }
        else
        {
            @NotNull final TableResultDecoratorImpl that = (TableResultDecoratorImpl) o;

            if (!m__Result.equals(that.m__Result))
            {
                result = false;
            }
            else if (!m__Table.equals(that.m__Table))
            {
                result = false;
            }
            else
            {
                result = true;
            }
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        int result = super.hashCode();

        result = 31 * result + m__Table.hashCode();

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String toString()
    {
        return
              "{ \"result\": " + this.m__Result
            + ", \"table\": " + this.m__Table
            + ", \"class\": \"TableResultDecoratorImpl\""
            + ", \"package\": \"org.acmsl.queryj.metadata.impl\" }";
    }
}
