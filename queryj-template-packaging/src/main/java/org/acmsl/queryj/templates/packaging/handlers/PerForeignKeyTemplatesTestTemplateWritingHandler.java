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
 * Filename: PerForeignKeyTemplatesTestTemplateWritingHandler.java
 *
 * Description: Writing handler for PerForeignKeyTemplatesTestTemplates.
 *
 * Generated by QueryJ Template Packaging's 3.0-SNAPSHOT
 * org/acmsl/queryj/templates/packaging/PerForeignKeyTemplateWritingHandler.stg
 *
 * DO NOT MODIFY THIS CLASS MANUALLY, SINCE IT GETS GENERATED AUTOMATICALLY.
 * EITHER MODIFY org/acmsl/queryj/templates/packaging/PerForeignKeyTemplateWritingHandler.stg
 * OR CREATE AND APPLY A PATCH.
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;

/*
 * Importing QueryJ Template Packaging classes.
 */
import org.acmsl.queryj.templates.packaging.GlobalTemplateContext;
import org.acmsl.queryj.templates.packaging.PerForeignKeyTemplatesTestTemplate;
import org.acmsl.queryj.templates.packaging.TemplatePackagingTemplateGenerator;
import org.acmsl.queryj.templates.packaging.exceptions.MissingTemplatesException;

/*
 * Importing some JetBrains annotations.
 */
import org.acmsl.queryj.templates.packaging.TemplatePackagingTemplateGenerator;
import org.acmsl.queryj.templates.packaging.exceptions.MissingTemplatesException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing JDK classes.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Writing handler for {@link PerForeignKeyTemplatesTestTemplate}s.
 * @author <a href="http://www.acm-sl.org/projects/queryj">QueryJ's Template Packaging 3.0-SNAPSHOT</a>
 * Generation template: org/acmsl/templates/packaging/TemplateWritingHandler.stg

 */
@ThreadSafe
public class PerForeignKeyTemplatesTestTemplateWritingHandler
    extends TemplatePackagingTestWritingHandler
                <PerForeignKeyTemplatesTestTemplate,
                    GlobalTemplateContext,
                    TemplatePackagingTemplateGenerator<PerForeignKeyTemplatesTestTemplate, GlobalTemplateContext>>
{
    /**
     * Creates a new writing handler for {@link PerForeignKeyTemplatesTestTemplate templates}.
     */
    public PerForeignKeyTemplatesTestTemplateWritingHandler() {}

    /**
     * Retrieves the template generator.
     * @param caching whether to enable template caching.
     * @param threadCount the number of threads to use.
     * @return such instance.
     */
    @NotNull
    @Override
    public TemplatePackagingTemplateGenerator<PerForeignKeyTemplatesTestTemplate, GlobalTemplateContext> retrieveTemplateGenerator(
        final boolean caching, final int threadCount)
    {
        return new TemplatePackagingTemplateGenerator<>(caching, threadCount);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public List<PerForeignKeyTemplatesTestTemplate> retrieveTemplates(@NotNull final QueryJCommand parameters)
    {
        @NotNull final List<PerForeignKeyTemplatesTestTemplate> result;

        @Nullable final List<PerForeignKeyTemplatesTestTemplate> aux =
            new QueryJCommandWrapper<PerForeignKeyTemplatesTestTemplate>(parameters)
                .getListSetting(PerForeignKeyTemplatesTestTemplateBuildHandler.TEMPLATES_KEY);

        if (aux == null)
        {
            throw new MissingTemplatesException("per-foreign-key-templates-test");
        }
        else
        {
            result = aux;
        }

        return result;
    }
}
