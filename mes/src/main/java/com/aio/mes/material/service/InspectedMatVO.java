package com.aio.mes.material.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InspectedMatVO {
	private String matOrderCode;
	private String orderName;
	private String matOrderDetailCode;
	private String matCode;
	private String matName;
	private String clientName;
	private String matInspectCode;
	private int inspectQuantity;
	private int errorQuantity;
	private String note;
	private String empCode;
	private String empName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inspectDate;
	
	private String matClass;
	private int quantity;
	private int prevQuantity;
}
