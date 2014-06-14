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
public class AbstractPartialListDecorator
    implements PartialListDecorator,
               TableDecorator
{
    /**
     * The serial version id.
     */

    /**
     * The list decorator.
     */
    private ListDecorator<Attribute<DecoratedString>> m__ListDecorator;

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
        @NotNull final TableDecorator table,
        @NotNull final Operation operation)
    {
        immutableSetListDecorator(listDecorator);
        immutableSetTable(table);
        immutableSetOperation(operation);
    }

    /**
     * Specifies the list decorator.
     * @param listDecorator such instance.
     */
    protected final void immutableSetListDecorator(@NotNull final ListDecorator<Attribute<DecoratedString>> listDecorator)
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
     * Specifies the table.
     * @param table the table.
     */
    protected final void immutableSetTable(@NotNull final TableDecorator table)
    {
        this.m__Table = table;
    }

    /**
     * Specifies the table.
     * @param table the table.
     */
    @SuppressWarnings("unused")
    protected void setTable(@NotNull final TableDecorator table)
    {
        immutableSetTable(table);
    }

    /**
     * Retrieves the table.
     * @return such instance.
     */
    @NotNull
    public TableDecorator getTable()
    {
        return this.m__Table;
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

    // TableDecorator implementation

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getReadOnlyAttributes()
    {
        return getReadOnlyAttributes(getListDecorator(), getTable(), getOperation());
    }

    /**
     * An alias to make templates more readable.
     * @return the read-only attributes.
     */
    @SuppressWarnings("unused")
    @NotNull
    public ListDecorator<Attribute<DecoratedString>> getReadOnly()
    {
        @NotNull final ListDecorator<Attribute<DecoratedString>> result = getReadOnlyAttributes();

        return result;
    }

    /**
     * Retrieves the result of adding or removing the read-only attributes from the wrapped list.
     * @param list the list.
     * @param table the table.
     * @param operation the operation.
     * @return the resulting attributes.
     */
    @NotNull
    protected ListDecorator<Attribute<DecoratedString>> getReadOnlyAttributes(
        @NotNull final ListDecorator<Attribute<DecoratedString>> list,
        @NotNull final TableDecorator table,
        @NotNull final Operation operation)
    {
        @NotNull final ListDecorator<Attribute<DecoratedString>> result;

        @NotNull final List<Attribute<DecoratedString>> aux = new ArrayList<>(list);

        if (operation.equals(Operation.MINUS))
        {
            aux.removeAll(table.getReadOnlyAttributes());
        }
        else if (operation.equals(Operation.PLUS))
        {
            aux.addAll(table.getReadOnlyAttributes());
        }
        else
        {
            aux.retainAll(table.getReadOnlyAttributes());
        }

        result = new TableAttributesListDecorator(aux, table);

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Table<DecoratedString, Attribute<DecoratedString>, ListDecorator<Attribute<DecoratedString>>>>
    getAllParentTables()
    {
        return getTable().getAllParentTables();
    }

    /**
     * An alias to make templates more readable.
     * @return the externally managed attributes.
     */
    @SuppressWarnings("unused")
    @NotNull
    public ListDecorator<Attribute<DecoratedString>> getExternallyManaged()
    {
        @NotNull final ListDecorator<Attribute<DecoratedString>> result = getExternallyManagedAttributes();

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getExternallyManagedAttributes()
    {
        return getExternallyManagedAttributes(getListDecorator(), getTable(), getOperation());
    }

    /**
     * Retrieves the result of adding or removing the externally-managed attributes from the wrapped list.
     * @param list the list.
     * @param table the table.
     * @param operation the operation.
     * @return the resulting attributes.
     */
    @NotNull
    protected ListDecorator<Attribute<DecoratedString>> getExternallyManagedAttributes(
        @NotNull final ListDecorator<Attribute<DecoratedString>> list,
        @NotNull final TableDecorator table,
        @NotNull final Operation operation)
    {
        @NotNull final ListDecorator<Attribute<DecoratedString>> result;

        @NotNull final List<Attribute<DecoratedString>> aux = new ArrayList<>(list);

        if (operation.equals(Operation.MINUS))
        {
            aux.removeAll(table.getExternallyManagedAttributes());
        }
        else if (operation.equals(Operation.PLUS))
        {
            aux.addAll(table.getExternallyManagedAttributes());
        }
        else
        {
            aux.retainAll(table.getExternallyManagedAttributes());
        }

        result = new TableAttributesListDecorator(aux, table);

        return result;
    }

    /**
     * Conditionally adds each element of the source, to the destination list,
     * if it's not included already.
     * @param source the source.
     * @param destination the destination.
     */
    @SuppressWarnings("unchecked")
    protected void addAll(
        @NotNull final ListDecorator<Attribute<DecoratedString>> source,
        @NotNull final List<Attribute<DecoratedString>> destination)
    {
        for (@Nullable final Attribute<DecoratedString> item : source)
        {
            if (   (item != null)
                   && (!destination.contains(item)))
            {
                destination.add(item);
            }
        }
    }

    /**
     * Conditionally removes each element of the source, from the destination list,
     * if it's included already.
     * @param source the source.
     * @param destination the destination.
     */
    @SuppressWarnings("unused")
    protected void removeAll(
        @NotNull final List<Attribute<DecoratedString>> source,
        @NotNull final List<Attribute<DecoratedString>> destination)
    {
        for (@Nullable final Attribute<DecoratedString> item : source)
        {
            if (   (item != null)
                   && (destination.contains(item)))
            {
                destination.remove(item);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Sql<DecoratedString>> getDynamicQueries()
    {
        return getTable().getDynamicQueries();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Row<DecoratedString>> getStaticContent()
    {
        return getTable().getStaticContent();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Result<DecoratedString>> getDifferentCustomResults()
    {
        return getTable().getDifferentCustomResults();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<DecoratedString> getAttributeTypes()
    {
        return getTable().getAttributeTypes();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<DecoratedString> getNullableAttributeTypes()
    {
        return getTable().getNullableAttributeTypes();
    }

    // Table implementation
    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public DecoratedString getName()
    {
        return getTable().getName();
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public DecoratedString getComment()
    {
        return getTable().getComment();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getPrimaryKey()
    {
        return getPrimaryKey(getListDecorator(), getTable(), getOperation());
    }

    /**
     * Retrieves the result of adding or removing the primary key from the wrapped list.
     * @param list the list.
     * @param table the table.
     * @param operation the operation.
     * @return the resulting attributes.
     */
    @NotNull
    protected ListDecorator<Attribute<DecoratedString>> getPrimaryKey(
        @NotNull final ListDecorator<Attribute<DecoratedString>> list,
        @NotNull final TableDecorator table,
        @NotNull final Operation operation)
    {
        @NotNull final ListDecorator<Attribute<DecoratedString>> result;

        @NotNull final List<Attribute<DecoratedString>> aux = new ArrayList<>(list);

        if (operation.equals(Operation.MINUS))
        {
            aux.removeAll(table.getPrimaryKey());
        }
        else if (operation.equals(Operation.PLUS))
        {
            addAll(table.getPrimaryKey(), aux);
        }
        else
        {
            aux.retainAll(table.getPrimaryKey());
        }

        result = new TableAttributesListDecorator(aux, table);

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getAttributes()
    {
        return getAttributes(getListDecorator(), getTable(), getOperation());
    }

    /**
     * Retrieves the result of adding or removing the primary key from the wrapped list.
     * @param list the list.
     * @param table the table.
     * @param operation the operation.
     * @return the resulting attributes.
     */
    @NotNull
    protected ListDecorator<Attribute<DecoratedString>> getAttributes(
        @NotNull final ListDecorator<Attribute<DecoratedString>> list,
        @NotNull final TableDecorator table,
        @NotNull final Operation operation)
    {
        @NotNull final ListDecorator<Attribute<DecoratedString>> result;

        @NotNull final List<Attribute<DecoratedString>> aux = new ArrayList<>(list);

        if (operation.equals(Operation.MINUS))
        {
            aux.removeAll(table.getAttributes());
        }
        else if (operation.equals(Operation.PLUS))
        {
            addAll(table.getAttributes(), aux);
        }
        else
        {
            aux.retainAll(table.getAttributes());
        }

        result = new TableAttributesListDecorator(aux, table);

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<ForeignKey<DecoratedString>> getForeignKeys()
    {
        return getTable().getForeignKeys();
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public Table<DecoratedString, Attribute<DecoratedString>, ListDecorator<Attribute<DecoratedString>>>
    getParentTable()
    {
        return getTable().getParentTable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStatic()
    {
        return getTable().isStatic();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public Attribute<DecoratedString> getStaticAttribute()
    {
        return getTable().getStaticAttribute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isVoDecorated()
    {
        return getTable().isVoDecorated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRelationship()
    {
        return getTable().isRelationship();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public MetadataManager getMetadataManager()
    {
        return getTable().getMetadataManager();
    }

    /**
     * Retrieves all attributes, including parent's.
     *
     * @return such attributes.
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getAll()
    {
        return getTable().getAll();
    }

    /**
     * Checks whether any attribute is a clob.
     *
     * @return {@code true} in such case.
     */
    @Override
    public boolean getContainsClobs()
    {
        return getTable().getContainsClobs();
    }

    /**
     * Retrieves all attributes, including parent's.
     *
     * @return such attributes.
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getAllAttributes()
    {
        return getTable().getAll();
    }

    /**
     * Checks whether some of the attributes are nullable or not.
     *
     * @return {@code true} in such case.
     */
    @Override
    public boolean getContainsNullableAttributes()
    {
        return getTable().getContainsNullableAttributes();
    }

    /**
     * Checks whether some of the attributes cannot be null.
     *
     * @return {@code true} in such case.
     */
    @Override
    public boolean getContainsNotNullAttributes()
    {
        return getTable().getContainsNotNullAttributes();
    }

    /**
     * Retrieves the custom result.
     *
     * @return such {@link org.acmsl.queryj.metadata.ResultDecorator} element.
     */
    @Nullable
    @Override
    public Result<DecoratedString> getCustomResult()
    {
        return getTable().getCustomResult();
    }

    /**
     * Retrieves the custom selects.
     *
     * @return such list of {@link org.acmsl.queryj.customsql.Sql} elements.
     */
    @NotNull
    @Override
    public List<Sql<DecoratedString>> getCustomSelects()
    {
        return getTable().getCustomSelects();
    }

    /**
     * Retrieves the custom updates or inserts.
     *
     * @return such information.
     */
    @NotNull
    @Override
    public List<Sql<DecoratedString>> getCustomUpdatesOrInserts()
    {
        return getTable().getCustomUpdatesOrInserts();
    }

    /**
     * Retrieves the custom select-for-update queries.
     *
     * @return such list of {@link org.acmsl.queryj.customsql.Sql} elements.
     */
    @NotNull
    @Override
    public List<Sql<DecoratedString>> getCustomSelectsForUpdate()
    {
        return getTable().getCustomSelectsForUpdate();
    }

    /**
     * Retrieves the name of the parent table, or {@code null} if no parent exists.
     *
     * @return such information.
     */
    @Nullable
    @Override
    public DecoratedString getParentTableName()
    {
        return getTable().getParentTableName();
    }

    /**
     * Retrieves the parent foreign-key.
     *
     * @return such foreign key.
     */
    @Nullable
    @Override
    public ForeignKey<DecoratedString> getParentForeignKey()
    {
        return getTable().getParentForeignKey();
    }

    /**
     * Alias to make templates more readable.
     *
     * @return the table's own attributes.
     */
    @Nullable
    @Override
    public ListDecorator<Attribute<DecoratedString>> getOwn()
    {
        return getTable().getOwn();
    }

    /**
     * Alias to make templates more readable.
     *
     * @return the child attributes.
     */
    @Nullable
    @Override
    public ListDecorator<Attribute<DecoratedString>> getChild()
    {
        return getTable().getChild();
    }

    /**
     * Retrieves the nullable attributes.
     *
     * @return such list.
     */
    @NotNull
    @Override
    public List<Attribute<DecoratedString>> getNullableAttributes()
    {
        return getTable().getNullableAttributes();
    }

    /**
     * Compares the wrapped table to given one.
     * @param table the table to compare with.
     * @return the result of comparing them.
     */
    @Override
    public int compareTo(
        @Nullable final Table<DecoratedString, Attribute<DecoratedString>, ListDecorator<Attribute<DecoratedString>>> table)
    {
        return getTable().compareTo(table);
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