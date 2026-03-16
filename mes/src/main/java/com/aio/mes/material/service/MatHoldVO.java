package com.aio.mes.material.service;

import lombok.Data;

@Data
public class MatHoldVO {
	private String matHoldCode;
	private String lot;
	private String workInstructDetailCode;
	private int holdQuantity;
	private String progress;
}
