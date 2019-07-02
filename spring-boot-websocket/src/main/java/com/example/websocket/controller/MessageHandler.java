package com.example.websocket.controller;

import com.example.websocket.dao.MessageRepository;
import com.example.websocket.model.Message;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageHandler extends TextWebSocketHandler {
    @Autowired
    private MessageRepository messageRepository;
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Map<String, WebSocketSession> SESSIONS = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws
            Exception {
        String uid = (String) session.getAttributes().get("uid");
// 将当前用户的session放置到map中，后面会使用相应的session通信
        SESSIONS.put(uid, session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage
            textMessage) throws Exception {
        String uid = (String) session.getAttributes().get("uid");

        JsonNode jsonNode = MAPPER.readTree(textMessage.getPayload());
        int toId = jsonNode.get("toId").asInt();
//        int id = jsonNode.get("id").asInt();
        String msg = jsonNode.get("msg").asText();
        Message message = Message.builder()
                .fromId(Integer.parseInt(uid))
                .fromId(toId)
                .msg(msg)
                .build();
// 将消息保存到MongoDB
        message = this.messageRepository.save(message);
// 判断to用户是否在线
        WebSocketSession toSession = SESSIONS.get(toId);
        if (toSession != null && toSession.isOpen()) {
//TODO 具体格式需要和前端对接
            toSession.sendMessage(new
                    TextMessage(MAPPER.writeValueAsString(message)));
// 更新消息状态为已读
            this.messageRepository.updateMessageState(message.getId(), 2);
        }
    }
}