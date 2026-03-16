package com.aio.mes.mybatis.service;

import java.sql.Date;

import lombok.Data;

@Data
public class ManuPlanVO {
	private String manuPlanCode;//생산계획코드
	private String orderCode;//주문코드
	private String planName;//계획명
	private String empCode;//사원코드
	private Date registrationDate;//등록일
	private Date startDate;//시작일
	private Date endDate;//종료일
	private String note;//비고
	//여기서부터 생산계획상세 필드
	private String manuPlanDetailCode;//생산계획 상세 코드
	private String prodCode;//제품코드
	private Integer planQuantity;//계획량
	private Integer priority;//우선순위
	private String processStatus;//진행상태.	
	private String orderDetailCode;//주문상세코드
}
