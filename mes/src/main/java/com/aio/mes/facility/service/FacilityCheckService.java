package com.aio.mes.facility.service;

import java.util.List;

import com.aio.mes.manager.service.SubCodeParamVO;

public interface FacilityCheckService {
	 public List<FacilityVO> checkList(FacilityVO facilityVO);

	 public List<FacilityVO> optionList();
   
	 public int add(List<FacilityVO> facilityVO);
	 
	 public List<FacilityVO> checkProcess(FacilityVO facilityVO);
	 
	 public int update(SubCodeParamVO<FacilityVO> subCodeParamVO);
     
}
