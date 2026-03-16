package com.aio.mes.webSocket.service;

import java.util.List;
import java.util.Map;

import com.aio.mes.webSocket.Message;

public interface ChatService {
    
    // 메시지 저장
    void saveMessage(String roomId, String empCode, String message);
    
    // 메시지 가져오기
    List<Message> getMessagesByRoomId(String roomId);
    
    // 방 목록 가져오기
    List<Map<String, Object>> getChatRooms();
    
    // 사용자 정보 가져오기
    Map<String, Object> getUser(String empId);
    
    // 사용자 이름 가져오기
    String getEmpName(String empCode);
    
    //Message getLatestMessage(String roomId, String empCode, String message);
    
    void deleteMessagesByRoomId(String roomId);
}
