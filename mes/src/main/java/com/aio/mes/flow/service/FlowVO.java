package com.aio.mes.flow.service;

import lombok.Data;

@Data
public class FlowVO {
  private String unit;
  private String prodCode;
  private String prodName;
  private String procFlowCode;
  private String procCode;
  private int procNum;
  private String procName;
  private String note;
  private String procClassCode;
  private String facClassName;
  private String procClassName; 
}
