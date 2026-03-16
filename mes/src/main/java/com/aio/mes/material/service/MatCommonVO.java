package com.aio.mes.material.service;

import lombok.Data;

@Data
public class MatCommonVO {
	private String matCode;
	private String matClass;
	private String matName;
	private String standard;
	private String unit;
	private int safetystock;
	private String entMemberCode;
}
