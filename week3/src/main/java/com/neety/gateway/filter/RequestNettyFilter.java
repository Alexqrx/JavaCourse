package com.neety.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface RequestNettyFilter {
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
}
