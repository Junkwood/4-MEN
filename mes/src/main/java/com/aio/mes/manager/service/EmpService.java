package com.aio.mes.manager.service;

import java.util.List;

public interface EmpService {
	public List<EmpVO> empList(EmpVO empVO);
	
	 public int add(SubCodeParamVO<EmpVO> subCodeParamVO);
}
