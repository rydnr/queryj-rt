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
 * Filename: TableCustomResultsListDecorator.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: ListDecorator for custom results.
 *
 * Date: 2014/06/14
 * Time: 18:55
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.customsql.Result;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing JDK classes.
 */
import java.util.List;

/**
 * {@link ListDecorator} for custom results.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/14 18:55
 */
@ThreadSafe
public class TableCustomResultsListDecorator
    extends AbstractTableListDecorator<Result<DecoratedString>>
{
    /**
     * The serial version id.
     */
    private static final long serialVersionUID = 6374510951489078749L;

    /**
     * Creates a new instance.
     * @param list the list.
     * @param table the {@link TableDecorator table}.
     */
    public TableCustomResultsListDecorator(
        @NotNull final List<Result<DecoratedString>> list, @NotNull final TableDecorator table)
    {
        super(list, table);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Result<DecoratedString>> getItems()
    {

        return super.getItems();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Result<DecoratedString>> getItems(@NotNull final List<Result<DecoratedString>> rawItems)
    {

        return super.getItems();
    }
}
