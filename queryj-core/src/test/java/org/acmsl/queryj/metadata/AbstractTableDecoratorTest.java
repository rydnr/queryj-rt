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
 * Filename: AbstractTableDecoratorTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for AbstractTableDecorator.
 *
 * Date: 2014/04/11
 * Time: 19:52
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
import org.acmsl.queryj.metadata.vo.TableValueObject;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link AbstractTableDecorator}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/11 19:52
 */
@RunWith(JUnit4.class)
public class AbstractTableDecoratorTest
{
    /**
     * Checks whethe getContainsClobs() is correct for tables with no Clob attributes.
     */
    @Test
    public void getContainsClobs_is_correct_if_table_does_not_contain_clobs()
    {
        @NotNull final String name = "name";
        @NotNull final String comment = "comment";
        @NotNull final List<Attribute<String>> primaryKey = new ArrayList<>(0);
        @NotNull final List<Attribute<String>> attributes = new ArrayList<>();
        @NotNull final List<ForeignKey<String>> foreignKeys = new ArrayList<>(0);
        @Nullable final Table<String, Attribute<String>, List<Attribute<String>>> parentTable = null;
        @Nullable final Attribute<String> staticAttribute = null;
        final boolean voDecorated = false;
        final boolean isRelationship = false;

        @NotNull final Table<String, Attribute<String>, List<Attribute<String>>> table =
            new TableValueObject(
                name,
                comment,
                primaryKey,
                attributes,
                foreignKeys,
                parentTable,
                staticAttribute,
                voDecorated,
                isRelationship);

        @NotNull final MetadataManager metadataManager = EasyMock.createNiceMock(MetadataManager.class);
        @NotNull final DecoratorFactory decoratorFactory = EasyMock.createNiceMock(DecoratorFactory.class);
        @NotNull final CustomSqlProvider customSqlProvider = EasyMock.createNiceMock(CustomSqlProvider.class);

        @NotNull final AbstractTableDecorator instance =
            new AbstractTableDecorator(table, metadataManager, decoratorFactory, customSqlProvider)
            {
                @Nullable
                @Override
                protected Table<DecoratedString, Attribute<DecoratedString>, ListDecorator<Attribute<DecoratedString>>> createTableDecorator(
                    @Nullable final String parentTable,
                    @NotNull final ListDecorator<Attribute<String>> primaryKey,
                    @NotNull final ListDecorator<Attribute<String>> attributes,
                    final boolean isStatic,
                    final boolean voDecorated,
                    @NotNull final MetadataManager metadataManager,
                    @NotNull final DecoratorFactory decoratorFactory,
                    @NotNull final CustomSqlProvider customSqlProvider)
                {
                    return null;
                }
            };

        Assert.assertFalse(instance.getContainsClobs());
    }
}
