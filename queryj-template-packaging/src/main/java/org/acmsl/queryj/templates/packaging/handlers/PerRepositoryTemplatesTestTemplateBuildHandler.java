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
 * Filename: PerRepositoryTemplatesTestTemplateBuildHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/04/17
 * Time: 07:30
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;
import org.acmsl.queryj.templates.packaging.GlobalTemplateContext;
import org.acmsl.queryj.templates.packaging.Literals;
import org.acmsl.queryj.templates.packaging.PerForeignKeyTemplatesTestTemplate;
import org.acmsl.queryj.templates.packaging.PerForeignKeyTemplatesTestTemplateFactory;
import org.acmsl.queryj.templates.packaging.TemplateDef;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.util.List;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/17 07:30
 */
@ThreadSafe
public class PerRepositoryTemplatesTestTemplateBuildHandler
    extends TemplatePackagingTestBuildHandler
                <PerForeignKeyTemplatesTestTemplate,
                    PerForeignKeyTemplatesTestTemplateFactory,
                    GlobalTemplateContext>
{
    /**
     * The key to access the templates in the command.
     */
    @NotNull static final String TEMPLATES_KEY = "PerForeignKeyTemplatesTest_templates";

    /**
     * Creates a {@code PerForeignKeyTemplatesTestTemplateBuildHandler}.
     */
    public PerForeignKeyTemplatesTestTemplateBuildHandler() {}

    /**
     * Retrieves the template factory.
     * @return the {@link PerForeignKeyTemplatesTestTemplateFactory} instance.
     */
    @Override
    @NotNull
    protected PerForeignKeyTemplatesTestTemplateFactory retrieveTemplateFactory()
    {
        return PerForeignKeyTemplatesTestTemplateFactory.getInstance();
    }

    /**
     * Builds the context from given parameters.
     * @param templateDefs the template defs.
     * @param parameters   the command with the parameters.
     * @return the template context.
     */
    @NotNull
    @Override
    protected GlobalTemplateContext buildContext(
        @NotNull final List<TemplateDef<String>> templateDefs, @NotNull final QueryJCommand parameters)
    {
        return buildGlobalContext(templateDefs, parameters);
    }

    /**
     * Retrieves the output package for the generated file.
     * @param parameters the parameters.
     * @return such package.
     */
    @NotNull
    @Override
    protected String retrieveOutputPackage(@NotNull final QueryJCommand parameters)
    {
        return org.acmsl.queryj.templates.packaging.Literals.CUCUMBER_TEMPLATES;
    }

    /**
     * Retrieves the template name, using the parameters if necessary.
     * @param parameters the parameters.
     * @return the template name.
     */
    @NotNull
    @Override
    protected String retrieveTemplateName(@NotNull final QueryJCommand parameters)
    {
        return Literals.PER_FOREIGN_KEY_TEMPLATES_TEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void storeTemplate(
        @NotNull final PerForeignKeyTemplatesTestTemplate template,
        @NotNull final QueryJCommand parameters)
    {
        new QueryJCommandWrapper<PerForeignKeyTemplatesTestTemplate>(parameters)
            .setSetting(TEMPLATES_KEY, template);
    }
}
