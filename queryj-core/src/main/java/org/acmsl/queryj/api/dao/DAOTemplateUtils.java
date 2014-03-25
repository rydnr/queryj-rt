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
 * Filename: DAOTemplateUtils.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Provides some useful methods when generating DAO classes
 *              via DAO template instances.
 */
package org.acmsl.queryj.api.dao;

/*
 * Importing some project-specific classes.
 */
import org.acmsl.queryj.api.MetaLanguageUtils;
import org.acmsl.queryj.customsql.*;
import org.acmsl.queryj.metadata.MetadataManager;
import org.acmsl.queryj.metadata.MetadataTypeManager;
import org.acmsl.queryj.metadata.MetadataUtils;
import org.acmsl.queryj.metadata.DecoratorFactory;
import org.acmsl.queryj.metadata.vo.Attribute;
import org.acmsl.queryj.metadata.vo.AttributeValueObject;
import org.acmsl.queryj.metadata.vo.Row;
import org.acmsl.queryj.metadata.vo.RowValueObject;
import org.acmsl.queryj.metadata.vo.Table;

/*
 * Importing some ACM-SL Commons classes.
 */
import org.acmsl.commons.logging.UniqueLogFactory;
import org.acmsl.commons.patterns.Singleton;
import org.acmsl.commons.patterns.Utils;

/*
 * Importing some JDK classes.
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
 * Importing some Apache Commons Logging classes.
 */
import org.apache.commons.logging.Log;

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
 * Provides some useful methods when generating DAO classes
 * via DAO template instances.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 */
