package com.aio.mes.finished.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FinishedVO {
	private String lot;
	private String workInstructDetailCode;
	private String prodCode;
	private int storeQuantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date storeDate;
	private String empCode;
	private String empName;
	private String entMemberCode;
	private String prodCdoe;
	private String prodName;
	private int prodQuantity;
	private int beforeQuantity;
	
}
