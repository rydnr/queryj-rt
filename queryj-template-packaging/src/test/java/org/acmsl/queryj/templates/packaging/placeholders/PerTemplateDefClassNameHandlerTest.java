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
 * Filename: PerTemplateDefClassNameHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for PerTemplateDefClassNameHandler.
 *
 * Date: 2014/06/03
 * Time: 00:28
 *
 */
package org.acmsl.queryj.templates.packaging.placeholders;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.templates.packaging.DefaultTemplatePackagingContext;
import org.acmsl.queryj.templates.packaging.TemplateDef;
import org.acmsl.queryj.templates.packaging.TemplateDefImpl;
import org.acmsl.queryj.templates.packaging.TemplateDefOutput;
import org.acmsl.queryj.templates.packaging.TemplateDefType;
import org.easymock.EasyMock;
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit/EasyMock classes.
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.HashMap;

/**
 * Tests for {@link PerTemplateDefClassNameHandler}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/03 00:28
 */
@RunWith(JUnit4.class)
public class PerTemplateDefClassNameHandlerTest
{
    /**
     * Checks whether resolveContextValue() uses TemplateDef's file,
     * if it's not null.
     */
    @Test
    public void resolveContextValue_uses_TemplateDef_file_if_available()
    {
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

        @NotNull final DefaultTemplatePackagingContext context =
            new DefaultTemplatePackagingContext(
                ""
            );

        @NotNull final PerTemplateDefClassNameHandler instance =
            new PerTemplateDefClassNameHandler(context);
    }
}