@ThreadSafe
public class DAOTemplateUtils
    implements  Singleton,
                Utils
{
    /**
     * An empty String array.
     */
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    /**
     * The statement flags setter array.
     */
    private static final String[] STATEMENT_FLAGS_SETTERS = new String[9];

    /**
     * The autogeneratedkeys index.
     */
    protected static final int AUTOGENERATEDKEYS_INDEX = 0;

    /**
     * The fetchsize index.
     */
    protected static final int FETCHSIZE_INDEX = 1;

    /**
     * The maxfieldsize index.
     */
    protected static final int MAXFIELDSIZE_INDEX = FETCHSIZE_INDEX + 1;

    /**
     * The maxrows index.
     */
    protected static final int MAXROWS_INDEX = MAXFIELDSIZE_INDEX + 1;

    /**
     * The querytimeout index.
     */
    protected static final int QUERYTIMEOUT_INDEX = MAXROWS_INDEX + 1;

    /**
     * The fetchdirection index.
     */
    protected static final int FETCHDIRECTION_INDEX = QUERYTIMEOUT_INDEX + 1;

    /**
     * The escapeprocessing index.
     */
    protected static final int ESCAPEPROCESSING_INDEX = FETCHDIRECTION_INDEX + 1;

    /**
     * The moreresults index.
     */
    protected static final int MORERESULTS_INDEX = ESCAPEPROCESSING_INDEX + 1;

    /**
     * The cursorname index.
     */
    protected static final int CURSORNAME_INDEX = MORERESULTS_INDEX + 1;
    static
    {
        STATEMENT_FLAGS_SETTERS[AUTOGENERATEDKEYS_INDEX] = null;
        STATEMENT_FLAGS_SETTERS[FETCHSIZE_INDEX] = "setFetchSize({0})";
        STATEMENT_FLAGS_SETTERS[MAXFIELDSIZE_INDEX] = "setMaxFieldSize({0})";
        STATEMENT_FLAGS_SETTERS[MAXROWS_INDEX] = "setMaxRows({0})";
        STATEMENT_FLAGS_SETTERS[QUERYTIMEOUT_INDEX] = "setQueryTimeout({0})";
        STATEMENT_FLAGS_SETTERS[FETCHDIRECTION_INDEX] = "setFetchDirection({0})";
        STATEMENT_FLAGS_SETTERS[ESCAPEPROCESSING_INDEX] = "setEscapeProcessing({0})";
        STATEMENT_FLAGS_SETTERS[MORERESULTS_INDEX] = null;
        STATEMENT_FLAGS_SETTERS[CURSORNAME_INDEX] = "setCursorName(\"{0}\")";
    }

    /**
     * Singleton implemented to avoid the double-checked locking.
     */
    private static class DAOTemplateUtilsSingletonContainer
    {
        /**
         * The actual singleton.
         */
        public static final DAOTemplateUtils SINGLETON =
            new DAOTemplateUtils();
    }

    /**
     * Protected constructor to avoid accidental instantiation.
     */
    protected DAOTemplateUtils() {}

    /**
     * Retrieves a DAOTemplateUtils instance.
     * @return such instance.
     */
    @NotNull
    public static DAOTemplateUtils getInstance()
    {
        return DAOTemplateUtilsSingletonContainer.SINGLETON;
    }

    /**
     * Retrieves the setter methods.
     * @return the setter methods.
     */
    @NotNull
    protected final String[] immutableRetrieveStatementFlagsSetters()
    {
        return STATEMENT_FLAGS_SETTERS;
    }

    /**
     * Retrieves the setter methods.
     * @return the setter methods.
     */
    @SuppressWarnings("unused")
    @NotNull
    public String[] retrieveStatementFlagsSetters()
    {
        return clone(immutableRetrieveStatementFlagsSetters());
    }

    /**
     * Finds all <code>SqlElement</code> instances associated to given
     * result element.
     * @param resultId such id.
     * @param customSqlProvider the <code>CustomSqlProvider</code> instance.
     * @return all such entities.
     */
    @SuppressWarnings("unused")
    @NotNull
    public List<Sql<String>> findSqlElementsByResultId(
        @NotNull final String resultId,
        @NotNull final CustomSqlProvider customSqlProvider)
    {
        return
            findSqlElementsByResultId(
                resultId,
                customSqlProvider,
                CustomResultUtils.getInstance());
    }

    /**
     * Finds all <code>SqlElement</code> instances associated to given
     * result element.
     * @param resultId such id.
     * @param customSqlProvider the <code>CustomSqlProvider</code> instance.
     * @param customResultUtils the <code>CustomResultUtils</code> instance.
     * @return all such entities.
     */
    @NotNull
    protected List<Sql<String>> findSqlElementsByResultId(
        @NotNull final String resultId,
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final CustomResultUtils customResultUtils)
    {
        return
            customResultUtils.findSqlElementsByResultId(
                resultId, customSqlProvider);
    }

    /**
     * Checks whether given table name matches the DAO id.
     * @param tableName the table name.
     * @param daoId the DAO id.
     * @return <code>true</code> if they match.
     */
    public boolean matches(
        @NotNull final String tableName, @NotNull final String daoId)
    {
        return matches(tableName, daoId, MetadataUtils.getInstance());
    }

    /**
     * Checks whether given table name matches the DAO id.
     * @param tableName the table name.
     * @param daoId the DAO id.
     * @param metadataUtils the {@link MetadataUtils} instance.
     * @return <code>true</code> if they match.
     */
    protected boolean matches(
        @NotNull final String tableName,
        @NotNull final String daoId,
        @NotNull final MetadataUtils metadataUtils)
    {
        return metadataUtils.matches(tableName, daoId);
    }

    /**
     * Retrieves all <code>SqlElement</code> instances of given type.
     * @param customSqlProvider the <code>CustomSqlProvider</code> instance.
     * @param type the type.
     * @return such elements.
     */
    @SuppressWarnings("unused")
    @NotNull
    public List<Sql<String>> retrieveSqlElementsByType(
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final String type)
    {
        return
            retrieveSqlElementsByType(
                customSqlProvider, type, CustomResultUtils.getInstance());
    }

    /**
     * Retrieves all <code>SqlElement</code> instances of given type.
     * @param customSqlProvider the <code>CustomSqlProvider</code> instance.
     * @param customResultUtils the <code>CustomResultUtils</code> instance.
     * @param type the type.
     * @return such elements.
     */
    @NotNull
    protected List<Sql<String>> retrieveSqlElementsByType(
        final CustomSqlProvider customSqlProvider,
        @NotNull final String type,
        @NotNull final CustomResultUtils customResultUtils)
    {
        return
            customResultUtils.retrieveSqlElementsByType(
                customSqlProvider, type);
    }

    /**
     * Retrieves all <code>SqlElement</code> instances associated to
     * given result id.
     * @param customSqlProvider the <code>CustomSqlProvider</code> instance.
     * @param resultId the result id.
     * @return such elements.
     */
    @SuppressWarnings("unused")
    @NotNull
    public List<Sql<String>> retrieveSqlElementsByResultId(
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final String resultId)
    {
        return
            retrieveSqlElementsByResultId(
                customSqlProvider,
                resultId,
                CustomResultUtils.getInstance());
    }

    /**
     * Retrieves all <code>SqlElement</code> instances associated to
     * given result id.
     * @param customSqlProvider the <code>CustomSqlProvider</code> instance.
     * @param resultId the result id.
     * @param customResultUtils the <code>CustomResultUtils</code> instance.
     * @return such elements.
     */
    @NotNull
    protected List<Sql<String>> retrieveSqlElementsByResultId(
        @NotNull final CustomSqlProvider customSqlProvider,
        @NotNull final String resultId,
        @NotNull final CustomResultUtils customResultUtils)
    {
        return
            customResultUtils.retrieveSqlElementsByResultId(
                customSqlProvider, resultId);
    }

    /**
     * Clones given String array.
     * @param array the array to clone.
     * @return the cloned array.
     */
    @NotNull
    protected String[] clone(@Nullable final String[] array)
    {
        @NotNull String[] result = EMPTY_STRING_ARRAY;

        final int t_iCount = (array != null) ? array.length : 0;

        if  (t_iCount > 0)
        {
            result = new String[t_iCount];

            System.arraycopy(array, 0, result, 0, t_iCount);
        }

        return result;
    }

    /**
     * Queries the contents of given table.
     * @param tableName the table name.
     * @param metadataManager the metadata manager.
     * @param decoratorFactory the <code>DecoratorFactory</code> instance.
     * @return the retrieved rows.
     */
    @Nullable
    public List<Row<String>> queryContents(
        @NotNull final String tableName,
        @NotNull final MetadataManager metadataManager,
        @NotNull final DecoratorFactory decoratorFactory)
      throws  SQLException
    {
        return
            queryContents(
                tableName,
                metadataManager,
                decoratorFactory,
                MetaLanguageUtils.getInstance(),
                MetadataUtils.getInstance());
    }

    /**
     * Queries the contents of given table.
     * @param tableName the table name.
     * @param metadataManager the metadata manager.
     * @param decoratorFactory the <code>DecoratorFactory</code> instance.
     * @param metaLanguageUtils the <code>MetaLanguageUtils</code> instance.
     * @param metadataUtils the <code>MetadataUtils</code> instance.
     * @return the retrieved rows.
     */
    @NotNull
    public List<Row<String>> queryContents(
        @NotNull final String tableName,
        @NotNull final MetadataManager metadataManager,
        @NotNull final DecoratorFactory decoratorFactory,
        @NotNull final MetaLanguageUtils metaLanguageUtils,
        @NotNull final MetadataUtils metadataUtils)
      throws  SQLException
    {
        List<Row<String>> result = null;

        @Nullable final Table<String, Attribute<String>, List<Attribute<String>>> t_Table =
            metadataManager.getTableDAO().findByName(tableName);

        if (t_Table != null)
        {
            @Nullable final Attribute<String> t_StaticAttribute = t_Table.getStaticAttribute();

            @Nullable final Attribute<String> t_strStaticAttribute;

            if (t_StaticAttribute == null)
            {
                t_strStaticAttribute = metaLanguageUtils.retrieveStaticAttribute(t_Table.getComment());

            if (t_strStaticAttribute != null)
            {
                result =
                    queryContents(
                        tableName,
                        t_strStaticAttribute,
                        metadataUtils.retrieveAttributes(tableName, metadataManager),
                        metadataManager,
                        decoratorFactory);
            }
        }

        if (result == null)
        {
            result = new ArrayList<Row<String>>(0);
        }

        return result;
    }

    /**
     * Queries the contents of given table.
     * @param tableName the table name.
     * @param staticAttributeName the name of the static attribute.
     * @param attributes the attributes.
     * @param metadataManager the metadata manager.
     * @param decoratorFactory the <code>DecoratorFactory</code> instance.
     * @return the retrieved rows.
     */
    @NotNull
    public List<Row<String>> queryContents(
        @NotNull final String tableName,
        @Nullable final String staticAttributeName,
        @NotNull final List<Attribute<String>> attributes,
        @NotNull final MetadataManager metadataManager,
        @NotNull final DecoratorFactory decoratorFactory)
      throws  SQLException
    {
        return
            queryContents(
                tableName,
                staticAttributeName,
                attributes,
                metadataManager,
                metadataManager.getMetadataTypeManager(),
                decoratorFactory,
                metadataManager.getMetaData());
    }

    /**
     * Queries the contents of given table.
     * @param tableName the table name.
     * @param staticAttributeName the name of the static attribute.
     * @param attributes the attributes.
     * @param metadataManager the metadata manager.
     * @param metadataTypeManager the metadata type manager.
     * @param decoratorFactory the <code>DecoratorFactory</code> instance.
     * @param metaData the metadata.
     * @return the retrieved rows.
     */
    @NotNull
    protected List<Row<String>> queryContents(
        @NotNull final String tableName,
        @Nullable final String staticAttributeName,
        @NotNull final List<Attribute<String>> attributes,
        @NotNull final MetadataManager metadataManager,
        @NotNull final MetadataTypeManager metadataTypeManager,
        @NotNull final DecoratorFactory decoratorFactory,
        @NotNull final DatabaseMetaData metaData)
      throws  SQLException
    {
        return
            queryContents(
                tableName,
                staticAttributeName,
                attributes,
                metadataManager,
                metadataTypeManager,
                decoratorFactory,
                MetadataUtils.getInstance(),
                metaData.getConnection());
    }

    /**
     * Queries the contents of given table.
     * @param tableName the table name.
     * @param staticAttributeName the static attribute name.
     * @param attributes the attributes.
     * @param metadataManager the metadata manager.
     * @param metadataTypeManager the metadata type manager.
     * @param decoratorFactory the <code>DecoratorFactory</code> instance.
     * @param metadataUtils the <code>MetadataUtils</code> instance.
     * @param connection the connection.
     * @return the retrieved rows.
     */
    @SuppressWarnings("unused")
    @NotNull
    protected List<Row<String>> queryContents(
        @NotNull final String tableName,
        @Nullable final String staticAttributeName,
        @NotNull final List<Attribute<String>> attributes,
        @NotNull final MetadataManager metadataManager,
        @NotNull final MetadataTypeManager metadataTypeManager,
        @NotNull final DecoratorFactory decoratorFactory,
        @NotNull final MetadataUtils metadataUtils,
        @NotNull final Connection connection)
      throws  SQLException
    {
        // TODO: Move this to TableDAO
        @NotNull final List<Row<String>> result = new ArrayList<Row<String>>();

        @Nullable final Log t_Log = UniqueLogFactory.getLog(DAOTemplateUtils.class);
        
        final int t_iColumnCount = attributes.size();

        @Nullable ResultSet t_rsResults = null;

        @Nullable PreparedStatement t_PreparedStatement = null;

        try
        {
            t_PreparedStatement =
                connection.prepareStatement(
                    "select * from " + tableName);

            t_rsResults = t_PreparedStatement.executeQuery();

            @NotNull final String[] t_astrColumnNames = new String[t_iColumnCount];

            @NotNull final String[] t_astrColumnValues = new String[t_iColumnCount];

            @Nullable String t_strRowName;

            if  (t_rsResults != null)
            {
                while  (t_rsResults.next())
                {
                    t_strRowName = null;

                    @NotNull final ResultSetMetaData t_rsMetaData =
                        t_rsResults.getMetaData();

                    int t_iArrayIndex;

                    for  (int t_iIndex = 1;
                              t_iIndex <= t_iColumnCount;
                              t_iIndex++)
                    {
                        t_iArrayIndex = t_iIndex - 1;

                        t_astrColumnNames[t_iArrayIndex] =
                            t_rsMetaData.getColumnName(t_iIndex);

                        t_astrColumnValues[t_iArrayIndex] =
                            t_rsResults.getString(t_iIndex);

                        if  (staticAttributeName.equalsIgnoreCase(
                                 t_astrColumnNames[t_iArrayIndex]))
                        {
                            t_strRowName = t_astrColumnValues[t_iArrayIndex];
                        }
                    }

                    reorderAttributes(
                        attributes, t_astrColumnNames, t_astrColumnValues);

                    @NotNull final List<Attribute<String>> t_lAttributes = new ArrayList<Attribute<String>>(t_astrColumnValues.length);

                    Attribute<String> t_NewAttribute;

                    for (int t_iIndex = 0; t_iIndex < t_astrColumnValues.length; t_iIndex++)
                    {
                        @Nullable final Attribute<String> t_Attribute = attributes.get(t_iIndex);

                        if (t_Attribute != null)
                        {
                            t_NewAttribute =
                                new AttributeValueObject(
                                    t_Attribute.getName(),
                                    t_Attribute.getTypeId(),
                                    t_Attribute.getType(),
                                    t_Attribute.getTableName(),
                                    t_Attribute.getComment(),
                                    t_Attribute.getOrdinalPosition(),
                                    t_Attribute.getLength(),
                                    t_Attribute.getPrecision(),
                                    t_Attribute.getKeyword(),
                                    t_Attribute.getRetrievalQuery(),
                                    t_Attribute.getSequence(),
                                    t_Attribute.isNullable(),
                                    t_astrColumnValues[t_iIndex],
                                    t_Attribute.isReadOnly(),
                                    t_Attribute.isBoolean(),
                                    t_Attribute.getBooleanTrue(),
                                    t_Attribute.getBooleanFalse(),
                                    t_Attribute.getBooleanNull());

                            t_lAttributes.add(t_NewAttribute);
                        }
                    }

                    result.add(
                        buildRow(
                            t_strRowName,
                            tableName,
                            t_lAttributes));
                }
            }
        }
        finally
        {
            try 
            {
                if  (t_rsResults != null)
                {
                    t_rsResults.close();
                }
            }
            catch  (@NotNull final SQLException sqlException)
            {
                if  (t_Log != null)
                {
                    t_Log.error(
                        "Cannot close the ResultSet.",
                        sqlException);
                }
            }

            try 
            {
                if  (t_PreparedStatement != null)
                {
                    t_PreparedStatement.close();
                }
            }
            catch  (@NotNull final SQLException sqlException)
            {
                if  (t_Log != null)
                {
                    t_Log.error(
                        "Cannot close the PreparedStatement.",
                        sqlException);
                }
            }
        }

        return result;
    }

    /**
     * Builds a row with given information.
     * @param rowName the row name.
     * @param tableName the table name.
     * @param attributes the attributes.
     * @return the row.
     */
    @NotNull
    protected Row<String> buildRow(
        @NotNull final String rowName,
        @NotNull final String tableName,
        @NotNull final List<Attribute<String>> attributes)
    {
        return new RowValueObject(rowName, tableName, attributes);
    }

    /**
     * Reorders the attributes in the same order as the original ones.
     * @param attributes the original attributes.
     * @param names the retrieved attribute names.
     * @param values the retrieved attribute values.
     */
    protected void reorderAttributes(
        @Nullable final Collection<Attribute<String>> attributes,
        @NotNull final String[] names,
        @NotNull final String[] values)
    {
        @Nullable final Iterator<Attribute<String>> t_itAttributeIterator =
            (attributes != null) ? attributes.iterator() : null;

        if  (t_itAttributeIterator != null)
        {
            Attribute<String> t_CurrentAttribute;
            int t_iIndex = 0;
            int t_iPosition;
            final int t_iCount = attributes.size();

            @NotNull final String[] t_astrAuxNames = new String[t_iCount];
            @NotNull final String[] t_astrAuxValues = new String[t_iCount];

            while  (t_itAttributeIterator.hasNext())
            {
                t_CurrentAttribute = t_itAttributeIterator.next();

                t_iPosition =
                    retrieveAttributeIndex(t_CurrentAttribute.getName(), names);

                if  (   (t_iPosition >= 0)
                     && (t_iPosition < t_iCount))
                {
                    t_astrAuxNames[t_iIndex] = names[t_iPosition];
                    t_astrAuxValues[t_iIndex] = values[t_iPosition];
                }

                t_iIndex++;
            }

            copyArray(t_astrAuxNames, names);
            copyArray(t_astrAuxValues, values);
        }
    }

    /**
     * Retrieves the index of the attribute in given collection.
     * @param name the attribute name.
     * @param attributes the attributes.
     * @return such index.
     */
    protected int retrieveAttributeIndex(
        @NotNull final String name, @Nullable final String[] attributes)
    {
        int result = -1;

        final int t_iCount = (attributes != null) ? attributes.length : 0;

        String t_strAttribute;

        if (attributes != null)
        {
            for  (int t_iIndex = 0; t_iIndex < t_iCount; t_iIndex++)
            {
                t_strAttribute = attributes[t_iIndex];

                if (name.equals(t_strAttribute))
                {
                    result = t_iIndex;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Copies given array.
     * @param source the source.
     * @param target the target.
     */
    protected void copyArray(@NotNull final String[] source, @NotNull final String[] target)
    {
        System.arraycopy(source, 0, target, 0, source.length);
    }
}
