package com.aio.mes.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.facility.mapper.FacilityMapper;
import com.aio.mes.facility.service.FacilityService;
import com.aio.mes.facility.service.FacilityVO;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    FacilityMapper facilityMapper;
    
    
    @Override
    public List<FacilityVO> searchUser() {
    	
    	return facilityMapper.searchUser();
    }
    @Override
    public List<FacilityVO> searchRank() {
    	
    	return facilityMapper.searchRank();
    }
    @Override
    public List<FacilityVO> noOperReason() {
    	return facilityMapper.noOperReason();
    }
    @Override
    public List<FacilityVO> status() {
    	return facilityMapper.status();
    }
    @Override
    public List<FacilityVO> employeeDisplay(FacilityVO facilityVO) {
    	return facilityMapper.employeeDisplay(facilityVO);
    }
    public List<FacilityVO> facilityDisplay(FacilityVO facilityVO) {
    	return facilityMapper.facilityDisplay(facilityVO);
    }
    @Override
    public List<FacilityVO> noReasonList() {
    	return facilityMapper.noReasonList();
    }
    
    @Transactional
    @Override
    public int noStart(List<FacilityVO> facilityVO) {
    	int result = 0;
    	for(FacilityVO facilityVOs : facilityVO) {
    		result += facilityMapper.statusUpdate(facilityVOs);
    		result += facilityMapper.noStart(facilityVOs);   	 
    	}
    	return result;
    }
    @Transactional
    @Override
    public int noEnd(FacilityVO facilityVO) {
    	int result = 0;
    	  result += facilityMapper.noEnd(facilityVO);
    	  result += facilityMapper.endStatus(facilityVO);
    	return result;
    }
    @Override
    public List<FacilityVO> noReasonDetailList(FacilityVO facilityVO) {
    	return facilityMapper.noReasonDetailList(facilityVO);
    }
}
