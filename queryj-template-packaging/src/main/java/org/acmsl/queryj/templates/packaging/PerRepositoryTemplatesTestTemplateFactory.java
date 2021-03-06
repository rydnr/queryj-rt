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
 * Filename: PerRepositoryTemplatesTestTemplateFactory.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Factory for {@link PerRepositoryTemplatesTestTemplate}s.
 *
 * Date: 2014/04/16
 * Time: 21:18
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing ACM SL Java Commons classes.
 */
import org.acmsl.commons.patterns.Singleton;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Factory for {@link PerRepositoryTemplatesTestTemplate}s.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/16 21:18
 */
@ThreadSafe
public class PerRepositoryTemplatesTestTemplateFactory
    implements TemplatePackagingTemplateFactory<PerRepositoryTemplatesTestTemplate, GlobalTemplateContext>,
               Singleton
{
    /**
     * Singleton instance to avoid double-locking check.
     */
    protected static final class PerRepositoryTemplatesTestTemplateFactorySingletonContainer
    {
        /**
         * The actual singleton.
         */
        public static final PerRepositoryTemplatesTestTemplateFactory SINGLETON =
            new PerRepositoryTemplatesTestTemplateFactory();
    }

    /**
     * Retrieves the singleton instance.
     * @return such instance.
     */
    @NotNull
    public static PerRepositoryTemplatesTestTemplateFactory getInstance()
    {
        return PerRepositoryTemplatesTestTemplateFactorySingletonContainer.SINGLETON;
    }

    /**
     * Generates a template.
     * @param context the context.
     * @return such template.
     */
    @Nullable
    @Override
    public PerRepositoryTemplatesTestTemplate createTemplate(@NotNull final GlobalTemplateContext context)
    {
        return new PerRepositoryTemplatesTestTemplate(context);
    }
}
