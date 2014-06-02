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
 * Filename: GlobalClassNameHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for GlobalClassNameHandler.
 *
 * Date: 2014/06/02
 * Time: 07:01
 *
 */
package org.acmsl.queryj.templates.packaging.placeholders;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.metadata.DecoratedString;
import org.acmsl.queryj.templates.packaging.DefaultTemplatePackagingContext;
import org.acmsl.queryj.templates.packaging.GlobalTemplateContext;
import org.acmsl.queryj.templates.packaging.TemplateDef;
import org.acmsl.queryj.templates.packaging.TemplateDefImpl;
import org.acmsl.queryj.templates.packaging.TemplateDefOutput;
import org.acmsl.queryj.templates.packaging.TemplateDefType;
import org.acmsl.queryj.templates.packaging.TemplateFactoryTemplate;
import org.acmsl.queryj.templates.packaging.TemplateFactoryTemplateFactory;
import org.acmsl.queryj.templates.packaging.handlers.TemplateFactoryTemplateBuildHandler;
import org.acmsl.queryj.templates.packaging.handlers.TemplatePackagingBuildHandler;
import org.antlr.v4.codegen.model.TestSetInline;
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

import java.io.File;
import java.util.HashMap;

/**
 * Tests for {@link GlobalClassNameHandler}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/02 07:01
 */
@RunWith(JUnit4.class)
public class GlobalClassNameHandlerTest
{
    /**
     * Checks whether the class name is
     * @throws Exception
     */
    @Test
    public void getValue_uses_the_templateDef_file_if_available()
        throws Exception
    {
        @NotNull final GlobalTemplateContext context = EasyMock.createNiceMock(GlobalTemplateContext.class);

        @NotNull final GlobalClassNameHandler instance =
            new GlobalClassNameHandler(context);

        @NotNull final File file = EasyMock.createNiceMock(File.class);
        EasyMock.expect(file.getName()).andReturn("DefFileName.stg.def");
        EasyMock.replay(file);

        @NotNull final TemplateDef<String> templateDef =
            new TemplateDefImpl(
                "DefName",
                TemplateDefType.PER_TABLE,
                TemplateDefOutput.JAVA,
                "finalOFile.java",
                "com.foo.bar",
                file,
                new HashMap<>(0),
                false,
                false);

        Assert.assertEquals(new DecoratedString("DefFileNameTemplateName.java"), instance.getValue());

    }
}
