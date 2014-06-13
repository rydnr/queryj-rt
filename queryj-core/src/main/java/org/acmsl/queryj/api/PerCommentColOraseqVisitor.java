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
 * Filename: PerCommentColOraseqVisitor.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Visits colOraseq rules in PerComment.g4 grammar.
 *
 * Date: 2014/06/13
 * Time: 19:57
 *
 */
package org.acmsl.queryj.api;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.tools.antlr.PerCommentBaseVisitor;
import org.acmsl.queryj.tools.antlr.PerCommentParser.ColOraseqContext;
import org.acmsl.queryj.tools.antlr.PerCommentParser.ColReadonlyContext;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

/**
 * Visits colOraseq rules in PerComment.g4 grammar.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/13 19:57
 */
@ThreadSafe
public class PerCommentColOraseqVisitor
    extends PerCommentBaseVisitor<String>
{
    /**
     * Visits the parser tree within the <pre>colReadonly</pre> rule.
     * @param context the parse context.
     * @return {@code true} if the comment declares the column is read-only.
     */
    @Nullable
    @Override
    public String visitColOraseq(@NotNull final ColOraseqContext context)
    {
        return context.getText();
    }
}

