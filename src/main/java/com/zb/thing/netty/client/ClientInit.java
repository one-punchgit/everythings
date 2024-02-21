package com.zb.thing.netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ClientInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new ClientDecoderHandler());
        channel.pipeline().addLast(new ClientEncoderHandler());
    }
}
