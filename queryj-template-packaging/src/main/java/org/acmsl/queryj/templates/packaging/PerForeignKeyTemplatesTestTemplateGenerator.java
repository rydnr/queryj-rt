/*
                  QueryJ's Template Packaging

    Copyright (C) 2002-2014-today Jose San Leandro Armendariz
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
 * Filename: PerForeignKeyTemplatesTestTemplateGenerator.java
 *
 * Description: Generator for PerForeignKeyTemplatesTestTemplates.
 *
 * Generated originally by QueryJ Template Packaging's 3.0-SNAPSHOT
 * org/acmsl/queryj/templates/packaging/TemplateGenerator.stg
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing QueryJ-Core classes.
 */
import org.acmsl.queryj.api.AbstractQueryJTemplateGenerator;
import org.acmsl.queryj.api.PerForeignKeyTemplateContext;
import org.acmsl.queryj.api.PerForeignKeyTemplateGenerator;
import org.acmsl.queryj.metadata.CachingDecoratorFactory;
import org.acmsl.queryj.metadata.DecoratorFactory;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Generator for {@link PerForeignKeyTemplatesTestTemplate}s.
 * @author <a href="http://www.acm-sl.org/projects/queryj">QueryJ's Template Packaging 3.0-SNAPSHOT</a>
 * Generation template: org/acmsl/queryj/templates/packaging/TemplateGenerator.stg

 */
@ThreadSafe
public class PerForeignKeyTemplatesTestTemplateGenerator
    extends AbstractQueryJTemplateGenerator<PerForeignKeyTemplatesTestTemplate, PerForeignKeyTemplateContext>
    implements PerForeignKeyTemplateGenerator<PerForeignKeyTemplatesTestTemplate, PerForeignKeyTemplateContext>
{
    /**
     * Creates a new generator instance with given settings.
     * @param caching whether to enable caching.
     * @param threadCount the number of threads to use.
     */
    public PerForeignKeyTemplatesTestTemplateGenerator(final boolean caching, final int threadCount)
    {
        super(caching, threadCount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public DecoratorFactory getDecoratorFactory()
    {
        return CachingDecoratorFactory.getInstance();
    }
}
