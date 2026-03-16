package com.aio.mes.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.facility.mapper.FacilityCheckMapper;
import com.aio.mes.facility.service.FacilityCheckService;
import com.aio.mes.facility.service.FacilityVO;
import com.aio.mes.manager.service.SubCodeParamVO;

@Service
public class FacilityCheckServiceImpl implements FacilityCheckService{

	@Autowired
	FacilityCheckMapper facilityCheck;
	
	@Override
	public List<FacilityVO> checkList(FacilityVO facilityVO) {
		List<FacilityVO> list = facilityCheck.checkList(facilityVO);
		return list;
	}
	
	@Override
	public List<FacilityVO> optionList() {
		return facilityCheck.optionList();
	}
	
	@Override
	@Transactional
	public int add(List<FacilityVO> facilityVO) {
		int result = 0;
		for(FacilityVO facilityVOs:facilityVO) {
			result+=facilityCheck.checkAdd(facilityVOs);
		}
		return result;
	}
	
	@Override
	public List<FacilityVO> checkProcess(FacilityVO facilityVO) {
		List<FacilityVO> list = facilityCheck.checkProcess(facilityVO);
		return list;
	}
	@Override
	@Transactional
	public int update(SubCodeParamVO<FacilityVO> subCodeParamVO) {
		int result = 0;
		List<FacilityVO> modify = subCodeParamVO.getModify();
		List<FacilityVO> drop = subCodeParamVO.getDrop();
		for(FacilityVO drops: drop) {
		   result +=facilityCheck.checkDelete(drops);	
		}
		for(FacilityVO modifys:modify) {
			modifys.setNote("");
			result +=facilityCheck.checkUpdate(modifys);
			if(modifys.getProcessResult().equals("GR1")) {
				result+=facilityCheck.checkStatus1(modifys);
				result+=facilityCheck.successResult(modifys);
			}else if(modifys.getProcessResult().equals("GR2")){
				result+=facilityCheck.checkStatus2(modifys);	
				result+=facilityCheck.failResult(modifys);	
			}
		}
		
		return result;
	}
}
