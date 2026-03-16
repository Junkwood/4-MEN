package com.aio.mes.material.service;

import lombok.Data;

@Data
public class NeedSupplyMatVO {
	private String matCode;
	private String matName;
	private int safetystock;
	private int safetyStockPerQuantity;
	private int manuPlanPerQuantity;
}
