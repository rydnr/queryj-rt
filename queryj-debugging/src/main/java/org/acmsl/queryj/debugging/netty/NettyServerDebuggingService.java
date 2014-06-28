/*
                        QueryJ Template Debugging

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
 * Filename: NettyServerDebuggingService.java
 *
 * Author: Jose San Leandro Armendariz
 *
 * Description: Netty-based TCP/IP server which drives the template debugging
 *              process.
 *
 * Date: 2014/06/26
 * Time: 18:43
 *
 */
package org.acmsl.queryj.debugging.netty;

/*
 * Importing QueryJ Core classes.
 */
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import org.acmsl.queryj.api.TemplateContext;
import org.acmsl.queryj.api.exceptions.DevelopmentModeException;
import org.acmsl.queryj.tools.debugging.TemplateDebuggingService;

/*
 * Importing StringTemplate classes.
 */
import org.stringtemplate.v4.ST;

/*
 * Importing JetBrains annotations.
 */
import org.jetbrains.annotations.NotNull;

/*
 * Importing checkthread.org annotations.
 */
import org.checkthread.annotations.ThreadSafe;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Netty-based TCP/IP server which drives the
 * template debugging process.
 * @author <a href="mailto:queryj@acm-sl.org">Jose San Leandro</a>
 * @since 3.0
 * Created: 2014/06/26 18:43
 */
@ThreadSafe
public class NettyServerDebuggingService<C extends TemplateContext>
    extends ChannelHandlerAdapter
    implements TemplateDebuggingService<C>
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void debugTemplate(@NotNull final ST template, @NotNull final C context, @NotNull final String output)
        throws DevelopmentModeException
    {
        // launch the server
    }

    public void launchServer()
        throws InterruptedException,
                IOException
    {
        final NioEventLoopGroup group = new NioEventLoopGroup(1);

        try
        {
            @NotNull final ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group).channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(this);

            @NotNull final SocketAddress address = serverBootstrap.bind(0).sync().channel().localAddress();

            @NotNull final Socket socket = new Socket(NetUtil.LOCALHOST, ((InetSocketAddress) address).getPort());

            @NotNull final DataOutput out = new DataOutputStream(socket.getOutputStream());
            @NotNull final byte[] buf = "reload".getBytes(CharsetUtil.US_ASCII);
            out.write(buf);
            socket.close();

            while (myChannelHandlerAdapter.m__bAlive)
            {
                Thread.sleep(100);
            }

            Assert.assertEquals("reload", myChannelHandlerAdapter.m__strCommand);

        }
        finally
        {
            group.shutdownGracefully().sync();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx)
        throws Exception
    {
        ctx.read();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void channelRead(@NotNull final ChannelHandlerContext ctx, @NotNull final Object msg)
    {
        @NotNull final ByteBuf buffer = (ByteBuf) msg;

        @NotNull final byte[] aux = new byte[buffer.readableBytes()];

        for (int index = 0; index < aux.length; index++)
        {
            aux[index] = buffer.readByte();
        }

        this.m__strCommand = new String(aux, CharsetUtil.US_ASCII);
        this.m__bAlive = false;
    }
}
