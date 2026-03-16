package com.aio.mes.production.service;

import java.sql.Date;

import lombok.Data;

@Data
public class matSearchVO {
	private String workInstructCode;//작업지시코드
	private String workInstructDetailCode;//작업지시상세코드
	private String matInspectCode;//자재검수코드
	private String matHoldCode;//자재홀드코드
	private String matReleaseCode;//자재홀드코드
	private String workName;//작업지시명
	private String registrationDate;//등록일자
	private Date storeDate;//입고일
	private Date inspectDate;//검수일
	private Date releaseDate;//출고일
	private String empName;//사원명
	private String empCode;//사번
	private String rank;//직급
	private String deptId;//부서	
	private String prodName;//제품명
	private String unit;//단위
	private String prodCode;//제품코드
	private String matName;//자재명
	private String matCode;//자재코드
	private String lot;//자재로트
	private Integer stock;//홀드가능수량=재고
	private Integer holdQuantity;//홀드수량
	private Integer storeQuantity;//입고수량
	private Integer releaseQuantity;//출고수량
	private String status;//상태
	private String progress;//완료여부
	private String safetystock;//안전재고
	private String prodLot;
	private String matLot;
}
