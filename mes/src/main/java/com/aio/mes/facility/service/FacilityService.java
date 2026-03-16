package com.aio.mes.facility.service;

import java.util.List;

public interface FacilityService {
	public List<FacilityVO> searchUser();
	public List<FacilityVO> searchRank();
	public List<FacilityVO> noOperReason();
    public List<FacilityVO> status();
    public List<FacilityVO> employeeDisplay(FacilityVO facilityVO);
    public List<FacilityVO> facilityDisplay(FacilityVO facilityVO);
    public List<FacilityVO> noReasonList();
    public int noStart(List<FacilityVO> facilityVO);
    public int noEnd(FacilityVO facilityVO);
    //비가동조회
    public List<FacilityVO> noReasonDetailList(FacilityVO facilityVO);
}
