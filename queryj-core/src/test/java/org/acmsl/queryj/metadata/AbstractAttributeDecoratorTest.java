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
 * Filename: AbstractAttributeDecoratorTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/04/10
 * Time: 11:30
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.AttributeValueObject;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Types;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/10 11:30
 */
@RunWith(PowerMockRunner.class)
public class AbstractAttributeDecoratorTest
{
    @Test
    public void isStrictlyPrimitive_works_for_primitives()
    {
        @NotNull final MetadataManager metadataManager =
            EasyMock.createNiceMock(MetadataManager.class);

        @NotNull final MetadataTypeManager metadataTypeManager =
            EasyMock.createNiceMock(MetadataTypeManager.class);

        EasyMock.expect(metadataManager.getMetadataTypeManager()).andReturn(metadataTypeManager);

        EasyMock.replay(metadataManager);

        @NotNull final Attribute<String> attribute =
            new AttributeValueObject(
                "name",
                Types.BIGINT,
                "long",
                "tableName",
                "comment",
                1,
                10, // length
                1, // precision
                null, // keyword
                null, // retrieval query
                null, // sequence
                false, // nullable
                null, // value
                false, // read-only
                false, // is-bool
                null, // boolean-true
                null, // boolean-false
                null); // boolean-null

        @NotNull final AbstractAttributeDecorator instance =
            new AbstractAttributeDecorator(
                attribute,
                metadataManager) {};

        Assert.assertTrue(instance.isStrictlyPrimitive());
    }
}
