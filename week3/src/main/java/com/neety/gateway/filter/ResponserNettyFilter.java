package com.neety.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class ResponserNettyFilter implements ResponseNettyFilter{
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("respose-header","eclipse");
    }
}
