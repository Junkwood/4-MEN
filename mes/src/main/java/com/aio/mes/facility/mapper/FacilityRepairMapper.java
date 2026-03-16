package com.aio.mes.facility.mapper;

import java.util.List;

import com.aio.mes.facility.service.FacilityVO;

public interface FacilityRepairMapper {
       
	public List<FacilityVO> basicList(FacilityVO facilityVO);
	
	public List<FacilityVO> repairOptionList(FacilityVO facilityVO);

	public int repairAdd(FacilityVO facilityVO);
	
	public List<FacilityVO> grid2BasicList(FacilityVO facilityVO);

	public int grid2Add(FacilityVO facilityVO);
	
	public int grid2Status(FacilityVO facilityVO);
	
	public int grid2NoOper(FacilityVO facilityVO);
	
	public int grid2Delete(FacilityVO facilityVO);
}
