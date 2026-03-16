package com.aio.mes.manager.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ManagerVO {
	
	
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
	
	
	
	//설비관리 테이블 정보
	private String facCode;
	private String facName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manufactureDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date installDate;
	private int inspectCycle;
	private String facStatus;
	private String image;
	private String upload_path;
	
	//제품관리 테이블 정보
	private String prodName;
	//검색필터
	private String type;
	private String keyword; //검색내용
	
	//검사기준관리
	private String testCode;
	private String testName;
	private String testItem;
	private String testItemUnit;
    private int procNum;
   
   
    private String procCode;
	private String procName;
	private String facClassCode;
	private String procClassCode;
	
	//주코드 ,부코드
	private String mainCode;
	private String subCode;
	private String subCodeName;
	
	
	
    private String imageUrl;
    private String uploadPath;
    private String dataCheck;
    
    
    
    private String fileName;
    private String fileLocation;
    private int fileSize;
    private String fileExt;
    private String downloadLocation;
    private int facId;
    
    private Date dateCheck;
}
