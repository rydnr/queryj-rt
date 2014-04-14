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
 * Filename: TemplateWritingHandlerTemplateFactoryTest.java
 *
 * Author: Jose San Leandro
 *
 * Description: Tests for TemplateWritingHandlerTemplateFactory.
 *
 * Created: 2014/04/14 17:27
 *
 */
package org.acmsl.queryj.templates.packaging;

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

/**
 * Tests for {@link TemplateWritingHandlerTemplateFactory}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created 2014/04/14
 */
@RunWith(JUnit4.class)
public class TemplateWritingHandlerTemplateFactoryTest
{
    /**
     * Checks whether the createTemplate() method returns the correct template
     * for a per-repository type.
     */
    @Test
    public void createTemplate_returns_the_correct_template_for_a_per_repository_template()
    {
        testCreateTemplate(TemplateDefType.PER_REPOSITORY, "TemplateWritingHandler");
    }

    /**
     * Checks whether the createTemplate() method returns the correct template.
     * @param type the {@link TemplateDefType type}.
     * @param templateName the template name.
     */
    protected void testCreateTemplate(@NotNull final TemplateDefType type, @NotNull final String templateName)
    {
        @NotNull final TemplateWritingHandlerTemplateFactory instance =
            new TemplateWritingHandlerTemplateFactory();

        @NotNull final DefaultTemplatePackagingContext context =
            EasyMock.createNiceMock(DefaultTemplatePackagingContext.class);

        @SuppressWarnings("unchecked")
        @NotNull final TemplateDef<String> templateDef = EasyMock.createNiceMock(TemplateDef.class);

        EasyMock.expect(context.getTemplateDef()).andReturn(templateDef);
        EasyMock.expect(templateDef.getType()).andReturn(type);

        EasyMock.replay(context);
        EasyMock.replay(templateDef);

        @Nullable final TemplateWritingHandlerTemplate<DefaultTemplatePackagingContext> template =
            instance.createTemplate(context);

        Assert.assertNotNull(template);
        Assert.assertEquals(templateName, template.getTemplateName());

        EasyMock.verify(context);
        EasyMock.verify(templateDef);
    }
}
