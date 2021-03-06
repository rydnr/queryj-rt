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
 * Filename: StatementFlagsElement.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Models <statement-flags> elements in custom-sql models.
 *
 */
package org.acmsl.queryj.customsql;

/*
 * Importing project-specific classes.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing JDK classes.
 */

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Models &lt;statement-flags&gt; elements in <i>custom-sql</i> models, which
 * satisfy the following DTD extract (to describe the model even in
 * non-xml implementations):
 * &lt;!ELEMENT statement-flags EMPTY&gt;
 * &lt;!ATTLIST statement-flags
 *   id ID #REQUIRED
 *   autogeneratedkeys (NO_GENERATED_KEYS | RETURN_GENERATED_KEYS) #IMPLIED
 *   fetchsize CDATA #IMPLIED
 *   maxfieldsize CDATA #IMPLIED
 *   maxrows CDATA #IMPLIED
 *   querytimeout CDATA #IMPLIED
 *   fetchdirection (FETCH_FORWARD | FETCH_REVERSE | FETCH_UNKNOWN) #IMPLIED
 *   escapeprocessing (true | false) #IMPLIED
 *   moreresults (CLOSE_CURRENT_RESULT | KEEP_CURRENT_RESULT | CLOSE_ALL_RESULTS) #IMPLIED&gt;
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro Armendariz</a>
 */
