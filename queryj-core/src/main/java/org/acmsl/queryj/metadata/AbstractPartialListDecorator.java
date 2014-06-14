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
 * Filename: AbstractPartialListDecorator.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/06/14
 * Time: 17:54
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.ForeignKey;
import org.acmsl.queryj.metadata.vo.Row;
import org.acmsl.queryj.metadata.vo.Table;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/14 17:54
 */
@ThreadSafe
public abstract class AbstractPartialListDecorator<V>
    implements PartialListDecorator
{
    /**
     * The serial version id.
     */

    /**
     * The list decorator.
     */
    private ListDecorator<V> m__ListDecorator;

    /**
     * The operation types.
     */
    public static enum Operation
    {
        /**
         * The plus operation.
         */
        PLUS,
        /**
         * The minus operation.
         */
        MINUS,
        /**
         * The "only" operation.
         */
        ONLY,
        /**
         * The "different" operation.
         */
        DIFFERENT
    }

    /**
     * The operation.
     */
    private Operation m__Operation;

    /**
     * Creates a new instance.
     * @param listDecorator the {@link ListDecorator}.
     * @param operation the {@link Operation}.
     */
    public AbstractPartialListDecorator(
        @NotNull final ListDecorator<Attribute<DecoratedString>> listDecorator,
        @NotNull final Operation operation)
    {
        immutableSetListDecorator(listDecorator);
        immutableSetOperation(operation);
    }

    /**
     * Specifies the list decorator.
     * @param listDecorator such instance.
     */
    protected final void immutableSetListDecorator(@NotNull final ListDecorator<V> listDecorator)
    {
        this.m__ListDecorator = listDecorator;
    }

    /**
     * Specifies the list decorator.
     * @param listDecorator such instance.
     */
    @SuppressWarnings("unused")
    protected void setListDecorator(@NotNull final ListDecorator<Attribute<DecoratedString>> listDecorator)
    {
        immutableSetListDecorator(listDecorator);
    }

    /**
     * Retrieves the list decorator.
     * @return such instance.
     */
    @SuppressWarnings("unused")
    public ListDecorator<Attribute<DecoratedString>> getListDecorator()
    {
        return this.m__ListDecorator;
    }

    /**
     * Specifies the operation.
     * @param operation such operation.
     */
    protected final void immutableSetOperation(@NotNull final Operation operation)
    {
        this.m__Operation = operation;
    }

    /**
     * Specifies the operation.
     * @param operation such operation.
     */
    @SuppressWarnings("unused")
    protected void setOperation(@NotNull final Operation operation)
    {
        immutableSetOperation(operation);
    }

    /**
     * Retrieves the operation.
     * @return such operation.
     */
    public Operation getOperation()
    {
        return this.m__Operation;
    }

    // ListDecorator implementation
    /**
     * Retrieves the items.
     * @return such information.
     */
    @SuppressWarnings("unused")
    @NotNull
    public List<Attribute<DecoratedString>> getItems()
    {
        throw new RuntimeException(AbstractTableAttributesListDecorator.INVALID_OPERATION);
    }

    /**
     * Applies the "plus" operation to the items.
     * @return the partial result.
     */
    @NotNull
    public PartialListDecorator plus()
    {
        throw new RuntimeException(AbstractTableAttributesListDecorator.INVALID_OPERATION);
    }

    /**
     * Applies the "minus" operation to the items.
     * @return the partial result.
     */
    @NotNull
    public PartialListDecorator minus()
    {
        throw new RuntimeException(AbstractTableAttributesListDecorator.INVALID_OPERATION);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String toString()
    {
        return
              "{ \"listDecorator\": " + m__ListDecorator
            + ", \"operation\": " + m__Operation
            + ", \"class\": \"" + AbstractPartialListDecorator.class.getSimpleName() + '"'
            + ", \"package\": \"org.acmsl.queryj.metadata\" }";
    }
}
