package com.aio.mes.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.facility.mapper.FacilityRepairMapper;
import com.aio.mes.facility.service.FacilityRepairService;
import com.aio.mes.facility.service.FacilityVO;
import com.aio.mes.manager.service.SubCodeParamVO;

@Service
public class FacilityRepairServiceImpl implements FacilityRepairService{

	@Autowired
	FacilityRepairMapper repairMapper;
	
	@Override
	public List<FacilityVO> basicList(FacilityVO facilityVO) {
		return repairMapper.basicList(facilityVO);
	}
	
	@Override
	public List<FacilityVO> repairOptionList(FacilityVO facilityVO) {
		return repairMapper.repairOptionList(facilityVO);
	}
	//수리요청
	@Transactional
	@Override
	public int repairAdd(List<FacilityVO> facilityVO) {
		int result =0;
		for(FacilityVO facilityVoS : facilityVO) {
			result+=repairMapper.repairAdd(facilityVoS);
		}
		return result;
	}
	
	@Override
	public List<FacilityVO> grid2BasicList(FacilityVO facilityVO) {
		return repairMapper.grid2BasicList(facilityVO);
	}
	@Override
	@Transactional
	public int update(SubCodeParamVO<FacilityVO> subCodeParamVO) {
		int result = 0;
		List<FacilityVO> modify = subCodeParamVO.getModify();
		List<FacilityVO> drop = subCodeParamVO.getDrop();
		for(FacilityVO drops : drop) {
			result += repairMapper.grid2Delete(drops);
		}
		for(FacilityVO modifys : modify) {
			if(modifys.getNote()==null) {
				modifys.setNote("");
			}
		   result += repairMapper.grid2Status(modifys);
		   result += repairMapper.grid2NoOper(modifys);
		   result += repairMapper.grid2Add(modifys);
		}
		return result;
	}
}
