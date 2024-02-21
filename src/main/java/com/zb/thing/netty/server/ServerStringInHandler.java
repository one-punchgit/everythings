package com.zb.thing.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerStringInHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Thread.sleep(1000);
        System.out.println("server string accept channelRead0:"+ s.toString());
        ctx.writeAndFlush(s);
//        ctx.close();
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("server string accept channelRead:"+ msg.toString());
//        ctx.writeAndFlush(msg);
//        ctx.close();
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
