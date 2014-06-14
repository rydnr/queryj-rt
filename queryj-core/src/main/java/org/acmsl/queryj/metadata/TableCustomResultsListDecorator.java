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
 * Filename: TableCustomResultsListDecorator.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/06/14
 * Time: 18:55
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.ForeignKey;
import org.acmsl.queryj.metadata.vo.Table;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/14 18:55
 */
@ThreadSafe
public class TableCustomResultsListDecorator
    extends AbstractTableDecorator
{
    /**
     * Creates an {@code AbstractTableDecorator} with the following
     * information.
     *
     * @param table             the {@link org.acmsl.queryj.metadata.vo.Table}.
     * @param name              the name.
     * @param primaryKey        the primary key.
     * @param attributes        the attributes.
     * @param foreignKeys       the foreign keys.
     * @param parentTable       the parent table.
     * @param staticAttribute   the attribute used to label static contents.
     * @param voDecorated       whether the value-object should be decorated.
     * @param isRelationship    whether the table identifies a relationship.
     * @param metadataManager   the {@link org.acmsl.queryj.metadata.MetadataManager metadata manager}.
     * @param decoratorFactory  the {@link org.acmsl.queryj.metadata.DecoratorFactory decorator factory}.
     * @param customSqlProvider the {@link org.acmsl.queryj.customsql.CustomSqlProvider custom-sql provider}.
     */
    public TableCustomResultsListDecorator(@NotNull final Table<String, Attribute<String>, List<Attribute<String>>>
                                               table, @NotNull final String name, @NotNull final List<Attribute<String>> primaryKey, @NotNull final List<Attribute<String>> attributes, @NotNull final List<ForeignKey<String>> foreignKeys, @Nullable final Table<String, Attribute<String>, List<Attribute<String>>> parentTable, @Nullable final Attribute<String> staticAttribute, final boolean voDecorated, final boolean isRelationship, @NotNull final MetadataManager metadataManager, @NotNull final DecoratorFactory decoratorFactory, @NotNull final CustomSqlProvider customSqlProvider)
    {
        super(table,
              name,
              primaryKey,
              attributes,
              foreignKeys,
              parentTable,
              staticAttribute,
              voDecorated,
              isRelationship,
              metadataManager,
              decoratorFactory,
              customSqlProvider);
    }
}
