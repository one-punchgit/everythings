package com.zb.thing.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

public class ClientStringInHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Thread.sleep(1000);
        ByteBuf byteBuf = Unpooled.copiedBuffer(s.getBytes(StandardCharsets.UTF_8));
        //channelRead invoke 用户实现的channelRead0
        System.out.println("client string accept:"+s);
        ctx.writeAndFlush(s);
//        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("client connect string success");
//        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world".getBytes(StandardCharsets.UTF_8));
////        ctx.writeAndFlush(byteBuf);
//        ctx.writeAndFlush("string");
//    }
}
