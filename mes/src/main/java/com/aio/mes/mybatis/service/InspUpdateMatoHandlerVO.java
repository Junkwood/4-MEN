package com.aio.mes.mybatis.service;

import lombok.Data;

@Data
public class InspUpdateMatoHandlerVO {
	private String matInspectCode;
	private int inspectQuantity;
	private int errorQuantity;
	private String note;
	private String empCode;
	private String empName;
}
