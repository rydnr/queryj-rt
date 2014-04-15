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
package org.acmsl.queryj.templates;

/*
 * Importing QueryJ-Core classes.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.api.PerForeignKeyTemplateContext;
import org.acmsl.queryj.api.PerForeignKeyTemplateFactory;
import org.acmsl.queryj.api.QueryJCommandUtils;
import org.acmsl.queryj.Literals;
import org.acmsl.queryj.metadata.DecoratedString;
import org.acmsl.queryj.metadata.engines.EngineDecorator;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.vo.ForeignKey;

/*
 * Importing some ACM-SL Java Commons classes.
 */
import org.acmsl.commons.patterns.Singleton;

/*
 * Importing StringTemplate classes.
 */
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
    implements PerForeignKeyTemplateFactory<
    org.acmsl.queryj.templates.PerForeignKeyTemplatesTestTemplate, PerForeignKeyTemplateContext>,
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
     * {@inheritDoc}
     */
    @Override
    @NotNull
    public org.acmsl.queryj.templates.PerForeignKeyTemplatesTestTemplate createTemplate(
        @NotNull final String packageName,
        @NotNull final ForeignKey<String> foreignKey,
        @NotNull final QueryJCommand command)
    {
        return createTemplate(packageName, foreignKey, command, QueryJCommandUtils.getInstance());
    }

    /**
     * Creates a per-foreign key template.
     * @param packageName the package name.
     * @param foreignKey the foreign key.
     * @param command the {@link QueryJCommand} instance.
     * @param queryJCommandUtils the {@link QueryJCommandUtils} instance.
     * @return the new template.
     */
    @NotNull
    protected org.acmsl.queryj.templates.PerForeignKeyTemplatesTestTemplate createTemplate(
        @NotNull final String packageName,
        @NotNull final ForeignKey<String> foreignKey,
        @NotNull final QueryJCommand command,
        @NotNull final QueryJCommandUtils queryJCommandUtils)
    {
        @NotNull final PerForeignKeyTemplateContext t_Context =
            new PerForeignKeyTemplateContext(
                retrieveTemplateFileName(
                    foreignKey.getSourceTableName(),
                    queryJCommandUtils.retrieveMetadataManager(command)),
                packageName,
                foreignKey,
                command);

        return new org.acmsl.queryj.templates.PerForeignKeyTemplatesTestTemplate(t_Context);
    }

    /**
     * Retrieves the file name of the template.
     * @param tableName the table name.
     * @param metadataManager the {@link MetadataManager} instance.
     * @return the file name.
     */
    @NotNull
    public String retrieveTemplateFileName(
        @NotNull final String tableName, @NotNull final MetadataManager metadataManager)
    {
        @NotNull final String result;

        @NotNull final ST template =
            new ST("PerForeignKeyTemplatesTest.java");

        template.add(Literals.TABLE_NAME, new DecoratedString(tableName));
        template.add(Literals.ENGINE, new EngineDecorator(metadataManager.getEngine()));

        result = template.render();

        return result;
    }
}
