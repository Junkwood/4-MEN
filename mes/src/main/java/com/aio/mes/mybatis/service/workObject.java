package com.aio.mes.mybatis.service;

import java.sql.Date;

import lombok.Data;

@Data
public class workObject {
	private String workInstructCode;//작업지시코드
	private String manuPlanCode;//생산계획코드
	private String workName;//작업지시명
	private String empCode;//작업지시자사번
	private Date registrationDate;//등록일자
	private Date manuStartDate;//생산시작일자
	private Date manuEndDate;//생산종료일자
	private String workInstructDetailCode;//작업지시상세코드
	private String prodCode;//제품코드
	private Integer instructQuantity;//지시량
	private Integer priority;//우선순위
	private String processStatus;//처리상태
	private Integer holdQuantity;//홀드수량
	private String progress;//완료여부
	private String lot;//자재로트
	private String manuPlanDetailCode;//생산계획상세코드

}
