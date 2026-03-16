package com.aio.mes.production.service;

import java.util.List;
import java.util.Map;

import com.aio.mes.mybatis.service.ManuPlanVO;
import com.aio.mes.mybatis.service.workObject;

public interface ProductionService {

	public List<WorkInstructVO> workDetailList(  String workInstructCode);
	public List<WorkInstructVO> matList(  String prodCode, String workInstructDetailCode);
	public List<WorkInstructVO> prodList( );
	public List<WorkInstructVO> searchWork(String search, String keyword  );
	public List<WorkInstructVO> lotList(  String matCode, String workInstructDetailCode);
	public List<WorkProgressVO> searchWorkProgress(String prodCode, String procCode,   String workProgressCode);
	public List<WorkProgressVO> procList( );
	public List<WorkProgressVO> facList(  String workProgressCode);
	public List<WorkProgressVO> empList( );
	public Integer getPerfCnt(String empCode);
	public List<WorkProgressVO> getSinglePerf(String empCode);

	//공정 진행
	public List<PerfDataVO> searchPerfData(String perfCode);
	public String savePerfData(String perfCode, String prodQuantity, String errorQuantity);
	public String endPerfData(String perfCode);
	public String getEmpName(String empCode);
	public String getFacName(String facCode);
	public String getProdName(String workProgressCode);
	public String getProcName(String workProgressCode);
	public Map<String, Object> insertNewPerfData(String empCode, String facCode, String workProgressCode, int inputQuantity);
  
	//생산계획
	public List<ManufactureVO> getManuPlan(String search, String keyword  );
	public List<ManufactureVO> getManuPlanDetail(String manuPlanCode);
	public int deletePlanDetail(String manuPlanDetailCode);
	public String updateManuPlan(List<ManuPlanVO> planList);
	public String deleteManuPlan(String manuPlanCode);
	public String deleteWorkDetailList(List<workObject> workList);
	public List<WorkInstructVO> workInstruct(String search1, String keyword1, String search2, String keyword2, String startDate1, String endDate1, String startDate2, String endDate2);
	public String insertWorkDetailList(List<workObject> workList);
	public List<matSearchVO> getMatStore(String search1, String keyword1, String search2, String keyword2,String startDate1, String endDate1, String startDate2, String endDate2);
	public List<matSearchVO> getMatHold(String search1, String keyword1, String search2, String keyword2);
	public List<matSearchVO> getMatRelease(String search1, String keyword1, String startDate1, String endDate1);
	public List<matSearchVO> getMatStock();
  
  //공정진행현황 조회 페이지
	public List<SearchWorkProgressVO> searchWorkProgressList(SearchWorkProgressDTO DTO);
}
