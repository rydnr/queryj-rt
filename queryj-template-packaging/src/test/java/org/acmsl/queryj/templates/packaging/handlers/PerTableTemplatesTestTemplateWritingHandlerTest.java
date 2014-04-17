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
 * Filename: PerTableTemplatesTestTemplateWritingHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for PerTableTemplatesTestTemplateWritingHandler.
 *
 * Date: 2014/04/17
 * Time: 08:21
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.templates.packaging.TemplatePackagingTemplateGenerator;
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit classes.
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link PerTableTemplatesTestTemplateWritingHandler}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/17 08:21
 */
@RunWith(JUnit4.class)
public class PerTableTemplatesTestTemplateWritingHandlerTest
{
    /**
     * Checks retrieveTemplateGenerator retrieves a not-null instance.
     * Redundant check since it's annotated with @NotNull.
     */
    @Test
    public void retrieveTemplateGenerator_works()
    {
        @NotNull final PerTableTemplatesTestTemplateWritingHandler instance =
            new PerTableTemplatesTestTemplateWritingHandler();

        Assert.assertNotNull(instance.retrieveTemplateGenerator(false, 1));
    }

    @Test
    public void retrieveTemplates_finds_the_templates()
    {
        @NotNull final
    }
}
