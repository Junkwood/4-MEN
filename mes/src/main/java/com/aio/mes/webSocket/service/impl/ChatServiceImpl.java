package com.aio.mes.webSocket.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aio.mes.webSocket.Message;
import com.aio.mes.webSocket.mapper.ChatMapper;
import com.aio.mes.webSocket.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper; // ChatMapper 주입

    @Override
    public void saveMessage(String roomId, String empCode, String message) {
        // 메시지를 저장하는 메서드
        
    	if (roomId == null) {
            // roomId가 null
            System.err.println("방번호 is null"); // 오류 메시지 출력
            return; 
        }

        if (message == null) {
            // 메시지가 null
            System.err.println("메시지 is null"); // 오류 메시지 출력
            return; 
        }

        System.out.println("saveMessage called with roomId: " + roomId + ", empCode: " + empCode + ", message: " + message); // 저장할 메시지 정보 출력

        String messageId = java.util.UUID.randomUUID().toString(); // 메시지 ID를 UUID로 생성
        chatMapper.insertMessage(messageId, roomId, empCode, message); // 메시지를 DB에 삽입
    }

    @Override
    public List<Message> getMessagesByRoomId(String roomId) {
        return chatMapper.selectMessagesByRoomId(roomId); // 채팅방 ID로 메시지 목록 조회
    }

    @Override
    public List<Map<String, Object>> getChatRooms() {
        // 모든 채팅방 목록을 가져오는 메서드
        List<Map<String, Object>> chatRooms = chatMapper.getChatRooms(); // 채팅방 목록 조회
        chatRooms.forEach(room -> {
            // 각 채팅방 정보를 출력
            System.out.println("Room: " + room.get("roomId") + " - " + room.get("roomName")); // 채팅방 ID와 이름 출력
        });
        return chatRooms; // 채팅방 목록 반환
    }

    @Override
    public Map<String, Object> getUser(String empId) {
        // 특정 사용자 정보를 가져오는 메서드
        return chatMapper.getUser(empId); // 사용자 ID로 사용자 정보 조회
    }

    @Override
    public String getEmpName(String empCode) {
        // 특정 직원의 이름을 가져오는 메서드
        return chatMapper.getEmpName(empCode); // 직원 코드로 직원 이름 조회
    }
    
    @Override
    public void deleteMessagesByRoomId(String roomId) {
        chatMapper.deleteMessagesByRoomId(roomId);
    }
}
