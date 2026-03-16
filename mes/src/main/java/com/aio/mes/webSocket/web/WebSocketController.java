package com.aio.mes.webSocket.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aio.mes.security.service.LoginUserVO;
import com.aio.mes.webSocket.Message;
import com.aio.mes.webSocket.service.ChatService;

@Controller
public class WebSocketController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat")
    public String chat() {
        return "web/chat";  // chat.html 파일의 경로 (src/main/resources/templates/web/chat.html)
    }

    @GetMapping("/chat/user")
    @ResponseBody
    public Map<String, String> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUserVO loggedInUser = (LoginUserVO) authentication.getPrincipal();
        String empCode = loggedInUser.getEmpCode();
        String empName = chatService.getEmpName(empCode);
        
        Map<String, String> response = new HashMap<>();
        response.put("empCode", empCode);
        response.put("empName", empName);
        return response;
    }

    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<Map<String, Object>> getChatRooms() {
        return chatService.getChatRooms();
    }

    @GetMapping("/api/messages")
    @ResponseBody
    public List<Message> getMessages(@RequestParam String roomId) {
        if (roomId == null || roomId.isEmpty()) {
            System.err.println("채팅방 파라미터 x : ");  // 디버깅용 로그 추가
            throw new IllegalArgumentException("채팅방이 필요합니다");
        }
        return chatService.getMessagesByRoomId(roomId);
    }

    @GetMapping("/api/empname")
    @ResponseBody
    public String getEmpName(@RequestParam String empCode) {
        return chatService.getEmpName(empCode);
    }
    
    @DeleteMapping("/api/messages")
    @ResponseBody
    public Map<String, String> deleteMessages(@RequestParam String roomId) {
        chatService.deleteMessagesByRoomId(roomId);
        Map<String, String> response = new HashMap<>();
        response.put("status", "성공");
        response.put("message", "메시지 삭제 성공");
        return response;
    }
    
    
}
