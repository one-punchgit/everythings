package com.zb.thing.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class NettyClient {
    static int inCre = 1;

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress("localhost", 8081)) // 设置远程服务器地址和端口号
                    .handler(new ClientInit());

            // 连接服务器并发送消息
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().writeAndFlush("hello world" + inCre++ );
            // 发送消息
//            channelFuture.channel().writeAndFlush("Hello, World!");
            // 等待连接关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 关闭连接池并释放所有资源
            System.out.println("guanbi00");
            group.shutdownGracefully().sync();
        }
    }
}
