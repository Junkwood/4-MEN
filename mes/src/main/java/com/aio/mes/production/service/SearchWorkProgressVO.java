package com.aio.mes.production.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchWorkProgressVO {
	private String planName;
	private String workName;
	private String empName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manuStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manuEndDate;
	private String prodName;
	private int instructQuantity; //작업지시 상세의 지시량
	private String processStatus;
	private int procNum;
	private String procName;
	private int instructQuantityWp; //공정 진행 현황 테이블의 지시량
	private int inputQuantity;
	private int errorQuantity;
	private int prodQuantity;
	private String progress;
}
