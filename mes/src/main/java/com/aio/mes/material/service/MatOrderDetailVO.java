package com.aio.mes.material.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatOrderDetailVO {
	private String matOrderDetailCode;
	private String matOrderCode;
	private String matCode;
	private String matName;
	private String matClass; //분류
	private String standard; //규격
	private String unit; //단위
	private String clientName;//업체명
	private int quantity; //발주한 수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate; //납기일자
	private String entMemberCode; //기업코드
}
