package com.aio.mes.business.service;



import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BusinessVO {
	private String orderCode;
	private String clientCode;
	private String orderName;
	private String clientName;
	private String empCode;
	private String empName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	private String note;
	private String entMemberCode;
	private String prodCode;
	private String orderQuantity;
	private String processStatus;
	private String prodName;
}
