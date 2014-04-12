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
 * Filename: AbstractTableAttributesListDecoratorTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for AbstractTableAttributesListDecorator.
 *
 * Date: 2014/04/12
 * Time: 06:38
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.ForeignKey;
import org.acmsl.queryj.metadata.vo.Table;
import org.acmsl.queryj.metadata.vo.TableValueObject;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing JUnit classes.
 */
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for {@link AbstractTableAttributesListDecorator}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/12 06:38
 */
@RunWith(JUnit4.class)
public class AbstractTableAttributesListDecoratorTest
{
    /**
     * Checks whether getContainsClobs() detects any Clob
     * attribute, when there is one.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void getContainsClobs_works_when_there_are_clobs()
    {
        @NotNull final List<Attribute<String>> attributes =
            new ArrayList<>();

        @NotNull final String name = "name";
        @NotNull final String comment = "comment";
        @NotNull final List<Attribute<String>> primaryKey = new ArrayList<>(0);
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

        @NotNull final Attribute<String> attribute = EasyMock.createNiceMock(Attribute.class);
        EasyMock.expect(attribute.getTypeId()).andReturn(Types.CLOB);
        EasyMock.replay(attribute);
        attributes.add(attribute);

        @NotNull final MetadataManager metadataManager = EasyMock.createNiceMock(MetadataManager.class);
        @NotNull final DecoratorFactory decoratorFactory = CachingDecoratorFactory.getInstance();
        @NotNull final CustomSqlProvider customSqlProvider = EasyMock.createNiceMock(CustomSqlProvider.class);

        @NotNull final TableDecorator tableDecorator =
            new CachingTableDecorator(table, metadataManager, decoratorFactory, customSqlProvider);

        @NotNull final AbstractTableAttributesListDecorator instance =
            new AbstractTableAttributesListDecorator(new ArrayList<Attribute<DecoratedString>>(0), tableDecorator)
            {
                /**
                 * {@inheritDoc}
                 */
                @Override
                public Attribute<DecoratedString> getStaticAttribute()
                {
                    return null;
                }

                /**
                 * {@inheritDoc}
                 */
                @Override
                public boolean isRelationship()
                {
                    return false;
                }
            };

        EasyMock.verify(attribute);
        Assert.assertTrue(instance.getContainsClobs());
    }

    /**
     * Checks whether getContainsClobs() detects any Clob
     * attribute, when there is none.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void getContainsClobs_works_when_there_are_no_clobs()
    {
        @NotNull final List<Attribute<String>> attributes =
            new ArrayList<>();

        @NotNull final String name = "name";
        @NotNull final String comment = "comment";
        @NotNull final List<Attribute<String>> primaryKey = new ArrayList<>(0);
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

        @NotNull final Attribute<String> attribute = EasyMock.createNiceMock(Attribute.class);
        EasyMock.expect(attribute.getTypeId()).andReturn(Types.CLOB);
        EasyMock.replay(attribute);
        attributes.add(attribute);

        @NotNull final MetadataManager metadataManager = EasyMock.createNiceMock(MetadataManager.class);
        @NotNull final DecoratorFactory decoratorFactory = CachingDecoratorFactory.getInstance();
        @NotNull final CustomSqlProvider customSqlProvider = EasyMock.createNiceMock(CustomSqlProvider.class);

        @NotNull final TableDecorator tableDecorator =
            new CachingTableDecorator(table, metadataManager, decoratorFactory, customSqlProvider);

        @NotNull final AbstractTableAttributesListDecorator instance =
            new AbstractTableAttributesListDecorator(new ArrayList<Attribute<DecoratedString>>(0), tableDecorator)
            {
                /**
                 * {@inheritDoc}
                 */
                @Override
                public Attribute<DecoratedString> getStaticAttribute()
                {
                    return null;
                }

                /**
                 * {@inheritDoc}
                 */
                @Override
                public boolean isRelationship()
                {
                    return false;
                }
            };

        EasyMock.verify(attribute);
        Assert.assertTrue(instance.getContainsClobs());
    }
}
