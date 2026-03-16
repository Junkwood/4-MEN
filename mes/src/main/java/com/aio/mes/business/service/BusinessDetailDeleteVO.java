package com.aio.mes.business.service;

import lombok.Data;

@Data
public class BusinessDetailDeleteVO {
	 private String orderDetailCode;
	 private String orderCode;
	 private String prodCode;
	 private String prodName;
	 private String orderQuantity;
	 private String entMemberCode;
	 private String orderPrice;
}
