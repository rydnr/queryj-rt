/*
                        QueryJ Template Packaging Plugin

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
 * Filename: TemplateHandlerBundleTemplateWritingHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Is responsible of writing the content generated by
 *              TemplateHandlerBundleTemplates.
 *
 * Date: 2013/08/21
 * Time: 22:52
 *
 */
package org.acmsl.queryj.templates.packaging.handlers;

/*
 * Importing QueryJ-API classes.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;
import org.acmsl.queryj.api.exceptions.QueryJBuildException;

/*
 * Importing QueryJ Template Packaging classes.
 */
import org.acmsl.queryj.templates.packaging.exceptions.MissingTemplatesException;
import org.acmsl.queryj.templates.packaging.DefaultTemplatePackagingContext;
import org.acmsl.queryj.templates.packaging.TemplateHandlerBundleTemplate;
import org.acmsl.queryj.templates.packaging.TemplatePackagingTemplateGenerator;

/*
 * Importing JetBrains annotations.
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
 * Is responsible of writing the content generated by {@link TemplateHandlerBundleTemplate}s.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2013/08/21 22:52
 */
@ThreadSafe
public class TemplateHandlerBundleTemplateWritingHandler
    extends TemplatePackagingWritingHandler
                <TemplateHandlerBundleTemplate<DefaultTemplatePackagingContext>,
                 DefaultTemplatePackagingContext,
                 TemplatePackagingTemplateGenerator
                     <TemplateHandlerBundleTemplate<DefaultTemplatePackagingContext>,
                      DefaultTemplatePackagingContext>>
{
    /**
     * Retrieves the template generator.
     * @param caching whether to enable template caching.
     * @param threadCount the number of threads to use.
     * @return such instance.
     */
    @NotNull
    @Override
    public TemplatePackagingTemplateGenerator<TemplateHandlerBundleTemplate<DefaultTemplatePackagingContext>, DefaultTemplatePackagingContext>
        retrieveTemplateGenerator(final boolean caching, final int threadCount)
    {
        return new TemplatePackagingTemplateGenerator<>(caching, threadCount);
    }

    /**
     * Retrieves the templates from the command.
     * @param parameters the parameters.
     * @return the template.
     */
    @NotNull
    @Override
    public List<TemplateHandlerBundleTemplate<DefaultTemplatePackagingContext>> retrieveTemplates(
        @NotNull final QueryJCommand parameters)
        throws QueryJBuildException
    {
        @NotNull final List<TemplateHandlerBundleTemplate<DefaultTemplatePackagingContext>> result;

        @Nullable final List<TemplateHandlerBundleTemplate<DefaultTemplatePackagingContext>> aux =
            new QueryJCommandWrapper<TemplateHandlerBundleTemplate<DefaultTemplatePackagingContext>>(parameters)
                .getListSetting(TEMPLATE_HANDLER_BUNDLE_TEMPLATES);

        if (aux == null)
        {
            throw new MissingTemplatesException("template-handler-bundle");
        }
        else
        {
            result = aux;
        }

        return result;
    }
}
