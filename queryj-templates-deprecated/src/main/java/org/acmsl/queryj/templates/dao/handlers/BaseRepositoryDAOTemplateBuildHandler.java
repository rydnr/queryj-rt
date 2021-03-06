/*
                        QueryJ

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
 * Filename: BaseRepositoryDAOTemplateBuildHandler.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Builds the repository DAO interface if requested.
 *
 */
package org.acmsl.queryj.templates.dao.handlers;

/*
 * Importing some project classes.
 */
import org.acmsl.queryj.api.PerRepositoryTemplateContext;
import org.acmsl.queryj.templates.dao.BaseRepositoryDAOTemplate;
import org.acmsl.queryj.templates.dao.BaseRepositoryDAOTemplateFactory;
import org.acmsl.queryj.api.TemplateMappingManager;
import org.acmsl.queryj.api.handlers.BasePerRepositoryTemplateBuildHandler;
import org.acmsl.queryj.tools.PackageUtils;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing some JDK classes.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Builds the repository DAO interface if requested.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 */
@ThreadSafe
public class BaseRepositoryDAOTemplateBuildHandler
    extends BasePerRepositoryTemplateBuildHandler<BaseRepositoryDAOTemplate, BaseRepositoryDAOTemplateFactory, PerRepositoryTemplateContext>
{
    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    protected BaseRepositoryDAOTemplateFactory retrieveTemplateFactory()
    {
        return BaseRepositoryDAOTemplateFactory.getInstance();
    }
    
    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    protected String retrievePackage(
        @NotNull final String engineName,
        @NotNull final String projectPackage,
        @NotNull final PackageUtils packageUtils)
    {
        return packageUtils.retrieveBaseRepositoryDAOPackage(projectPackage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void storeTemplate(
        @NotNull final BaseRepositoryDAOTemplate template,
        @NotNull final Map<String, List<BaseRepositoryDAOTemplate>> parameters)
    {
        @NotNull final List<BaseRepositoryDAOTemplate> list = new ArrayList<BaseRepositoryDAOTemplate>(1);
        list.add(template);

        parameters.put(
            TemplateMappingManager.BASE_REPOSITORY_DAO_TEMPLATE,
            list);
    }
}
