package com.zb.thing.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class ClientEncoderHandler extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {

        Thread.sleep(1000);
        byte[] bytes = o.toString().getBytes(StandardCharsets.UTF_8);
        System.out.println("【out】client 编码 msg to byte encode,byte length:"+bytes.length);
        byteBuf.writeBytes(bytes);
        channelHandlerContext.flush();
    }
}
