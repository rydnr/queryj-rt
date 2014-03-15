/*
                        QueryJ

    Copyright (C) 2002-2007  Jose San Leandro Armendariz
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
    Contact info: chous@acm-sl.org
    Postal Address: c/Playa de Lagoa, 1
                    Urb. Valdecabanas
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Filename: DAOListenerTemplate.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Is able to generate DAO listeners.
 *
 */
package org.acmsl.queryj.templates.dao;

/*
 * Importing some project-specific classes.
 */
import org.acmsl.queryj.api.AbstractBasePerRepositoryTemplate;
import org.acmsl.queryj.api.PerRepositoryTemplateContext;

/*
 * Importing some StringTemplate classes.
 */
import org.stringtemplate.v4.STGroup;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Is able to generate DAO listeners.
 * @author <a href="mailto:chous@acm-sl.org"
 *         >Jose San Leandro</a>
 */
@ThreadSafe
public class DAOListenerImplTemplate
    extends AbstractBasePerRepositoryTemplate<PerRepositoryTemplateContext>
{
    private static final long serialVersionUID = -6303657842543560189L;

    /**
     * Builds a <code>DAOListenerImplTemplate</code> using given
     * context information.
     * @param context the {@link org.acmsl.queryj.api.PerRepositoryTemplateContext} instance.
     */
    public DAOListenerImplTemplate(@NotNull final PerRepositoryTemplateContext context)
    {
        super(context);
    }

    /**
     * Builds a key to store the template cache.
     * @return such key.
     */
    @NotNull
    @SuppressWarnings("unused")
    protected Object buildTemplateCacheKey()
    {
        return "//DAOListenerImplTemplate//";
    }

    /**
     * Retrieves the string template group.
     * @return such instance.
     */
    @Nullable
    @Override
    public STGroup retrieveGroup()
    {
        return retrieveGroup(DAO_GROUP + getTemplateName() + ".stg");
    }

    /**
     * Returns "DAOListenerImpl".
     * @return such information.
     */
    @NotNull
    public String getTemplateName()
    {
        return "DAOListenerImpl";
    }
}
