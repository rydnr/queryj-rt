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
 * Filename: AbstractTableAttributesListDecorator.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Provides some common logic for table list decorators.
 *
 * Date: 2013/12/30
 * Time: 11:00
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.Sql;
import org.acmsl.queryj.metadata.AbstractPartialListDecorator.Operation;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.ForeignKey;
import org.acmsl.queryj.metadata.vo.Row;
import org.acmsl.queryj.metadata.vo.Table;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing JDK classes.
 */
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides some common logic for table list decorators.
 * @param <V> the type of the items.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2013/12/30 11:00
 */
@ThreadSafe
public abstract class AbstractTableListDecorator<V>
    extends AbstractListDecorator<V>
    implements ListDecorator<V>,
               TableDecorator,
               TableListDecorator
{
    /**
     * The table decorator.
     */
    private TableDecorator m__Table;

    /**
     * Creates a new instance.
     * @param list the {@link List}.
     * @param table the {@link TableDecorator}.
     */
    public AbstractTableListDecorator(
        @NotNull final List<V> list,
        @NotNull final TableDecorator table)
    {
        super(list);
        immutableSetTable(table);
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
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public PartialListDecorator getPlus()
    {
        return
            new TablePartialListDecorator<>(
                this, getTable(), Operation.PLUS);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public PartialListDecorator getMinus()
    {
        return
            new TablePartialListDecorator<>(
                this, getTable(), Operation.MINUS);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public PartialListDecorator getOnly()
    {
        return
            new TablePartialListDecorator<>(
                this, getTable(), Operation.ONLY);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public PartialListDecorator getDifferent()
    {
        throw new RuntimeException(INVALID_OPERATION);
    }

    // TableDecorator implementation

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getReadOnlyAttributes()
    {
        throw new RuntimeException(INVALID_OPERATION);
    }

    /**
     * Alias to make templates more readable.
     * @return the read-only attributes.
     */
    @SuppressWarnings("unused")
    @NotNull
    public ListDecorator<Attribute<DecoratedString>> getReadOnly()
    {
        return getReadOnlyAttributes();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Table<DecoratedString, Attribute<DecoratedString>, ListDecorator<Attribute<DecoratedString>>>>
    getAllParentTables()
    {
        throw new RuntimeException(INVALID_OPERATION);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getExternallyManagedAttributes()
    {
        throw new RuntimeException(INVALID_OPERATION);
    }

    /**
     * Alias to make templates more readable.
     * @return the externally-managed attributes.
     */
    @SuppressWarnings("unused")
    @NotNull
    public ListDecorator<Attribute<DecoratedString>> getExternallyManaged()
    {
        return getExternallyManagedAttributes();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Sql<DecoratedString>> getDynamicQueries()
    {
        throw new RuntimeException(INVALID_OPERATION);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Row<DecoratedString>> getStaticContent()
    {
        throw new RuntimeException(INVALID_OPERATION);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Result<DecoratedString>> getCustomResults()
    {
        throw new RuntimeException(INVALID_OPERATION);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<DecoratedString> getAttributeTypes()
    {
        return
            getAttributeTypes(
                retrieveAttributes(getItems()),
                getMetadataManager().getMetadataTypeManager(),
                TableDecoratorHelper.getInstance());
    }

    /**
     * Retrieves the attributes.
     * @param items the items.
     * @return the items, if they're the attributes. An empty list otherwise.
     */
    @NotNull
    protected List<Attribute<DecoratedString>> retrieveAttributes(@NotNull final List<V> items)
    {
    }
        /**
         * Retrieves the attributes.
         * @param items the items.
         * @return the items, if they're the attributes. An empty list otherwise.
         */
    @NotNull
    protected List<Attribute<DecoratedString>> retrieveAttributes(@NotNull final List<V> items)
    {
        @NotNull final List<DecoratedString> result;

        if (tableDecoratorHelper.isListOfAttributes(items))
        {
            result =
                tableDecoratorHelper.getAttributeTypes(
                    (List<Attribute<DecoratedString>>) items, metadataTypeManager);
        }
        else
        {
            result = new ArrayList<>(0);
        }

        return result;

    }
    /**
     * Retrieves the types of the attributes.
     * @param items such items.
     * @param metadataTypeManager the {@link MetadataTypeManager} instance.
     * @param tableDecoratorHelper the {@link TableDecoratorHelper} instance.
     * @return their types.
     */
    @SuppressWarnings("unchecked")
    @NotNull
    protected List<DecoratedString> getAttributeTypes(
        @NotNull final List<Attribute<DecoratedString>> items,
        @NotNull final MetadataTypeManager metadataTypeManager,
        @NotNull final TableDecoratorHelper tableDecoratorHelper)
    {
        @NotNull final List<DecoratedString> result;

        if (tableDecoratorHelper.isListOfAttributes(items))
        {
            result =
                tableDecoratorHelper.getAttributeTypes(
                    (List<Attribute<DecoratedString>>) items, metadataTypeManager);
        }
        else
        {
            result = new ArrayList<>(0);
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<DecoratedString> getNullableAttributeTypes()
    {
        return
            getAttributeTypes(
                getNullableAttributes(),
                getMetadataManager().getMetadataTypeManager(),
                TableDecoratorHelper.getInstance());
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<Attribute<DecoratedString>> getNullableAttributes()
    {
        return getNullableAttributes(getItems(), TableDecoratorHelper.getInstance());
    }

    /**
     * Retrieves the nullable attributes.
     * @param items the attributes.
     * @param tableDecoratorHelper the {@link TableDecoratorHelper} instance.
     * @return the nullable attributes.
     */
    @SuppressWarnings("unchecked")
    @NotNull
    public List<Attribute<DecoratedString>> getNullableAttributes(
        @NotNull final List<V> items,
        @NotNull final TableDecoratorHelper tableDecoratorHelper)
    {
        @NotNull final List<Attribute<DecoratedString>> result;

        if (tableDecoratorHelper.isListOfAttributes(items))
        {
            result =
                tableDecoratorHelper.filterNullableAttributes(
                    (List<Attribute<DecoratedString>>) items);
        }
        else
        {
            result = new ArrayList<>(0);
        }

        return result;
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
        return getTable().getPrimaryKey();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public ListDecorator<Attribute<DecoratedString>> getAttributes()
    {
        return getTable().getAttributes();
    }

    /**
     * Alias to make templates more readable.
     * @return the table's own attributes.
     */
    @SuppressWarnings("unused")
    @NotNull
    public ListDecorator<Attribute<DecoratedString>> getOwn()
    {
        return getAttributes();
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
    public boolean isVoDecorated()
    {
        return getTable().isVoDecorated();
    }

    /**
     * Checks whether the items include any Clob attribute.
     * @return {@code true} in such case.
     */
    public boolean getContainsClobs()
    {
        return contains(getAttributes(), Types.CLOB);
    }

    /**
     * Checks whether given attributes include any of a certain type.
     * @param attributes the attributes.
     * @param typeId the type id.
     * @return {@code true} in such case.
     */
    protected boolean contains(
        @NotNull final List<Attribute<DecoratedString>> attributes, final int typeId)
    {
        boolean result = false;

        for (@Nullable final Attribute<DecoratedString> attribute : attributes)
        {
            if (   (attribute != null)
                && (attribute.getTypeId() == typeId))
            {
                result = true;
                break;
            }
        }

        return result;
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
     * Retrieves the metadata manager.
     *
     * @return such instance.
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
    public ListDecorator<Attribute<DecoratedString>> getAllAttributes()
    {
        return getTable().getAllAttributes();
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
     * @return the child attributes.
     */
    @Nullable
    @Override
    public ListDecorator<Attribute<DecoratedString>> getChild()
    {
        return getTable().getChild();
    }

    /**
     * Retrieves the attribute used to label the static rows in the table.
     *
     * @return such attribute.
     */
    @Nullable
    @Override
    public Attribute<DecoratedString> getStaticAttribute()
    {
        return getTable().getStaticAttribute();
    }

    /**
     * Retrieves whether is a relationship table.
     *
     * @return such information.
     */
    @Override
    public boolean isRelationship()
    {
        return getTable().isRelationship();
    }

    /**
     * Compares given instance with the one wrapped by this instance.
     * @param table the table to compare with.
     * @return the result of comparing given instance with the wrapped one.
     */
    @Override
    public int compareTo(final Table<DecoratedString, Attribute<DecoratedString>, ListDecorator<Attribute<DecoratedString>>> table)
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
              "{ \"class\": " + AbstractTableListDecorator.class.getSimpleName() + '"'
            + ", \"package\": \"org.acmsl.queryj.metadata\""
            + ", \"table\": \"" + m__Table.getName()
            + "\" }";
    }
}
