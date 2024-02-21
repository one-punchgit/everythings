package com.zb.thing.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ServerInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new ServerTestOutHandler());
        channel.pipeline().addLast(new ServerDecoderHandler());
        channel.pipeline().addLast(new ServerEncoderHandler());
    }
}
