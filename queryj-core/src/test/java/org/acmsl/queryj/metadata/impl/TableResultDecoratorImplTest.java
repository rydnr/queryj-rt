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
 * Filename: TableResultDecoratorImplTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for TableResultDecoratorImpl.
 *
 * Date: 2014/06/20
 * Time: 05:37
 *
 */
package org.acmsl.queryj.metadata.impl;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.ResultElement;
import org.acmsl.queryj.metadata.AbstractTableDecorator;
import org.acmsl.queryj.metadata.AbstractTableListDecoratorTest.MyTableListDecorator;
import org.acmsl.queryj.metadata.DecoratedString;
import org.acmsl.queryj.metadata.DecoratorFactory;
import org.acmsl.queryj.metadata.ListDecorator;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.TableDecorator;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.Table;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit/EasyMock classes.
 */
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link TableResultDecoratorImpl}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/20 05:37
 */
@RunWith(JUnit4.class)
public class TableResultDecoratorImplTest
{
    /**
     *
     */
    public static class MyTableDecorator
        extends AbstractTableDecorator
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
            return new MyTableDecorator()
        }
    }
    /**
     * Checks whether isSingleBeingUsed() is correct depending on whether
     * the associated table has queries returning one sole instance of
     * the custom result.
     */
    @Test
    public void isSingleBeingUsed_returns_true_if_it_is_being_used_by_the_table_custom_selects()
    {
        @NotNull final Result<String> result =
            new ResultElement<>("id", "com.foo.bar.MyResult");

        @NotNull final TableDecorator table =
            new MyTableDecorator()
            {
                @Nullable
                @Override
                protected Table<DecoratedString, Attribute<DecoratedString>, ListDecorator<Attribute<DecoratedString>>> createTableDecorator(@Nullable final String parentTable, @NotNull final ListDecorator<Attribute<String>> primaryKey, @NotNull final ListDecorator<Attribute<String>> attributes, final boolean isStatic, final boolean voDecorated, @NotNull final MetadataManager metadataManager, @NotNull final DecoratorFactory decoratorFactory, @NotNull final CustomSqlProvider customSqlProvider)
                {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }
            };
        @NotNull final CustomSqlProvider customSqlProvider = EasyMock.createNiceMock(CustomSqlProvider.class);
        @NotNull final DecoratorFactory decoratorFactory = EasyMock.createNiceMock(DecoratorFactory.class);

        @NotNull final TableResultDecoratorImpl<String> instance =
            new TableResultDecoratorImpl<String>(
                result,
                table,
                customSqlProvider,
                decoratorFactory);
    }
}
