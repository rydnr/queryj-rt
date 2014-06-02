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
 * Filename: TemplatePackagingBuildHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for TemplatePackagingBuildHandler.
 *
 * Date: 2014/06/02
 * Time: 06:29
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.templates.packaging.DefaultTemplatePackagingContext;
import org.acmsl.queryj.templates.packaging.TemplateDef;
import org.acmsl.queryj.templates.packaging.TemplateDefImpl;
import org.acmsl.queryj.templates.packaging.TemplateDefType;
import org.acmsl.queryj.templates.packaging.TemplateFactoryTemplate;
import org.acmsl.queryj.templates.packaging.TemplateFactoryTemplateFactory;
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit classes.
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

/**
 * Tests for {@link TemplatePackagingBuildHandler}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/02 06:29
 */
@RunWith(JUnit4.class)
public class TemplatePackagingBuildHandlerTest
{
    @Test
    public void buildFileName_uses_templateDef_file()
    {
        @NotNull final TemplatePackagingBuildHandler<TemplateFactoryTemplate<DefaultTemplatePackagingContext>,
                TemplateFactoryTemplateFactory,
                DefaultTemplatePackagingContext> instance =
            new TemplateFactoryTemplateBuildHandler();

        @NotNull final TemplateDef<String> templateDef =
            new TemplateDefImpl(
                "defName",
                TemplateDefType.PER_TABLE,
                "finalOFile.java",
                "com.foo.bar",
                file,
                new HashMap<>(0),
                false,
                false);
    }
}
