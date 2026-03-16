package com.aio.mes.webSocket;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatRoom {
	private String roomId;
    private String roomName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
