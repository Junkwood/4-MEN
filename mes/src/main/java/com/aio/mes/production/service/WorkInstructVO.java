package com.aio.mes.production.service;

import java.sql.Date;

import lombok.Data;

@Data
public class WorkInstructVO {
	private String workInstructCode;//작업지시코드
	private String workInstructDetailCode;//작업지시상세코드
	private String workName;//작업지시명
	private String planName;//생산계획명
	private String registrationDate;//등록일자
	private Date startDate;//생산시작일자
	private Date endDate;//생산종료일자
	private Date manuStartDate;//생산시작일자
	private Date manuEndDate;//생산종료일자
	private String empName;//작업지시자이름
	private String empCode;//작업지시자사번
	private String prodName;//제품명
	private Integer priority;//우선순위
	private Integer instructQuantity;//지시량
	private String processStatus;//처리상태
	private String manuPlanCode;//생산계획코드
	private String note;//비고
	private String unit;//단위
	private String prodCode;//제품코드
	private String entMemberCode;//기업코드
	private String matName;//자재명
	private Integer requireAmount;//요구량
	private String bomCode;//BOM코드
	private String lot;//자재로트
	private String matCode;//자재코드
	private Integer stock;//홀드가능수량=재고
	private Integer holdQuantity;//홀드수량
	private Integer useAmount;//bom 사용량
	private String status;//상태
	private String progress;//완료여부
	private String keyword;//검색키워드
	private String search;//검색조건
	private String orderName;//주문명
}
