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
 * Filename: PerForeignKeyTemplatesTestTemplateFactory.java
 *
 * Description: Factory for PerForeignKeyTemplatesTestTemplates, for each foreign key
 *
 * Generated by QueryJ Template Packaging's 3.0-SNAPSHOT
 * org/acmsl/queryj/templates/packaging/PerForeignKeyTemplateFactory.stg
 *
 * DO NOT MODIFY THIS CLASS MANUALLY, SINCE IT GETS GENERATED AUTOMATICALLY.
 * EITHER MODIFY org/acmsl/queryj/templates/packaging/PerForeignKeyTemplateFactory.stg
 * OR CREATE AND APPLY A PATCH.
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing some ACM-SL Java Commons classes.
 */
import org.acmsl.commons.patterns.Singleton;

/*
 * Importing StringTemplate classes.
 */
import org.jetbrains.annotations.Nullable;
import org.stringtemplate.v4.ST;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Factory for {@link PerForeignKeyTemplatesTestTemplate}s.
 * @author <a href="http://www.acm-sl.org/projects/queryj">QueryJ's Template Packaging 3.0-SNAPSHOT</a>
 * Generation template: org/acmsl/queryj/templates/packaging/PerForeignKeyTemplateFactory.stg

 */
@ThreadSafe
public class PerForeignKeyTemplatesTestTemplateFactory
    implements TemplatePackagingTemplateFactory<PerForeignKeyTemplatesTestTemplate, GlobalTemplateContext>,
               Singleton
{
    /**
     * Singleton instance to avoid double-locking check.
     */
    protected static final class PerForeignKeyTemplatesTestTemplateFactorySingletonContainer
    {
        /**
         * The actual singleton.
         */
        public static final PerForeignKeyTemplatesTestTemplateFactory SINGLETON = new PerForeignKeyTemplatesTestTemplateFactory();
    }

    /**
     * Retrieves the singleton instance.
     * @return such instance.
     */
    @NotNull
    public static PerForeignKeyTemplatesTestTemplateFactory getInstance()
    {
        return PerForeignKeyTemplatesTestTemplateFactorySingletonContainer.SINGLETON;
    }


    /**
     * Generates a template.
     *
     * @param context the context.
     * @return such template.
     */
    @Nullable
    @Override
    public PerForeignKeyTemplatesTestTemplate createTemplate(@NotNull final GlobalTemplateContext context)
    {
        return new PerForeignKeyTemplatesTestTemplate(context);
    }
}