package com.aio.mes.mybatis.service;

import lombok.Data;

@Data
public class InspMatoHandlerVO {
	private String matOrderCode;
	private String matCode;
	private String matOrderDetailCode;
	private int inspectQuantity;
	private int errorQuantity;
	private String note;
	private String empCode;
	private String empName;
}
