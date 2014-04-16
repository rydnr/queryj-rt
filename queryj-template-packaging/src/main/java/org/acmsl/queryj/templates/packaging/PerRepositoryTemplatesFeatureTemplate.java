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
 * Filename: PerRepositoryTemplatesFeatureTemplate.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Used to generate sources using PerRepositoryTemplatesFeature.stg.
 *
 * Date: 2014/04/16
 * Time: 06:04
 *
 */
package org.acmsl.queryj.templates.packaging;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.Arrays;

/**
 * Used to generate sources using PerRepositoryTemplatesFeature.stg.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/04/16 06:04
 */
@ThreadSafe
public class PerRepositoryTemplatesFeatureTemplate
    extends AbstractTemplatePackagingTemplate<GlobalTemplateContext>
{{
    /**
     * Builds a PerTableTemplatesFeature using given context.
     * @param context the {@link org.acmsl.queryj.api.PerRepositoryTemplateContext}.
     */
    public PerTableTemplatesFeatureTemplate(@NotNull final GlobalTemplateContext context)
    {
        super(context);
    }

    /**
     * Retrieves the StringTemplate group for "PerTableTemplatesFeature.stg".
     * @return such {@link org.stringtemplate.v4.STGroup group}.
     */
    @Nullable
    @Override
    public STGroup retrieveGroup()
    {
        return
            retrieveGroup(
                "org/acmsl/queryj/templates/packaging/PerTableTemplatesFeature.stg",
                Arrays.asList(org.acmsl.queryj.Literals.ORG_ACMSL_QUERYJ_TEMPLATES));
    }

    /**
     * Retrieves the template in given group.
     * @param group the StringTemplate group.
     * @return the template.
     */
    @Nullable
    @Override
    protected ST retrieveTemplate(@Nullable final STGroup group)
    {
        @Nullable final ST result = super.retrieveTemplate(group);

        if (group != null)
        {
            for (@NotNull final TemplateDef<String> def : getTemplateContext().getTemplateDefs())
            {
                @NotNull final String ruleBody =
                    def.getFilenameRule()
                    + "(engine, fileName) ::= <<\n" + def.getFilenameBuilder() + ">>\n";

                group.importTemplates(new STGroupString(def.getName() + "_filename", ruleBody));
            }
        }

        return result;
    }

    /**
     * Retrieves the template name.
     * @return "PerTableTemplatesFeature";
     */
    @NotNull
    @Override
    public String getTemplateName()
    {
        return Literals.PER_TABLE_TEMPLATES_FEATURE;
    }

}
