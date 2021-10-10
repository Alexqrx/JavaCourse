package com.neety.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface ResponseNettyFilter {
    void filter(FullHttpResponse response);
}
