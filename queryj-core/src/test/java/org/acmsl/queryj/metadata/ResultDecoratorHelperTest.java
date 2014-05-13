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
 * Filename: ResultDecoratorHelperTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/05/13
 * Time: 07:30
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.Property;
import org.acmsl.queryj.customsql.PropertyElement;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.AttributeIncompleteValueObject;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
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
 * Created: 2014/05/13 07:30
 */
@RunWith(JUnit4.class)
public class ResultDecoratorHelperTest
{
    @Test
    public void containsNullableProperties_detects_nullable_properties()
    {
        @NotNull final ResultDecoratorHelper instance = ResultDecoratorHelper.getInstance();

        @NotNull final Property<String> property1 =
            new PropertyElement<>("prop1", "propertyId", 1, "long", false);

        @NotNull final Property<String> property2 =
            new PropertyElement<>("prop2", "name", 2, "String", false);

        @NotNull final Property<String> property3 =
            new PropertyElement<>("prop3", "date", 3, "Date", true);

        @NotNull final Property<String> property4 =
            new PropertyElement<>("prop4", "registration", 4, "Date", false);

        @NotNull final List<Property<String>> properties = new ArrayList<>(4);

        properties.add(property1);
        properties.add(property2);
        properties.add(property3);
        properties.add(property4);

        @NotNull final AbstractTableDecorator result =
            setupResultDecorator(attributes1, null);

        Assert.assertTrue(instance.containNullableAttributes(table1.getAttributes()));

        @NotNull final List<Attribute<String>> attributes2 = new ArrayList<>(2);

        @NotNull final AbstractTableDecorator table2 =
            AbstractTableDecoratorTest.setupTableDecorator(attributes1, null);

        attributes2.add(childAttribute1);
        attributes2.add(childAttribute3);

        Assert.assertTrue(instance.containNullableAttributes(table2.getAttributes()));

    }
}
