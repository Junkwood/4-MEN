package com.aio.mes.webSocket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aio.mes.webSocket.Message;

public interface ChatMapper {
    
    // 메시지 삽입
    void insertMessage(@Param("messageId") String messageId, @Param("roomId") String roomId, @Param("empCode") String empCode, @Param("message") String message);
    
    // 메시지 가져오기
    List<Message> selectMessagesByRoomId(@Param("roomId") String roomId);
    
    // 방 목록 가져오기
    List<Map<String, Object>> getChatRooms();
    
    // 사용자 정보 가져오기
    Map<String, Object> getUser(@Param("empId") String empId);

    // 사용자 이름 가져오기
    String getEmpName(@Param("empCode") String empCode);

	Message selectLatestMessage(String roomId, String empCode, String message);
	
	void deleteMessagesByRoomId(@Param("roomId") String roomId);
}
