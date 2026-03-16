package com.aio.mes.business.service;

import lombok.Data;

@Data
public class ClientVO {
	private String clientCode;
	private String clientName;
	private String clientType;
	private String tel;
	private String address;
	private String clientManager;
	private String entMemberCode;
}
