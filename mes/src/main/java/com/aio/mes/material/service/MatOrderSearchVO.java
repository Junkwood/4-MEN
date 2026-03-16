package com.aio.mes.material.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOrderSearchVO {
	private String matOrderCode;
	private String orderName;
	private String empCode;
	private String empName;
	private String matCode;
	private String matName;
	private String clientName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private int quantity;
	private int prodQuantity;
	private String orderStatus;
}
