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
 * Filename: CannotRetrieveMetadataManagerException.java
 *
 * Author: Jose San Leandro Armendariz (chous)
 *
 * Description: Represents the situation when the {@link org.acmsl.queryj.metadata.MetadataManager} instance is
 * not available, preventing QueryJ to run.
 *
 * Date: 6/11/13
 * Time: 8:08 PM
 *
 */
package org.acmsl.queryj.api.exceptions;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

/**
 * Represents the situation when the {@link org.acmsl.queryj.metadata.MetadataManager} instance is
 * not available, preventing QueryJ to run.
 * @author <a href="mailto:chous@acm-sl.org">Jose San Leandro</a>
 * @since 2013/06/11
 */
@ThreadSafe
public class CannotRetrieveMetadataManagerException
    extends QueryJBuildException
{
    private static final long serialVersionUID = -2620214881892724L;

    /**
     * Creates an instance to represent the exceptional situation.
     */
    public CannotRetrieveMetadataManagerException()
    {
        super("cannot.retrieve.metadatamanager.instance", new Object[0]);
    }
}
