package com.aio.mes.material.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatOrderVO {
	private String matOrderCode;
	private String orderName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private String empCode;
	private String empName;
	private String orderStatus;
}
