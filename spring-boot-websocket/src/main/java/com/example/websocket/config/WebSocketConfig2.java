package com.example.websocket.config;

import com.example.websocket.controller.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//@Configuration
//@EnableWebSocket
//public class WebSocketConfig2 implements WebSocketConfigurer {
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(myHandler(), "/ws").setAllowedOrigins("*");
//    }
//
//    @Bean
//    public WebSocketHandler myHandler() {
//        return new MyHandler();
//    }
//}
