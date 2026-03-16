package com.aio.mes.production.service;

import java.sql.Date;

import lombok.Data;

@Data
public class WorkProgressVO {
	private String workName;//작업지시명
	private Integer procNum;//공정순서
	private String prodName;//제품명
	private String procName;//제품명
	private String registrationDate;//등록일자
	private Date manuStartDate;//생산시작일자
	private Date manuEndDate;//생산종료일자
	private Integer instructQuantity;//지시량
	private Integer inputQuantity;//투입량
	private Integer errorQuantity;//불량량
	private Integer prodQuantity;//생산량
	private String progress;//진행여부
	private String workProgressCode;//작업진행코드
	private String procCode;//곻정코드
	private String prodCode;//제품코드
	private String workInstructDetailcode;//작업지시상세코드
	private String entMemberCode;//기업코드
	private String facCode;//설비코드
	private String facName;//설비이름
	private String facStatus;//설비상태
	private String empName;//작업자명
	private String empCode;//작업자사번
	private String deptId;//부서명
	private String sub_code_name;//부코드명
	private String sub_code;//부코드
	private String workStartDate;//
	private String perfCode;//
	private String unit;
}
