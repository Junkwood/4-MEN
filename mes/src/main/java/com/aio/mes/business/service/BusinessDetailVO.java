package com.aio.mes.business.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BusinessDetailVO {
  private String orderDetailCode;
  private String orderCode;
  private String orderName;
  private String prodCode;
  private String prodName;
  private String entMemberCode;
  private String orderPrice;
  private String clientName;
  private String empName;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date registrationDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dueDate;
  private String registrationDate1;
  private String dueDate1;
  private String registrationDate2;
  private String dueDate2;
  private String processStatus;
  private int orderQuantity;
  private int noSend;
  private int totalPrice;
  
  
}
