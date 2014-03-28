/*
                        QueryJ Core

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
 * Filename: AbstractTemplate.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Represents generic templates.
 *
 */
package org.acmsl.queryj.api;

/*
 * Importing QueryJ Core classes.
 */
import org.acmsl.queryj.QueryJCommand;
import org.acmsl.queryj.QueryJCommandWrapper;
import org.acmsl.queryj.customsql.CustomSqlProvider;
import org.acmsl.queryj.metadata.DecoratorFactory;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.vo.Attribute;

/*
 * Importing Apache Commons Lang classes.
 */
import org.acmsl.queryj.tools.exceptions.MetadataManagerNotAvailableException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
 * Importing some JDK classes.
 */
import java.io.Serializable;
import java.util.List;

/**
 * Abstract implementation of {@link QueryJTemplateContext}.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 * @since 3.0
 * Created: 2012/05/20
 */
@ThreadSafe
public abstract class AbstractTemplateContext
    implements QueryJTemplateContext,
               Serializable
{
    /**
     * The serial version id.
     */
    private static final long serialVersionUID = 3405496681880071590L;

    /**
     * The optional header.
     */
    private String m__strHeader;

    /**
     * The decorator factory.
     */
    private DecoratorFactory m__DecoratorFactory;

    /**
     * The command.
     */
    private QueryJCommand m__Command;

    /**
     * The custom-sql provider.
     */
    private CustomSqlProvider m__CustomSqlProvider;

    /**
     * The package name.
     */
    private String m__strPackageName;

    /**
     * The base package name.
     */
    private String m__strBasePackageName;

    /**
     * The repository name.
     */
    private String m__strRepositoryName;

    /**
     * Whether to implement marker interfaces.
     */
    private boolean m__bImplementMarkerInterfaces;

    /**
     * Whether to include JMX support.
     */
    private boolean m__bJmx;

    /**
     * The JNDI path of the DataSource.
     */
    private String m__strJndiLocation;

    /**
     * Whether to disable generation timestamps.
     */
    private boolean m__bDisableGenerationTimestamps;

    /**
     * Whether to disable NotNull annotations.
     */
    private boolean m__bDisableNotNullAnnotations;

    /**
     * Whether to disable checkthread.org annotations.
     */
    private boolean m__bDisableCheckthreadAnnotations;

    /**
     * The file name.
     */
    private String m__strFileName;

    /**
     * Creates an {@link AbstractTemplateContext} with given information.
     * @param command the {@link QueryJCommand} instance.
     */
    protected AbstractTemplateContext(@NotNull final QueryJCommand command)
    {
        immutableSetCommand(command);
    }

    /**
     * Specifies the command.
     * @param command the command.
     */
    private void immutableSetCommand(@NotNull final QueryJCommand command)
    {
        m__Command = command;
    }

    /**
     * Specifies the command.
     * @param command the command.
     */
    @SuppressWarnings("unused")
    protected void setCommand(@NotNull final QueryJCommand command)
    {
        immutableSetCommand(command);
    }

    /**
     * Retrieves the command.
     * @return such command.
     */
    @NotNull
    public QueryJCommand getCommand()
    {
        return m__Command;
    }

    /**
     * Retrieves the metadata manager.
     * @return such manager.
     */
    @NotNull
    @Override
    public MetadataManager getMetadataManager()
    {
        return getMetadataManager(getCommand());
    }

    /**
     * Retrieves the metadata manager.
     * @param command the command.
     * @return such manager.
     */
    @NotNull
    protected MetadataManager getMetadataManager(@NotNull final QueryJCommand command)
    {
        @Nullable final MetadataManager result =
            new QueryJCommandWrapper<MetadataManager>(command).getSetting(MetadataManager.class.getSimpleName());

        if (result == null)
        {
            throw new MetadataManagerNotAvailableException();
        }

        return result;
    }

    /**
     * Retrieves the custom-sql provider.
     * @return such provider.
     */
    @NotNull
    @Override
    public CustomSqlProvider getCustomSqlProvider()
    {
        return m__CustomSqlProvider;
    }

    /**
     * Retrieves the header.
     * @return the header.
     */
    @Nullable
    @Override
    public String getHeader()
    {
        return m__strHeader;
    }

    /**
     * Retrieves the {@link DecoratorFactory} instance.
     * @return such instance.
     */
    @Override
    @NotNull
    public DecoratorFactory getDecoratorFactory()
    {
        return m__DecoratorFactory;
    }

    /**
     * Retrieves the package name.
     * @return such information.
     */
    @NotNull
    @Override
    public String getPackageName()
    {
        return m__strPackageName;
    }

    /**
     * Retrieves the base package name.
     * @return such information.
     */
    @NotNull
    @Override
    public String getBasePackageName()
    {
        return m__strBasePackageName;
    }

    /**
     * Retrieves the repository name.
     * @return such information.
     */
    @NotNull
    @Override
    public String getRepositoryName()
    {
        return m__strRepositoryName;
    }

    /**
     * Retrieves whether to implement marker interfaces.
     * @return such condition.
     */
    public boolean getImplementMarkerInterfaces()
    {
        return m__bImplementMarkerInterfaces;
    }

    /**
     * Retrieves whether to include JMX support.
     * @return such information.
     */
    @SuppressWarnings("unused")
    public boolean isJmxSupportEnabled()
    {
        return m__bJmx;
    }

    /**
     * Retrieves the JNDI location for the {@link javax.sql.DataSource}.
     * @return such location.
     */
    @Override
    @NotNull
    public String getJndiLocation()
    {
        return this.m__strJndiLocation;
    }

    /**
     * Retrieves whether to use generation timestamps or not.
     * @return such setting.
     */
    @Override
    public boolean getDisableGenerationTimestamps()
    {
        return m__bDisableGenerationTimestamps;
    }

    /**
     * Retrieves whether to use NotNull annotations or not.
     * @return such setting.
     */
    @Override
    public boolean getDisableNotNullAnnotations()
    {
        return m__bDisableNotNullAnnotations;
    }

    /**
     * Retrieves whether to use checkthread.org annotations or not.
     * @return such setting.
     */
    @Override
    public boolean getDisableCheckthreadAnnotations()
    {
        return m__bDisableCheckthreadAnnotations;
    }

    /**
     * Retrieves the file name.
     * @return such information.
     */
    @Override
    @NotNull
    public String getFileName()
    {
        return this.m__strFileName;
    }

    /**
     * Concatenates given attributes.
     * @param attributes the attributes.
     * @return the CSV version of given list.
     */
    @NotNull
    protected String toCsv(@NotNull final List<Attribute<String>> attributes)
    {
        @NotNull final StringBuilder result = new StringBuilder();

        for (@Nullable final Attribute<String> t_Attribute : attributes)
        {
            if (t_Attribute != null)
            {
                if (result.length() > 0)
                {
                    result.append(",");
                }
                result.append(t_Attribute.getName());
            }
        }

        return result.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return
            new HashCodeBuilder().append(append(this.m__Command).toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable final Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final AbstractTemplateContext other = (AbstractTemplateContext) obj;

        return
            new EqualsBuilder().append(this.m__strHeader, other.m__strHeader)
            .append(this.m__DecoratorFactory, other.m__DecoratorFactory)
            .append(this.m__MetadataManager, other.m__MetadataManager)
            .append(this.m__CustomSqlProvider, other.m__CustomSqlProvider)
            .append(this.m__strPackageName, other.m__strPackageName)
            .append(this.m__strBasePackageName, other.m__strBasePackageName)
            .append(this.m__strRepositoryName, other.m__strRepositoryName)
            .append(this.m__bImplementMarkerInterfaces, other.m__bImplementMarkerInterfaces)
            .append(this.m__bJmx, other.m__bJmx).append(this.m__strJndiLocation, other.m__strJndiLocation)
            .append(this.m__bDisableGenerationTimestamps, other.m__bDisableGenerationTimestamps)
            .append(this.m__bDisableNotNullAnnotations, other.m__bDisableNotNullAnnotations)
            .append(this.m__bDisableCheckthreadAnnotations, other.m__bDisableCheckthreadAnnotations)
            .append(this.m__strFileName, other.m__strFileName)
            .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String toString()
    {
        return "AbstractTemplateContext{" +
               "disableCheckthreadAnnotations=" + m__bDisableCheckthreadAnnotations +
               ", header='" + m__strHeader + '\'' +
               ", decoratorFactory=" + m__DecoratorFactory +
               ", metadataManager=" + m__MetadataManager +
               ", customSqlProvider=" + m__CustomSqlProvider +
               ", packageName='" + m__strPackageName + '\'' +
               ", basePackageName='" + m__strBasePackageName + '\'' +
               ", repositoryName='" + m__strRepositoryName + '\'' +
               ", implementMarkerInterfaces=" + m__bImplementMarkerInterfaces +
               ", jmx=" + m__bJmx +
               ", jndiLocation='" + m__strJndiLocation + '\'' +
               ", disableGenerationTimestamps=" + m__bDisableGenerationTimestamps +
               ", disableNotNullAnnotations=" + m__bDisableNotNullAnnotations +
               ", fileName='" + m__strFileName + '\'' +
               '}';
    }
}
