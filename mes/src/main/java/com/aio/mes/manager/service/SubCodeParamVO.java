package com.aio.mes.manager.service;

import java.util.List;

import lombok.Data;

@Data
public class SubCodeParamVO<T> {
   
	private List<T> add;
	
	private List<T> modify;
	
	private List<T> drop;
}
