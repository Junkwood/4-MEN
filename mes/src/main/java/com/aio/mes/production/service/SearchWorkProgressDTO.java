package com.aio.mes.production.service;

import lombok.Data;

@Data
public class SearchWorkProgressDTO {
	private String select1Val; // ALL | PS1 | PS2 | PS3
	private String select2Val; // ALL | planName | workName | prodName | procName
	private String selectInputVal;
	private String registStartDate;
	private String registEndDate;
	private String manuBeginStartDate;
	private String manuBeginEndDate;
	private String manuCloseStartDate;
	private String manuCloseEndDate;
}
