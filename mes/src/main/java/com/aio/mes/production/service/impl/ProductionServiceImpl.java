package com.aio.mes.production.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aio.mes.mybatis.service.ManuPlanVO;
import com.aio.mes.mybatis.service.workObject;
import com.aio.mes.production.mapper.ProductionMapper;
import com.aio.mes.production.service.ManufactureVO;
import com.aio.mes.production.service.PerfDataVO;
import com.aio.mes.production.service.ProductionService;
import com.aio.mes.production.service.SearchWorkProgressDTO;
import com.aio.mes.production.service.SearchWorkProgressVO;
import com.aio.mes.production.service.WorkInstructVO;
import com.aio.mes.production.service.WorkProgressVO;
import com.aio.mes.production.service.matSearchVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    ProductionMapper productionMapper;

	@Override
	public List<WorkInstructVO> workDetailList(String workInstructCode) {
		return productionMapper.getWorkDetailList(workInstructCode);
	}

	@Override
	public List<WorkInstructVO> matList(String prodCode, String workInstructDetailCode) {
		return productionMapper.getMatList(prodCode, workInstructDetailCode);
	}

	@Override
	public List<WorkInstructVO> lotList(String matCode ,String workInstructDetailCode) {
		return productionMapper.getLotList(matCode, workInstructDetailCode);
	}

	@Override
	public List<WorkInstructVO> prodList() {
		return productionMapper.getProdList();
	}

	@Override
	public List<WorkInstructVO> searchWork(String search, String keyword) {
		return productionMapper.searchWork(search,keyword);
	}

	@Override
	public List<PerfDataVO> searchPerfData(String perfCode) {
		return productionMapper.searchPerfData(perfCode);
	}

	@Override
	public List<WorkProgressVO> procList() {
		return productionMapper.getProcList();
	}

	@Override
	public List<WorkProgressVO> searchWorkProgress(String prodCode, String procCode, String workProgressCode) {
		return productionMapper.searchWorkProgress(prodCode,procCode,workProgressCode);
	}

	@Override
	public List<WorkProgressVO> facList(String workProgressCode) {
		return productionMapper.getFacList(workProgressCode);
	}

	@Override
	public List<WorkProgressVO> empList() {
		return productionMapper.getEmpList();
	}

	@Override
	public Integer getPerfCnt(String empCode) {
		log.info(empCode);
		return productionMapper.getPerfCnt(empCode);
	}

	@Override
	public List<WorkProgressVO> getSinglePerf(String empCode) {
		return productionMapper.getSinglePerf(empCode);
	}

	@Override
	public String savePerfData(String perfCode, String prodQuantity, String errorQuantity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_input_perf_code", perfCode);
		map.put("p_input_prod_quantity", prodQuantity);
		map.put("p_input_error_quantity", errorQuantity);
		map.put("p_output_msg", "");
		
		productionMapper.savePerfData(map);
		
		return (String)map.get("output_msg");
	}
	
	//생산계획
	@Override
	public List<ManufactureVO> getManuPlan(String search, String keyword) {
		
		return productionMapper.getManuPlan(search, keyword);
	}

	@Override
	public List<ManufactureVO> getManuPlanDetail(String manuPlanCode) {
		return productionMapper.getManuDetail(manuPlanCode);
	}

	@Override
	public String endPerfData(String perfCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_input_perf_code", perfCode);
		map.put("p_output_msg", "");
		
		productionMapper.endPerfData(map);
		
		return (String)map.get("output_msg");
	}

	@Override
	public String getEmpName(String empCode) {
		return productionMapper.getEmpName(empCode);
	}

	@Override
	public String getFacName(String facCode) {
		return productionMapper.getFacName(facCode);
	}

	@Override
	public String getProdName(String workProgressCode) {
		return productionMapper.getProdName(workProgressCode);
	}

	@Override
	public String getProcName(String workProgressCode) {
		return productionMapper.getProcName(workProgressCode);
	}

	@Override
	public Map<String, Object> insertNewPerfData(String empCode, String facCode, String workProgressCode, int inputQuantity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_emp_code", empCode);
		map.put("p_fac_code", facCode);
		map.put("p_work_progress_code", workProgressCode);
		map.put("p_input_quantity", inputQuantity);
		map.put("p_output_perf_code", "");
		map.put("p_output_msg", "");
		
		productionMapper.insertNewPerfData(map);
		return map;
	}

	@Override
	public int deletePlanDetail(String manuPlanDetailCode) {
		return productionMapper.deleteManuPlanDetail(manuPlanDetailCode);
	}

	@Override
	public String updateManuPlan(List<ManuPlanVO> planList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_output_msg", "");
		map.put("pList", planList);
		productionMapper.updateManuPlan(map);
		return (String)map.get("p_output_msg");
	}

	@Override
	public String deleteManuPlan(String manuPlanCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_output_msg", "");
		map.put("p_manu_plan_code", manuPlanCode);
		productionMapper.deleteManuPlan(map);
		return (String)map.get("p_output_msg");
	}
	//작업지시 상세삭제
	@Override
	public String deleteWorkDetailList(List<workObject> workList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_output_msg", "");
		map.put("wList", workList);
		productionMapper.deleteWorkDetailList(map);
		return (String)map.get("p_output_msg");
	}


	//작업지시 상세 등록
	@Override
	public String insertWorkDetailList(List<workObject> workList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_work_instruct_code", "");
		map.put("wList", workList);
		productionMapper.insertWorkDetailList(map);
		return (String)map.get("p_work_instruct_code");
	}

	@Override
	public List<WorkInstructVO> workInstruct(String search1, String keyword1, String search2, String keyword2,
			String startDate1, String endDate1, String startDate2, String endDate2) {
		
		return productionMapper.workInstructDetailList(search1,keyword1,search2,keyword2,startDate1,endDate1,startDate2,endDate2);
	}

	@Override
	public List<matSearchVO> getMatStore(String search1, String keyword1, String search2, String keyword2,
			String startDate1, String endDate1, String startDate2, String endDate2) {
		return productionMapper.getMatStore(search1,keyword1,search2,keyword2,startDate1,endDate1,startDate2,endDate2);
	}

	@Override
	public List<SearchWorkProgressVO> searchWorkProgressList(SearchWorkProgressDTO DTO) {
		return productionMapper.searchWorkProgressList(DTO);
  }
  
	public List<matSearchVO> getMatHold(String search1, String keyword1, String search2, String keyword2) {
		return productionMapper.getMatHold(search1,keyword1,search2,keyword2);
	}

	@Override
	public List<matSearchVO> getMatRelease(String search1, String keyword1, String startDate1, String endDate1) {
		return productionMapper.getMatRelease(search1,keyword1,startDate1,endDate1);
	}

	@Override
	public List<matSearchVO> getMatStock() {
		return productionMapper.getMatStock();
	}

}