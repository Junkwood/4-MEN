package com.aio.mes.dispatch.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DispatchVO {
   private String prodReleaseCode;
   private String orderCode;
   private String orderName;
   private String orderDetailCode;
   private String lot;
   private String empCode;
   private String empName;
   private int releaseQuantity;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date releaseDate;
   private String releaseDate1;
   private String releaseDate2;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date registrationDate;
   private String registrationDate1;
   private String registrationDate2;
   private String entMemberCode;
   private String prodCode;
   private String prodName;
   private int send;
   private int noSend;
   private int orderQuantity;
   private String clientCode;
   private String clientName;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date dueDate;
   private int inventory;
   private String processStatus;
}
