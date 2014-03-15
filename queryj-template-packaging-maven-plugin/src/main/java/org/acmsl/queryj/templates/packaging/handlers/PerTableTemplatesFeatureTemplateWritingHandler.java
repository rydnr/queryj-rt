/*
                  QueryJ Template Packaging

    Copyright (C) 2013-today Jose San Leandro Armendariz
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
 * Author: QueryJ's Template Packaging
 *
 * Filename: PerTableTemplatesFeatureTemplateWritingHandler.java
 *
 * Description: Writing handler for PerTableTemplatesFeatureTemplates.
 *
 * Generated by QueryJ Template Packaging's
 * org/acmsl/templates/packaging/TemplateWritingHandler.stg
 * at timestamp: 2013/12/07 12:29
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing QueryJ-Core classes.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;

/*
 * Importing QueryJ Template Packaging classes.
 */
import org.acmsl.queryj.templates.packaging.exceptions.MissingTemplatesException;
import org.acmsl.queryj.templates.packaging.GlobalTemplateContext;
import org.acmsl.queryj.templates.packaging.PerTableTemplatesFeatureTemplate;
import org.acmsl.queryj.templates.packaging.TemplatePackagingTemplateGenerator;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/*
 * Importing JDK classes.
 */
import java.util.List;

/**
 * Writing handler for {@link PerTableTemplatesFeatureTemplate}s.
 * @author <a href="http://www.acm-sl.org/projects/queryj">QueryJ's Template Packaging</a>
 * Generation template: org/acmsl/templates/packaging/TemplateWritingHandler.stg
 * Created: 2013/12/07 12:29
 */
@ThreadSafe
public class PerTableTemplatesFeatureTemplateWritingHandler
    extends TemplatePackagingTestWritingHandler
                <PerTableTemplatesFeatureTemplate,
                    GlobalTemplateContext,
                    TemplatePackagingTemplateGenerator<PerTableTemplatesFeatureTemplate, GlobalTemplateContext>>
{
    /**
     * Creates a new writing handler for {@link PerTableTemplatesFeatureTemplate templates}.
     */
    public PerTableTemplatesFeatureTemplateWritingHandler() {}

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    protected TemplatePackagingTemplateGenerator<PerTableTemplatesFeatureTemplate, GlobalTemplateContext> retrieveTemplateGenerator(
        final boolean caching, final int threadCount)
    {
        return new TemplatePackagingTemplateGenerator<PerTableTemplatesFeatureTemplate, GlobalTemplateContext>(caching, threadCount);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    protected List<PerTableTemplatesFeatureTemplate> retrieveTemplates(@NotNull final QueryJCommand parameters)
    {
        @NotNull final List<PerTableTemplatesFeatureTemplate> result;

        @Nullable final List<PerTableTemplatesFeatureTemplate> aux =
            new QueryJCommandWrapper<PerTableTemplatesFeatureTemplate>(parameters)
                .getListSetting(PerTableTemplatesFeatureTemplateBuildHandler.TEMPLATE_KEY);

        if (aux == null)
        {
            throw new MissingTemplatesException("per-table-templates-feature");
        }
        else
        {
            result = aux;
        }

        return result;
    }
}
