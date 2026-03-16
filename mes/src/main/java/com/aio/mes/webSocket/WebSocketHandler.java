package com.aio.mes.webSocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.aio.mes.webSocket.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ChatService chatService; 

    private List<WebSocketSession> sessions = new ArrayList<>(); // WebSocket 세션을 저장할 리스트
    private ObjectMapper objectMapper = new ObjectMapper(); // JSON 처리를 위한 ObjectMapper

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 클라이언트와의 연결이 설정된 후 호출되는 메서드
        sessions.add(session); // 세션 리스트에 추가
        System.out.println("Connected: " + session.getId()); // 연결된 세션의 ID 출력
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 클라이언트와의 연결이 종료된 후 호출되는 메서드
        sessions.remove(session); // 세션 리스트에서 제거
        System.out.println("Disconnected: " + session.getId()); // 연결이 종료된 세션의 ID 출력
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 텍스트 메시지를 수신했을 때 호출되는 메서드
        String payload = message.getPayload(); // 메시지의 페이로드를 문자열로 받음
        Message chatMessage = parsePayload(payload); // 페이로드를 Message 객체로 변환

        if (chatMessage == null) {
            // 메시지 형식이 올바르지 않을 경우
            System.err.println("메시지 존재 x: " + payload);
            return; // 메서드 종료
        }

        if (chatMessage.getEmpCode() == null || chatMessage.getRoomId() == null || chatMessage.getMessage() == null) {
            // 메시지의 필수 필드가 누락된 경우
            System.err.println("미완성 메시지 : " + chatMessage);
            return; 
        }

        // empCode를 기반으로 empName을 조회하여 메시지에 설정
        if (chatMessage.getEmpName() == null) {
            String empName = chatService.getEmpName(chatMessage.getEmpCode()); // empName 조회
            chatMessage.setEmpName(empName); // empName 설정
        }

        System.out.println("Received message: " + chatMessage); // 수신한 메시지 출력

        // 메시지 저장
        chatService.saveMessage(chatMessage.getRoomId(), chatMessage.getEmpCode(), chatMessage.getMessage());

        // 모든 클라이언트에 메시지 전송
        for (WebSocketSession wsSession : sessions) {
            if (wsSession.isOpen()) {
                wsSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(chatMessage))); // 메시지 전송
            }
        }
    }

    private Message parsePayload(String payload) {
        // 전송데이터를 Message 객체로 변환하는 메서드
        try {
            return objectMapper.readValue(payload, Message.class); // 페이로드를 Message 객체로 변환
        } catch (Exception e) {
            e.printStackTrace(); // 오류 출력
            return null;  // 변환 실패 시 null 반환
        }
    }
}
