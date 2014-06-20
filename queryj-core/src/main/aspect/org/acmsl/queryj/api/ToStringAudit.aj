/*
                        QueryJ Core

    Copyright (C) 2002-today Jose San Leandro Armend�riz
                        queryj@acm-sl.org

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

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
                    Urb. Valdecaba�as
                    Boadilla del monte
                    28660 Madrid
                    Spain

 ******************************************************************************
 *
 * Filename: ToStringAudit.aj
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Audits recursive calls on toString().
 *
 */
package org.acmsl.queryj.api;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Importing JDK classes.
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Audits recursive calls on toString().
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/20 18:36
 */
public aspect ToStringAudit
{
    /**
     * The pointcut for "toString()"
     */
    pointcut toStringCall(final Object instance):
           execution(public String Object.toString())
        && target(instance);

    /**
     * Auditing the toString() pointcut.
     */
    String around(final Object instance) :
        toStringCall(instance)
    {
        return ToStringUtils.getInstance().auditToString(instance);
    }

    /**
     * Caching the "retrieveDiscriminatingParent(String) pointcut.
     */
    String around(final MetaLanguageUtils instance, final String comment) :
        cacheDiscriminatingParent(comment)
    {
        @Nullable String result;
        @NotNull final String key = "[comment/discriminating-parent]" + comment;

        result = DISCRIMINATING_PARENT_CACHE.get(key);

        if (result == null)
        {
            result = proceed(instance, comment);

            if (result == null)
            {
                DISCRIMINATING_PARENT_CACHE.put(key, key);
            }
            else
            {
                DISCRIMINATING_PARENT_CACHE.put(key, result);
            }
        }
        else if (result.equals(key))
        {
            result = null;
        }

        return result;
    }

    /**
     * Caching the "retrieveColumnBool(String) pointcut.
     */
    String[] around(final MetaLanguageUtils instance, final String comment) :
        cacheColumnBool(comment)
    {
        @Nullable String[] result;
        @NotNull final String key = "[comment/column-bool]" + comment;

        result = COLUMN_BOOL_CACHE.get(key);

        if (result == null)
        {
            result = proceed(instance, comment);

            if (result == null)
            {
                COLUMN_BOOL_CACHE.put(key, key);
            }
            else
            {
                COLUMN_BOOL_CACHE.put(key, result);
            }
        }
        else if (result.equals(key))
        {
            result = null;
        }

        return result;
    }

    /**
     * Caching the "retrieveColumnReadOnly(String) pointcut.
     */
    boolean around(final MetaLanguageUtils instance, final String comment) :
        cacheColumnReadOnly(comment)
    {
        boolean result;
        @NotNull final String key = "[comment/column-readonly]" + comment;

        result = COLUMN_BOOL_CACHE.get(key);

        if (result == null)
        {
            result = proceed(instance, comment);

            COLUMN_BOOL_CACHE.put(key, result);
        }

        return result;
    }

    /**
     * Caching the "retrieveColumnDiscriminatedTables(String) pointcut.
     */
    List<List<String>> around(final MetaLanguageUtils instance, final String comment) :
        cacheColumnDiscriminatedTables(comment)
    {
        @Nullable List<List<String>> result;
        @NotNull final String key = "[comment/column-discriminated-tables]" + comment;

        result = COLUMN_DISCRIMINATED_TABLES_CACHE.get(key);

        if (result == null)
        {
            result = proceed(instance, comment);

            if (result == null)
            {
                COLUMN_DISCRIMINATED_TABLES_CACHE.put(key, key);
            }
            else
            {
                COLUMN_DISCRIMINATED_TABLES_CACHE.put(key, result);
            }
        }
        else if (result.equals(key))
        {
            result = new ArrayList<>(0);
        }

        return result;
    }

    /**
     * Caching the "retrieveTableDecorator(String) pointcut.
     */
    boolean around(final MetaLanguageUtils instance, final String comment) :
        cacheTableDecorator(comment)
    {
        boolean result;
        @NotNull final String key = "[comment/table-decorator]" + comment;

        result = TABLE_DECORATOR_CACHE.get(key);

        if (result == null)
        {
            result = proceed(instance, comment);

            TABLE_DECORATOR_CACHE.put(key, result);
        }

        return result;
    }

    /**
     * Caching the "retrieveTableRelationship(String) pointcut.
     */
    List<List<String>> around(final MetaLanguageUtils instance, final String comment) :
        cacheTableRelationship(comment)
    {
        @Nullable List<List<String>> result;
        @NotNull final String key = "[comment/table-relationship]" + comment;

        result = TABLE_RELATIONSHIP_CACHE.get(key);

        if (result == null)
        {
            result = proceed(instance, comment);

            if (result == null)
            {
                TABLE_RELATIONSHIP_CACHE.put(key, key);
            }
            else
            {
                TABLE_RELATIONSHIP_CACHE.put(key, result);
            }
        }
        else if (result.equals(key))
        {
            result = new ArrayList<>(0);
        }

        return result;
    }

}
