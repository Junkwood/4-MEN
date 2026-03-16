package com.aio.mes.facility.service;



import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FacilityVO {
	 private String rank;
	 private String deptId;
     private String subCode;
     private String subCodeName;
     private String empCode;
     private String empName;
     private String facCode;
     private String facName;
     private String facClassCode;
     private String facClassName;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date notStartDate;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date notEndDate;
     private String facNotReasonCode;
     private String facNotReasonName;
     private String facStatus;
     private String facStatusName;
     private String facNotCode;
     private String inspectCycle;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date processDate;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date lastProcessDate;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date registrationDate;
     private String inspClassCode;
     private String inspClassName;
     private String processDate1;
     private String processDate2;
     private String facInspCode;
     private String processHistory;
     private String processResult;
     private String note;
     private String breakdown;
     private String repClassCode;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date repProcessDate;
     private String repProcessDate1;
     private String repProcessDate2;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date repRequestDate;
     private String repRequestDate1;
     private String repRequestDate2;
     private String repNo;
     private String repHistory;
     private String notStartDate1;
     private String notStartDate2;
     private String notEndDate1;
     private String notEndDate2;
}
