package com.aio.mes.mybatis.service;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MatOrderHandlerVO {
	private String matOrderCode;
	private String orderName;
	private Date orderDate;
	private String empCode;
	private String empName;
	private String orderStatus;
}
