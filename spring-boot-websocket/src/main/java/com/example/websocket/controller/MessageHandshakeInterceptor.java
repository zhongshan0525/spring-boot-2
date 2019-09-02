package com.example.websocket.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
public class MessageHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse
            response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws
            Exception {
        String path = request.getURI().getPath();
        String[] ss = StringUtils.split(path, '/');
        if (ss.length != 2) {
            return false;
        }
        if (!StringUtils.isNumeric(ss[1])) {
            return false;
        }
        System.out.println(ss[1]);
        attributes.put("uid", ss[1]);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse
            response, WebSocketHandler wsHandler, Exception exception) {
    }
}