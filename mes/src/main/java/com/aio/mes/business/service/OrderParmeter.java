package com.aio.mes.business.service;

import java.util.List;

import lombok.Data;

@Data
public class OrderParmeter {
  private List<BusinessVO> order; 
  private List<BusinessDetailVO> orderDetail;
  private List<BusinessDetailModifyVO> orderModify;
  private List<BusinessDetailDeleteVO> orderDelete;
  
}
