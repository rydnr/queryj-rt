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
 * Filename: AbstractResultDecoratorTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/05/15
 * Time: 10:59
 *
 */
package org.acmsl.queryj.metadata;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.customsql.Property;
import org.acmsl.queryj.customsql.PropertyRefElement;
import org.acmsl.queryj.customsql.Result;
import org.acmsl.queryj.customsql.ResultElement;
import org.acmsl.queryj.metadata.engines.JdbcMetadataTypeManager;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/15 10:59
 */
@RunWith(JUnit4.class)
public class AbstractResultDecoratorTest
{

    /**
     * Sets up an {@link AbstractResultDecorator} instance, for testing purposes.
     * @param properties the {@link org.acmsl.queryj.customsql.Property properties}.
     * @return the decorator.
     */
    @NotNull
    protected static AbstractResultDecorator setupResultDecorator(@NotNull final List<Property<String>> properties)
    {
        @NotNull final AbstractResultDecorator result;

        @NotNull final Result<String> wrappedResult = new ResultElement<>("my.result", "MyResult");

        @NotNull final CustomSqlProvider customSqlProvider = EasyMock.createNiceMock(CustomSqlProvider.class);
        @NotNull final SqlPropertyDAO propertyDAO = EasyMock.createNiceMock(SqlPropertyDAO.class);
        @NotNull final MetadataManager metadataManager = EasyMock.createNiceMock(MetadataManager.class);
        @NotNull final MetadataTypeManager metadataTypeManager = JdbcMetadataTypeManager.getInstance();
        @NotNull final DecoratorFactory decoratorFactory = CachingDecoratorFactory.getInstance();
        EasyMock.expect(customSqlProvider.getSqlPropertyDAO()).andReturn(propertyDAO).anyTimes();
        EasyMock.expect(metadataManager.getMetadataTypeManager()).andReturn(metadataTypeManager).anyTimes();

        for (@NotNull final Property<String> property : properties)
        {
            EasyMock.expect(propertyDAO.findByPrimaryKey(property.getId())).andReturn(property);
            wrappedResult.add(new PropertyRefElement(property.getId()));
        }

        EasyMock.replay(customSqlProvider);
        EasyMock.replay(propertyDAO);
        EasyMock.replay(metadataManager);

        result =
            new AbstractResultDecorator(wrappedResult, customSqlProvider, metadataManager, decoratorFactory) {};

        return result;
    }
}
