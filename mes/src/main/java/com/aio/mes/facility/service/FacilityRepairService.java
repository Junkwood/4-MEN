package com.aio.mes.facility.service;

import java.util.List;

import com.aio.mes.manager.service.SubCodeParamVO;

public interface FacilityRepairService {
	
	public List<FacilityVO> basicList(FacilityVO facilityVO);
	
	public List<FacilityVO> repairOptionList(FacilityVO facilityVO);

	public int repairAdd(List<FacilityVO> facilityVO);
	
	public List<FacilityVO> grid2BasicList(FacilityVO facilityVO);

	public int update(SubCodeParamVO<FacilityVO> subCodeParamVO);

	
}
