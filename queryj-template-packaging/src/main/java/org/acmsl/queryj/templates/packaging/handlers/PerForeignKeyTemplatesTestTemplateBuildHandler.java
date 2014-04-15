/*
                  QueryJ's Template Packaging

    Copyright (C) 20022014-today Jose San Leandro Armendariz
                              queryj@acm-sl.org

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
    Postal Address: c/Playa de Lagoa, 1
                    Urb. Valdecabanas
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Author: QueryJ's Template Packaging 3.0-SNAPSHOT
 *
 * Filename: PerForeignKeyTemplatesTestTemplateBuildHandler.java
 *
 * Description: Build handler for PerForeignKeyTemplatesTestTemplates.
 *
 * Generated by QueryJ Template Packaging's 3.0-SNAPSHOT
 * org/acmsl/queryj/templates/packaging/TemplateBuildHandler.stg
 *
 * DO NOT MODIFY THIS CLASS MANUALLY, SINCE IT GETS GENERATED AUTOMATICALLY.
 * EITHER MODIFY org/acmsl/queryj/templates/packaging/TemplateBuildHandler.stg
 * OR CREATE AND APPLY A PATCH.
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;
import org.acmsl.queryj.Literals;
import org.acmsl.queryj.templates.packaging.GlobalTemplateContext;
import org.acmsl.queryj.templates.packaging.TemplateDef;

/*
 * Importing QueryJ Template Packaging classes.
 */
import org.acmsl.queryj.templates.packaging.PerForeignKeyTemplatesTestTemplate;
import org.acmsl.queryj.templates.packaging.PerForeignKeyTemplatesTestTemplateFactory;

/*
 * Importing StringTemplate classes.
 */
import org.stringtemplate.v4.ST;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing JDK classes.
 */
import java.util.List;

/**
 * Build handler for {@link PerForeignKeyTemplatesTestTemplate}s.
 * @author <a href="http://www.acm-sl.org/projects/queryj">QueryJ's Template Packaging 3.0-SNAPSHOT</a>
 * Generation template: org/acmsl/queryj/templates/packaging/TemplateBuildHandler.stg

 */
@ThreadSafe
public class PerForeignKeyTemplatesTestTemplateBuildHandler
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
