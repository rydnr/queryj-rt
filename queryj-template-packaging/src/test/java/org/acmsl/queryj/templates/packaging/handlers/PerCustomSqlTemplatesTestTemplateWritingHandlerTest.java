/*
                        QueryJ Template Packaging

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
 * Filename: PerCustomSqlTemplatesTestTemplateWritingHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for PerCustomSqlTemplatesTestTemplateWritingHandler.
 *
 * Date: 2014/04/17
 * Time: 10:14
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing QueryJ Template Packaging classes.
 */
import org.acmsl.queryj.templates.packaging.GlobalTemplateContext;
import org.acmsl.queryj.templates.packaging.PerCustomSqlTemplatesTestTemplate;
import org.acmsl.queryj.templates.packaging.PerCustomSqlTemplatesTestTemplateFactory;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit/EasyMock classes.
 */
import org.easymock.EasyMock;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link PerCustomSqlTemplatesTestTemplateWritingHandler}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/17 10:14
 */
@RunWith(JUnit4.class)
public class PerCustomSqlTemplatesTestTemplateWritingHandlerTest
    extends AbstractTemplatesTestTemplateWritingHandlerTest<
    PerCustomSqlTemplatesTestTemplateWritingHandler,
    PerCustomSqlTemplatesTestTemplateBuildHandler,
    PerCustomSqlTemplatesTestTemplate,
    PerCustomSqlTemplatesTestTemplateFactory,
    GlobalTemplateContext>
{
    /**
     * Creates a new writing handler instance.
     * @return such instance.
     */
    @NotNull
    @Override
    protected PerCustomSqlTemplatesTestTemplateBuildHandler createBuildHandlerInstance()
    {
        return new PerCustomSqlTemplatesTestTemplateBuildHandler();
    }

    /**
     * Creates a new writing handler instance.
     * @return such instance.
     */
    @NotNull
    @Override
    protected PerCustomSqlTemplatesTestTemplateWritingHandler createInstance()
    {
        return new PerCustomSqlTemplatesTestTemplateWritingHandler();
    }

    /**
     * Retrieves a new template mock.
     * @return such mock.
     */
    @NotNull
    @Override
    protected PerCustomSqlTemplatesTestTemplate createTemplateMock()
    {
        return EasyMock.createNiceMock(PerCustomSqlTemplatesTestTemplate.class);
    }
}