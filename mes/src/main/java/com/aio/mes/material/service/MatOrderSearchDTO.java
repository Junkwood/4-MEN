package com.aio.mes.material.service;

import lombok.Data;

@Data
public class MatOrderSearchDTO {
	private String select1Val; // ALL | PS1 | PS2 | PS3
	private String select2Val; // ALL | orderName | empName | matName | clientName
	private String selectInputVal;
	private String orderStartDate;
	private String orderEndDate;
	private String deliveryStartDate;
	private String deliveryEndDate;
}
