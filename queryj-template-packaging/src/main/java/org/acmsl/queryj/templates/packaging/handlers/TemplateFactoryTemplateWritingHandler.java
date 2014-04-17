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
 * Filename: TemplateFactoryTemplateWritingHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Is responsible of writing the content generated by
 *              TemplateFactoryTemplates.
 *
 * Date: 2013/08/21
 * Time: 22:06
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
import org.acmsl.queryj.templates.packaging.DefaultTemplatePackagingContext;
import org.acmsl.queryj.templates.packaging.TemplateFactoryTemplate;
import org.acmsl.queryj.templates.packaging.TemplatePackagingTemplateGenerator;
import org.acmsl.queryj.templates.packaging.exceptions.MissingTemplatesException;

/*
 * Importing Jetbrains annotations.
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
 * Is responsible of writing the content generated by {@link TemplateFactoryTemplate}s.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2013/08/21 22:06
 */
@ThreadSafe
public class TemplateFactoryTemplateWritingHandler
    extends TemplatePackagingWritingHandler
                <TemplateFactoryTemplate<DefaultTemplatePackagingContext>,
                 DefaultTemplatePackagingContext,
                 TemplatePackagingTemplateGenerator
                     <TemplateFactoryTemplate<DefaultTemplatePackagingContext>,
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
    protected TemplatePackagingTemplateGenerator<TemplateFactoryTemplate<DefaultTemplatePackagingContext>, DefaultTemplatePackagingContext>
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
    public List<TemplateFactoryTemplate<DefaultTemplatePackagingContext>> retrieveTemplates(@NotNull final QueryJCommand parameters)
        throws QueryJBuildException
    {
        @NotNull final List<TemplateFactoryTemplate<DefaultTemplatePackagingContext>> result;

        @Nullable final List<TemplateFactoryTemplate<DefaultTemplatePackagingContext>> aux =
            new QueryJCommandWrapper<TemplateFactoryTemplate<DefaultTemplatePackagingContext>>(parameters)
                .getListSetting(TEMPLATE_FACTORY_TEMPLATES);

        if (aux == null)
        {
            throw new MissingTemplatesException("template-factory");
        }
        else
        {
            result = aux;
        }

        return result;
    }
}
