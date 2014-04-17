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
 * Filename: PerRepositoryTemplatesTestTemplateBuildHandlerTest.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Tests for PerRepositoryTemplatesTestTemplateBuildHandler.
 *
 * Date: 2014/04/17
 * Time: 07:27
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.ConfigurationQueryJCommandImpl;
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;

/*
 * Importing QueryJ Template Packaging classes.
 */
import org.acmsl.queryj.templates.packaging.Literals;
import org.acmsl.queryj.templates.packaging.PerRepositoryTemplatesTestTemplate;
import org.acmsl.queryj.templates.packaging.PerRepositoryTemplatesTestTemplateFactory;
import org.acmsl.queryj.templates.packaging.TemplateDef;

/*
 * Importing Apache Commons Configuration classes.
 */
import org.apache.commons.configuration.PropertiesConfiguration;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing JUnit/EasyMock classes.
 */
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link PerRepositoryTemplatesTestTemplateBuildHandler}.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/17 07:27
 */
@RunWith(JUnit4.class)
public class PerRepositoryTemplatesTestTemplateBuildHandlerTest
    extends AbstractTemplatesTestTemplateBuildHandlerTest
                <PerRepositoryTemplatesTestTemplateBuildHandler,
                 PerRepositoryTemplatesTestTemplate,
                    PerRepositoryTemplatesTestTemplateFactory>
{
    /**
     * Creates a new build handler instance.
     *
     * @return such new instance.
     */
    @Override
    @NotNull
    protected PerRepositoryTemplatesTestTemplateBuildHandler createInstance()
    {
        return new PerRepositoryTemplatesTestTemplateBuildHandler();
    }

    /**
     * Retrieves a new template mock.
     * @return such mock.
     */
    @Override
    @NotNull
    protected PerRepositoryTemplatesTestTemplate createTemplateMock()
    {
        return EasyMock.createNiceMock(PerRepositoryTemplatesTestTemplate.class);
    }

    /**
     * Tests whether retrieveTemplateName() works.
     */
    @Test
    public void retrieveTemplateName_works()
    {
        retrieveTemplateName_works(Literals.PER_REPOSITORY_TEMPLATES_TEST);
    }

    /**
     * Checks whether storeTemplate() binds the template to the command.
     */
    @Test
    public void storeTemplate_stores_the_templates_in_the_command()
    {
        storeTemplate_stores_the_templates_in_the_command(
            PerRepositoryTemplatesTestTemplateBuildHandler.TEMPLATES_KEY);
    }

    /**
     * Checks whether retrieveTemplateFactory() retrieves
     * {@link org.acmsl.queryj.templates.packaging.PerRepositoryTemplatesTestTemplateFactory}.
     */
    @Test
    public void retrieveTemplateFactory_retrieves_the_correct_factory()
    {
        retrieveTemplateFactory_retrieves_the_correct_factory(
            PerRepositoryTemplatesTestTemplateFactory.getInstance());
    }
}
