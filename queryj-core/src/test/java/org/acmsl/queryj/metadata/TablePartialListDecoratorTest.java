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
 * Filename: TablePartialListDecoratorTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/06/15
 * Time: 11:21
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.metadata.AbstractPartialListDecorator.Operation;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.AttributeValueObject;
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

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/15 11:21
 */
@RunWith(JUnit4.class)
public class TablePartialListDecoratorTest
{
    @Test
    public void getDifferent_removes_duplicates()
    {
        @NotNull final List<Attribute<String>> list = new ArrayList<>(3);

        @NotNull final Attribute<String> attribute1 =
            new AttributeValueObject(
                "name1",
                Types.BIGINT,
                "long",
                "table";

            );
        @NotNull final TableDecorator tableDecorator = EasyMock.createNiceMock(TableDecorator.class);

        @NotNull final ListDecorator<Attribute<DecoratedString>> listDecorator =
            new TableAttributesListDecorator(list, tableDecorator);
        @NotNull final TablePartialListDecorator<Attribute<DecoratedString>> instance =
            new TablePartialListDecorator<>(
                listDecorator, tableDecorator, Operation.DIFFERENT);

        @NotNull final ListDecorator<Attribute<DecoratedString>> unique =
            instance.getDifferent();

        Assert.assertEquals(2, unique.size());
        Assert.assertTrue(unique.contains(attribute1));
        Assert.assertTrue(unique.contains(attribute2));
    }
}
