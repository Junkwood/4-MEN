package com.aio.mes.webSocket;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Message {
	private String messageId;
    private String roomId;
    private String empCode;
    private String message;
    private Timestamp createdAt;
    private String empName;
}
