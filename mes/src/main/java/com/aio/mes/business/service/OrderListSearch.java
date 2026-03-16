package com.aio.mes.business.service;

import lombok.Data;

@Data
public class OrderListSearch {
   private String orderCode;
   private String orderName;
   private String clientName;
   private String prodName;
   private String entMemberCode;
}
