package com.aio.mes.production.service;

import java.util.Date;

import lombok.Data;

@Data
public class PerfDataVO {
	private String perfCode; //실적코드
	private int inputQuantity; //투입량
	private int errorQuantity; //불량량
	private int prodQuantity; //생산량
	private Date workStartDate;
	private Date workEndDate;
	private String facCode; //설비코드
	private String facName; //설비명
	private String empCode; //작업자코드
	private String empName; //작업자명
	
	private String workProgressCode; //작업 진행코드
	private String procCode; //공정코드
	private String procName; //공정명
	private String workInstructDetailCode;//작업 지시 상세코드
	private String prodCode; //제품코드
	private String prodName; //제품명
}
