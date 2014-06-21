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
 * Importing ACM S.L. Java Commons classes.
 */
import org.acmsl.commons.utils.ToStringUtils;

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
           execution(public String *.toString())
        && target(instance);

    /**
     * Auditing the toString() pointcut.
     */
    String around(final Object instance) :
        toStringCall(instance)
    {
        return ToStringUtils.getInstance().auditToString(instance);
    }
}
