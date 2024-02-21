package com.zb.thing.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ClientDecoderHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Thread.sleep(1000);
        byte[] byteArray = new byte[byteBuf.readableBytes()]; // 根据可读字节数创建字节数组
        byteBuf.readBytes(byteArray);
        String s = new String(byteArray);
        System.out.println("【in】client 解码 byte to msg:" + s);
        list.add(s);
        s = s + NettyClient.inCre ++ ;
        channelHandlerContext.channel().writeAndFlush(s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
