package com.aio.mes.business.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class orderSimpleVO {
  private String orderCode;
  private String orderName;
  private String clientCode;
  private String clientName;
  private String prodName;
  private String status;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date registrationDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dueDate;
}