@ThreadSafe
public class StatementFlagsElement
    extends  AbstractIdElement<String>
    implements StatementFlags
{
    /**
     * The serial version id.
     */
    private static final long serialVersionUID = 746837714725279600L;

    /**
     * The <i>autogeneratedkeys</i> attribute.
     */
    public String m__strAutogeneratedKeys;

    /**
     * The <i>fetchsize</i> attribute.
     */
    public Integer m__iFetchSize;

    /**
     * The <i>maxfieldsize</i> attribute.
     */
    public Integer m__iMaxFieldSize;

    /**
     * The <i>maxrows</i> attribute.
     */
    public Integer m__iMaxRows;

    /**
     * The <i>querytimeout</i> attribute.
     */
    public Integer m__iQueryTimeout;

    /**
     * The <i>fetchdirection</i> attribute.
     */
    public String m__strFetchDirection;

    /**
     * The <i>escapeprocessing</i> attribute.
     */
    public Boolean m__bEscapeProcessing;

    /**
     * The <i>moreresults</i> attribute.
     */
    public String m__strMoreResults;

    /**
     * The <i>cursorname</i> attribute.
     */
    public String m__strCursorName;

    /**
     * Creates a StatementFlagsElement with given information.
     * @param id the <i>id</i> attribute.
     * @param autogeneratedKeys the <i>autogeneratedkeys</i> attribute.
     * @param fetchSize the <i>fetchsize</i> attribute.
     * @param maxFieldSize the <i>maxfieldsize</i> attribute.
     * @param maxRows the <i>maxrows</i> attribute.
     * @param queryTimeout the <i>querytimeout</i> attribute.
     * @param fetchDirection the <i>fetchdirection</i> attribute.
     * @param escapeProcessing the <i>escapeprocessing</i> attribute.
     * @param moreResults the <i>moreresults</i> attribute.
     * @param cursorName the <i>cursorname</i> attribute.
     */
    public StatementFlagsElement(
        @NotNull final String id,
        @Nullable final String autogeneratedKeys,
        @Nullable final Integer fetchSize,
        @Nullable final Integer maxFieldSize,
        @Nullable final Integer maxRows,
        @Nullable final Integer queryTimeout,
        @Nullable final String fetchDirection,
        @Nullable final Boolean escapeProcessing,
        @Nullable final String moreResults,
        @Nullable final String cursorName)
    {
        super(id);
        if (autogeneratedKeys != null)
        {
            immutableSetAutogeneratedKeys(autogeneratedKeys);
        }
        if (fetchSize != null)
        {
            immutableSetFetchSize(fetchSize);
        }
        if (maxFieldSize != null)
        {
            immutableSetMaxFieldSize(maxFieldSize);
        }
        if (maxRows != null)
        {
            immutableSetMaxRows(maxRows);
        }
        if (queryTimeout != null)
        {
            immutableSetQueryTimeout(queryTimeout);
        }
        if (fetchDirection != null)
        {
            immutableSetFetchDirection(fetchDirection);
        }
        if (escapeProcessing != null)
        {
            immutableSetEscapeProcessing(escapeProcessing);
        }
        else
        {
            immutableSetEscapeProcessing(false);
        }
        if (moreResults != null)
        {
            immutableSetMoreResults(moreResults);
        }
        if (cursorName != null)
        {
            immutableSetCursorName(cursorName);
        }
    }

    /**
     * Specifies the <i>autogeneratedkeys</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetAutogeneratedKeys(@NotNull final String value)
    {
        m__strAutogeneratedKeys = value;
    }

    /**
     * Specifies the <i>autogeneratedkeys</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setAutogeneratedKeys(@NotNull final String value)
    {
        immutableSetAutogeneratedKeys(value);
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    public String getAutogeneratedKeys()
    {
        return m__strAutogeneratedKeys;
    }

    /**
     * Specifies the <i>fetchsize</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetFetchSize(@NotNull final Integer value)
    {
        m__iFetchSize = value;
    }

    /**
     * Specifies the <i>fetchsize</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setFetchSize(@NotNull final Integer value)
    {
        immutableSetFetchSize(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public Integer getFetchSize()
    {
        return m__iFetchSize;
    }

    /**
     * Specifies the <i>maxfieldsize</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetMaxFieldSize(@NotNull final Integer value)
    {
        m__iMaxFieldSize = value;
    }

    /**
     * Specifies the <i>maxfieldsize</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setMaxFieldSize(@NotNull final Integer value)
    {
        immutableSetMaxFieldSize(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public Integer getMaxFieldSize()
    {
        return m__iMaxFieldSize;
    }

    /**
     * Specifies the <i>maxrows</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetMaxRows(@NotNull final Integer value)
    {
        m__iMaxRows = value;
    }

    /**
     * Specifies the <i>maxrows</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setMaxRows(@NotNull final Integer value)
    {
        immutableSetMaxRows(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public Integer getMaxRows()
    {
        return m__iMaxRows;
    }

    /**
     * Specifies the <i>querytimeout</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetQueryTimeout(@NotNull final Integer value)
    {
        m__iQueryTimeout = value;
    }

    /**
     * Specifies the <i>querytimeout</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setQueryTimeout(@NotNull final Integer value)
    {
        immutableSetQueryTimeout(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public Integer getQueryTimeout()
    {
        return m__iQueryTimeout;
    }

    /**
     * Specifies the <i>fetchdirection</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetFetchDirection(@NotNull final String value)
    {
        m__strFetchDirection = value;
    }

    /**
     * Specifies the <i>fetchdirection</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setFetchDirection(@NotNull final String value)
    {
        immutableSetFetchDirection(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public String getFetchDirection()
    {
        return m__strFetchDirection;
    }

    /**
     * Specifies the <i>escapeprocessing</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetEscapeProcessing(@NotNull final Boolean value)
    {
        m__bEscapeProcessing = value;
    }

    /**
     * Specifies the <i>escapeprocessing</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setEscapeProcessing(@NotNull final Boolean value)
    {
        immutableSetEscapeProcessing(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getEscapeProcessing()
    {
        return m__bEscapeProcessing;
    }

    /**
     * Specifies the <i>moreresults</i> attribute.
     * @param value such value.
     */
    protected final void immutableSetMoreResults(@NotNull final String value)
    {
        m__strMoreResults = value;
    }

    /**
     * Specifies the <i>moreresults</i> attribute.
     * @param value such value.
     */
    @SuppressWarnings("unused")
    protected void setMoreResults(@NotNull final String value)
    {
        immutableSetMoreResults(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public String getMoreResults()
    {
        return m__strMoreResults;
    }

    /**
     * Specifies the cursor name.
     * @param name such name.
     */
    protected final void immutableSetCursorName(@NotNull final String name)
    {
        m__strCursorName = name;
    }

    /**
     * Specifies the cursor name.
     * @param name such name.
     */
    @SuppressWarnings("unused")
    protected void setCursorName(@NotNull final String name)
    {
        immutableSetCursorName(name);
    }

    /**
     * Retrieves the cursor name.
     * @return such information.
     */
    @Override
    @Nullable
    public String getCursorName()
    {
        return m__strCursorName;
    }

    /**
     * Provides a text information about this instance.
     * @return such information.
     */
    @Override
    @NotNull
    public String toString()
    {
        return
            toString(
                getId(),
                getAutogeneratedKeys(),
                getFetchSize(),
                getMaxFieldSize(),
                getMaxRows(),
                getQueryTimeout(),
                getFetchDirection(),
                getEscapeProcessing(),
                getMoreResults(),
                getCursorName());
    }

    /**
     * Provides a text information about this instance.
     * @param id the <i>id</i> attribute.
     * @param autogeneratedKeys the <i>autogeneratedkeys</i> attribute.
     * @param fetchSize the <i>fetchsize</i> attribute.
     * @param maxFieldSize the <i>maxfieldsize</i> attribute.
     * @param maxRows the <i>maxrows</i> attribute.
     * @param queryTimeout the <i>querytimeout</i> attribute.
     * @param fetchDirection the <i>fetchdirection</i> attribute.
     * @param escapeProcessing the <i>escapeprocessing</i> attribute.
     * @param moreResults the <i>moreresults</i> attribute.
     * @param cursorName the <i>cursorname</i> attribute.
     * @return such information.
     */
    @NotNull
    protected String toString(
        final String id,
        final String autogeneratedKeys,
        final Integer fetchSize,
        final Integer maxFieldSize,
        final Integer maxRows,
        final Integer queryTimeout,
        final String fetchDirection,
        final Boolean escapeProcessing,
        final String moreResults,
        final String cursorName)
    {
        return
              getClass().getName()
            + "[" + "id=" + id + "]"
            + "[" + "autogeneratedKeys=" + autogeneratedKeys + "]"
            + "[" + "fetchSize=" + fetchSize + "]"
            + "[" + "maxFieldSize=" + maxFieldSize + "]"
            + "[" + "maxRows=" + maxRows + "]"
            + "[" + "queryTimeout=" + queryTimeout + "]"
            + "[" + "fetchDirection=" + fetchDirection + "]"
            + "[" + "escapeProcessing=" + escapeProcessing + "]"
            + "[" + "moreResults=" + moreResults + "]"
            + "[" + "cursorName=" + cursorName + "]";
    }
}
