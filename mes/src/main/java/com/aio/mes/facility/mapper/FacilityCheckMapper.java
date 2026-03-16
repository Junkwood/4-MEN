package com.aio.mes.facility.mapper;

import java.util.List;

import com.aio.mes.facility.service.FacilityVO;

public interface FacilityCheckMapper {
	  public List<FacilityVO> checkList(FacilityVO facilityVO);
      
	  public List<FacilityVO> optionList();
	  
	  public int checkAdd(FacilityVO facilityVO);
	  
	  public List<FacilityVO> checkProcess(FacilityVO facilityVO);

	  public int checkUpdate(FacilityVO facilityVO);
	  public int checkStatus1(FacilityVO facilityVO);
	  public int checkStatus2(FacilityVO facilityVO);
	  public int checkDelete(FacilityVO facilityVO);
	  public int successResult(FacilityVO facilityVO);
	  public int failResult(FacilityVO facilityVO);
}
