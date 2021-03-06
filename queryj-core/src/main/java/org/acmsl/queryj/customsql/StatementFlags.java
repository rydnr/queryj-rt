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
 * Filename: StatementFlags.java
 *
 * Author: Jose San Leandro Armendariz (chous)
 *
 * Description: Represents the defined tags for customizing per-statement
 *              behavior.
 *
 * Date: 7/6/12
 * Time: 5:20 PM
 *
 */
package org.acmsl.queryj.customsql;

/*
 * Importing some JetBrains annotations.
 */
import org.jetbrains.annotations.Nullable;

/**
 * Represents the defined tags for customizing per-statement behavior.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro</a>
 * @since 2012/07/06
 */
public interface StatementFlags
    extends IdentifiableElement<String>
{
    /**
     * The <b>NO_GENERATED_KEYS</b> value for
     * <i>autogeneratekeys</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String NO_GENERATED_KEYS = "NO_GENERATED_KEYS";

    /**
     * The <b>RETURN_GENERATED_KEYS</b> value for
     * <i>autogeneratekeys</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String RETURN_GENERATED_KEYS = "RETURN_GENERATED_KEYS";

    /**
     * The <b>FETCH_FORWARD</b> value for <i>fetchdirection</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String FETCH_FORWARD = "FETCH_FORWARD";

    /**
     * The <b>FETCH_REVERSE</b> value for <i>fetchdirection</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String FETCH_REVERSE = "FETCH_REVERSE";

    /**
     * The <b>FETCH_UNKNOWN</b> value for <i>fetchdirection</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String FETCH_UNKNOWN = "FETCH_UNKNOWN";

    /**
     * The <b>CLOSE_CURRENT_RESULT</b> value for <i>moreresults</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String CLOSE_CURRENT_RESULT = "CLOSE_CURRENT_RESULT";

    /**
     * The <b>KEEP_CURRENT_RESULT</b> value for <i>moreresults</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String KEEP_CURRENT_RESULT = "KEEP_CURRENT_RESULT";

    /**
     * The <b>CLOSE_ALL_RESULTS</b> value for <i>moreresults</i> attribute.
     */
    @SuppressWarnings("unused")
    static final String CLOSE_ALL_RESULTS = "CLOSE_ALL_RESULTS";

    /**
     * Retrieves the auto-generated keys.
     * @return such information.
     */
    @Nullable
    String getAutogeneratedKeys();

    /**
     * Retrieves the fetch size.
     * @return such information.
     */
    @Nullable
    Integer getFetchSize();

    /**
     * Retrieves the maximum field size.
     * @return such value.
     */
    @Nullable
    Integer getMaxFieldSize();

    /**
     * Retrieves the maximum number of rows.
     * @return such value.
     */
    @Nullable
    Integer getMaxRows();

    /**
     * Retrieves the timeout for the query.
     * @return such value.
     */
    @Nullable
    Integer getQueryTimeout();

    /**
     * Retrieves the fetch direction.
     * @return such value.
     */
    @Nullable
    String getFetchDirection();

    /**
     * Retrieves whether the query should be processed for escaping characters.
     * @return such information.
     */
    boolean getEscapeProcessing();

    /**
     * Retrieves whether to retrieve more results.
     * @return such information.
     */
    @Nullable
    String getMoreResults();

    /**
     * Retrieves the cursor name.
     * @return such information.
     */
    @Nullable
    String getCursorName();

}
