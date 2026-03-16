package com.aio.mes.material.service;

import lombok.Data;

@Data
public class InspectiveMatOrderVO {
	private String matOrderCode;
	private String orderName;
	private String matCode;
	private String matClass;
	private String matName;
	private String matOrderDetailCode;
	private String clientName;
	private int quantity;
	private int prevQuantity;
}
