package com.zb.thing.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ServerDecoderHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Thread.sleep(1000);
        byte[] byteArray = new byte[byteBuf.readableBytes()]; // 根据可读字节数创建字节数组
        byteBuf.readBytes(byteArray);
        String s = new String(byteArray);
        System.out.println("【in】server 解码 byte to msg:" + s);
        list.add(s);
        channelHandlerContext.channel().writeAndFlush(s);
    }
}
