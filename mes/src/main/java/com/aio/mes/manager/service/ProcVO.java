package com.aio.mes.manager.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProcVO {
	
	
	//bom 테이블 정보
	private String bomCode;
	private String matCode;
	private int useAmount;
	private String note;
	private String prodCode;
	private String entMemberCode;
	
	//자재종류관리 테이블 정보
	private String matClass;
	private String matName;
	private String standard;
	private String unit;
	private String safetystock;
	
	//거래처관리 테이블 정보
	private String clientCode;
	private String clientName;
	private String clientType;
	private String tel;
	private String address;
	private String clientManager;
	
	//공정관리 테이블 정보
	private String procCode;
	private String procName;
	private String facClassCode;
	private String procClassCode;
	
	//설비관리 테이블 정보
	private String facCode;
	private String facName;
	private String manufactureDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date installDate;
	private String inspectCycle;
	private String facStatus;
	private String image;
	private String upload_path;
	
	//제품관리 테이블 정보
	private String prodName;
	
	//검색필터
	private String type;
	private String keyword; //검색내용
}
