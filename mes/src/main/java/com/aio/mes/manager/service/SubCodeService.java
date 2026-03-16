package com.aio.mes.manager.service;

import java.util.List;

public interface SubCodeService {
	
	   public List<SubCodeVO> mainCodeDisplay();
	    
	   public List<SubCodeVO> subCodeDisplay(String mainCode);
	    
	   public int add(SubCodeParamVO<SubCodeVO> subCodeParamVO);

}