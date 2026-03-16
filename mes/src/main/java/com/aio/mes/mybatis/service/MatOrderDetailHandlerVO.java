package com.aio.mes.mybatis.service;

import java.util.Date;


import lombok.Data;

@Data
public class MatOrderDetailHandlerVO {
	private String matOrderDetailCode;
	private String matOrderCode;
	private String matCode;
	private String matName;
	private String matClass; //분류
	private String standard; //규격
	private String unit; //단위
	private String clientName;//업체명
	private int quantity; //발주한 수량
	private Date deliveryDate; //납기일자
}
