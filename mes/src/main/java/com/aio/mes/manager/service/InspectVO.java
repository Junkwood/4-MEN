package com.aio.mes.manager.service;

import java.sql.Date;

import lombok.Data;

@Data
public class InspectVO {
	
	//검사
	private String testProcessCode;
	private Date testDate;
	private String testFlowCode;
	private String empName;
	private String empCode;
	private String workInstructDetailCode;
	private String workInstructCode;
	private String procCode;
	private String procName;
	private String prodName;
	private String workName;
	private int testQuantity;
	private String passCriteria;
	private int totalInspected;
	private String unit;
	private String note;
	private String workProgressCode;
	private String entMemberCode;
	private String testItem;
	private int instructQuantity;
	private Date registration_date;
	private int errorQuantity;
	private int inputQuantity;
	private int prodQuantity;
	private int passQuantity;
	private String testName;
	private int procNum;
	private String procClassCode;
	private int testNum;
	private String testCode;
	private String prodCode;
	private String facClassCode;
	private String testItemUnit;
	private String progress;
	private String status;
	//검색필터
	private String type;
	private String keyword;
    
}



