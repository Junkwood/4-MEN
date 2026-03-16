package com.aio.mes.production.mapper;

import java.util.List;
import java.util.Map;

import com.aio.mes.mybatis.service.ManuPlanVO;
import com.aio.mes.mybatis.service.workObject;
import com.aio.mes.production.service.ManufactureVO;
import com.aio.mes.production.service.PerfDataVO;
import com.aio.mes.production.service.SearchWorkProgressDTO;
import com.aio.mes.production.service.SearchWorkProgressVO;
import com.aio.mes.production.service.WorkInstructVO;
import com.aio.mes.production.service.WorkProgressVO;
import com.aio.mes.production.service.matSearchVO;

public interface ProductionMapper {

	public List<WorkInstructVO> getWorkDetailList(  String workInstructCode);
	public List<WorkInstructVO> getMatList(  String prodCode, String workInstructDetailCode);
	public List<WorkInstructVO> getLotList(  String matCode, String workInstructDetailCode);
	public List<WorkInstructVO> getProdList( );
	public List<WorkInstructVO> searchWork(String search, String keyword);
	// 작업지시 상세 Insert
	public void insertWorkDetailList(Map<String, Object> map);
	public void deleteWorkDetailList(Map<String, Object> map);
	public void updateWorkDetailList(List<workObject> wList);
	public void insertMatHold(List<workObject> wList);
  
  //공정 목록
	public List<WorkProgressVO> searchWorkProgress(  String prodCode, String procCode, String workProgressCode);
	public List<WorkProgressVO> getProcList( );
	public List<WorkProgressVO> getFacList(  String workProgressCode);
	public List<WorkProgressVO> getEmpList( );
    public Integer getPerfCnt(String empCode);
	public List<WorkProgressVO> getSinglePerf(String empCode);
  
	//공정 진행
	public List<PerfDataVO> searchPerfData(String perfCode);
	public String savePerfData(Map<String, Object> parameterMap);
	public void endPerfData(Map<String, Object> parameterMap);
	public String getEmpName(String empCode);
	public String getFacName(String facCode);
	public String getProdName(String workProgressCode);
	public String getProcName(String workProgressCode);
	public void insertNewPerfData(Map<String, Object> parameterMap);
  
	//생산계획
	public List<ManufactureVO> getManuPlan(String search, String keyword);
	public List<ManufactureVO> getManuDetail(String manuPlanCode);
	public List<ManuPlanVO> insertPlanDetailList(List<ManuPlanVO> mList);
	public int deleteManuPlanDetail(String manuPlanDetailCode);
	public void deleteManuPlan(Map<String, Object> map);
	public void updateManuPlan(Map<String, Object> map);
	public List<WorkInstructVO> workInstructDetailList(String search1, String keyword1, String search2, String keyword2, String startDate1, String endDate1, String startDate2, String endDate2);
	public List<matSearchVO> getMatStore(String search1, String keyword1, String search2, String keyword2,String startDate1, String endDate1, String startDate2, String endDate2);
	public List<matSearchVO> getMatHold(String search1, String keyword1, String search2, String keyword2);
	public List<matSearchVO> getMatRelease(String search1, String keyword1, String startDate1, String endDate1);
	public List<matSearchVO> getMatStock();
  
  //공정진행현황 조회 페이지
	public List<SearchWorkProgressVO> searchWorkProgressList(SearchWorkProgressDTO DTO);
}
