package com.aio.mes.flow.service;

import lombok.Data;

@Data
public class ModifyFlowVO {
  private String procFlowCode;
  private String procCode;
  private int procNum;
  private String procName;
  private String note;
}
