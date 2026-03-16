package com.aio.mes.facility.mapper;

import java.util.List;

import com.aio.mes.facility.service.FacilityVO;

public interface FacilityMapper {
      //유저 리스트 
	  public List<FacilityVO> searchUser();
      //직급 리스트
	  public List<FacilityVO> searchRank();
      //사유 리스트
	  public List<FacilityVO> noOperReason();
      //상태 리스트
	  public List<FacilityVO> status();
      //사원정보 전달
	  public List<FacilityVO> employeeDisplay(FacilityVO facilityVO);
      //기게 전달
	  public List<FacilityVO> facilityDisplay(FacilityVO facilityVO);
      
	  public List<FacilityVO> noReasonList();
      public int noStart(FacilityVO facilityVO);
      public int statusUpdate(FacilityVO facilityVO);
      public int noEnd(FacilityVO facilityVO);
      public int endStatus(FacilityVO facilityVO);
      //비가동조회
      public List<FacilityVO> noReasonDetailList(FacilityVO facilityVO);
}
