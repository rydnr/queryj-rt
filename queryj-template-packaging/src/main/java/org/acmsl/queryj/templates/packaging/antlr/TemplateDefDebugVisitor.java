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
 * Filename: TemplateDefDebugVisitor.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: 
 *
 * Date: 2014/05/12
 * Time: 05:14
 *
 */
package org.acmsl.queryj.templates.packaging.antlr;

/*
 * Importing JetBrains annotations.
 */
import org.acmsl.queryj.templates.packaging.antlr.TemplateDefParser.DisabledRuleContext;
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;
import org.jetbrains.annotations.Nullable;

/**
 *
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/05/12 05:14
 */
@ThreadSafe
public class TemplateDefDebugVisitor
    extends TemplateDefBaseVisitor<Boolean>
{
    /**
     * Whether the template def is disabled or not.
     */
    private boolean m__bDisabled;

    /**
     * Specifies whether the template def is disabled.
     * @param disabled if the template def is disabled.
     */
    protected final void immutableSetDisabled(final boolean disabled)
    {
        this.m__bDisabled = disabled;
    }

    /**
     * Specifies whether the template def is disabled.
     * @param disabled if the template def is disabled.
     */
    @SuppressWarnings("unused")
    protected void setDisabled(final boolean disabled)
    {
        immutableSetDisabled(disabled);
    }

    /**
     * Retrieves whether the template def is disabled.
     * @return such information.
     */
    public boolean isDisabled()
    {
        return this.m__bDisabled;
    }

    /**
     * {@inheritDoc}
     * The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.
     */
    @Override
    @Nullable
    public Boolean visitDisabledRule(@NotNull final DisabledRuleContext ctx)
    {
        setDisabled(true);

        return super.visitDisabledRule(ctx);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public String toString()
    {
        return
            "{ \"class\": \"" + TemplateDefDisabledVisitor.class.getSimpleName() + '"'
            + ", \"disabled\": " + m__bDisabled + " }";
    }
}
