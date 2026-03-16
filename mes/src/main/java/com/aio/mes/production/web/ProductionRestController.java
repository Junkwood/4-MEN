package com.aio.mes.production.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

/**
 * 작업지시관리
 * @author 서정우
 * 2024-05-22
 */
@RestController
@Slf4j
public class ProductionRestController {
   @Autowired
   ProductionService productionService;
   
   @Autowired
   ProductionMapper productionMapper;
   
   //작업지시목록 검색하기.
   @GetMapping("work")
   public List<WorkInstructVO> searchWork( @RequestParam(required = false, defaultValue = "") String search,
										   @RequestParam(required = false, defaultValue = "") String keyword) {
	   log.info(search+keyword);
	   List<WorkInstructVO> list = productionService.searchWork(search,keyword);
	   return list;
   }
   //작업지시 상세를 불러오기
   @GetMapping("workDetail")
   public List<WorkInstructVO> workDetailList(@RequestParam(required = true, defaultValue = "") String workInstructCode) {
	   List<WorkInstructVO> list = productionService.workDetailList(workInstructCode);
	   return list;
   }
   //작업지시 상세전체목록 불러오기
   @GetMapping("workInstructDetailList")
   public List<WorkInstructVO> workInstruct(
		   									@RequestParam(required = true, defaultValue = "") String search1,
		   									@RequestParam(required = true, defaultValue = "") String keyword1,
		   									@RequestParam(required = true, defaultValue = "") String search2,
		   									@RequestParam(required = true, defaultValue = "") String keyword2,
		   									@RequestParam(required = true, defaultValue = "") String startDate1,
		   									@RequestParam(required = true, defaultValue = "") String endDate1,
		   									@RequestParam(required = true, defaultValue = "") String startDate2,
		   									@RequestParam(required = true, defaultValue = "") String endDate2
		   									) {
	   List<WorkInstructVO> list = productionService.workInstruct(search1, keyword1,search2,keyword2,startDate1,endDate1,startDate2,endDate2);
	   return list;
   }
   //자재목록불러오기
   @GetMapping("/matLists")
   public List<WorkInstructVO> matList(@RequestParam(required = true, defaultValue = "") String prodCode,
		   								@RequestParam(required = true, defaultValue = "")String workInstructDetailCode) {
	   List<WorkInstructVO> list = productionService.matList(prodCode, workInstructDetailCode);
	   return list;
	   
   }
   //로트별 자재목록 불러오기
   @GetMapping("lot")
   public List<WorkInstructVO> lotList(@RequestParam(required = true, defaultValue = "") String matCode,
		                               @RequestParam(required = true, defaultValue = "") String workInstructDetailCode) {
	   List<WorkInstructVO> list = productionService.lotList(matCode, workInstructDetailCode);
	   return list;
	   
   }
   //제품목록 불러오기
   @GetMapping("prod")
   public List<WorkInstructVO> prodList() {
	   List<WorkInstructVO> list = productionService.prodList();
	   return list;
   }
   //공정목록 불러오기
   @GetMapping("proc")
   public List<WorkProgressVO> procList() {
	   List<WorkProgressVO> list = productionService.procList();
	   return list;
   }
   //설비목록 불러오기
   @GetMapping("fac")
   public List<WorkProgressVO> facList(@RequestParam(required = true, defaultValue = "") String workProgressCode) {
	   List<WorkProgressVO> list = productionService.facList(workProgressCode);
	   return list;
   }
   //사원목록 불러오기
   @GetMapping("emp")
   public List<WorkProgressVO> empList() {
	   List<WorkProgressVO> list = productionService.empList();
	   return list;
   }
   //사원의 진행중인 실적 갯수 불러오기
   @GetMapping("perfCnt")
   public Integer perfCnt(@RequestParam(required = true, defaultValue = "") String empCode) {
	   log.info(empCode);
	   return productionService.getPerfCnt(empCode);
   }
   //작업지시목록 검색하기.
   @GetMapping("singlePerf")
   public List<WorkProgressVO> getSinglePerf(@RequestParam(required = true, defaultValue = "") String empCode) {
	   log.info(empCode);
	   List<WorkProgressVO> list = productionService.getSinglePerf(empCode);
	   return list;
   }
   //작업지시상세 등록
   @PostMapping("WorkDetail")
   public String insertWorkDetail(@RequestBody List<workObject> workList) {
	   
		log.info(workList.toString());
		String workInstructCode = productionService.insertWorkDetailList(workList);
		log.info(workInstructCode);
		return workInstructCode;
   }
   //작업지시 상세 삭제
   @DeleteMapping("WorkDetail")
   public String deleteWorkDetail(@RequestBody List<workObject> workList) {

	   log.info(workList.toString());

	   return productionService.deleteWorkDetailList(workList);
   }
   //작업지시 상세 수정
   @PutMapping("WorkDetail")
      public void updateWorkDetail(@RequestBody List<workObject> workList) {
	   
	   log.info(workList.toString());
	   
	   productionMapper.updateWorkDetailList(workList);
   }
   //자재홀드 등록
   @PostMapping("MatHold")
   public void insertMatHold(@RequestBody List<workObject> workList) {
	   log.info(workList.toString());
	   
	   productionMapper.insertMatHold(workList);
   }

   //실적 조회
   @GetMapping("perfData/{perfCode}")
   public List<PerfDataVO> searchPerfData(@PathVariable String perfCode) {
	   return productionService.searchPerfData(perfCode);
   }
   
   //실적 저장
   @PostMapping("savePerf")
   public String savePerfData(String perfCode, String prodQuantity, String errorQuantity) {
	   return productionService.savePerfData(perfCode, prodQuantity, errorQuantity);
   }
   //작업 종료
   @PutMapping("savePerf/{perfCode}")
   public String endPerfData(@PathVariable String perfCode) {
	   System.out.println("실적코드 : " + perfCode);
	   return productionService.endPerfData(perfCode);
   }
   //작업진행 검색하기.
   @GetMapping("searchworkProgress")
   public List<WorkProgressVO> searchWorkProgress(@RequestParam(required = false, defaultValue = "") String prodCode,
										   @RequestParam(required = false, defaultValue = "") String procCode,
										   @RequestParam(required = false, defaultValue = "") String workProgressCode) {
	   log.info(prodCode+procCode);
	   List<WorkProgressVO> list = productionService.searchWorkProgress(prodCode,procCode,workProgressCode);
	   return list;
   }
   
   //새로운 작업 진행 정보 사전 정보
   @GetMapping("newPerf")
   public Map<String, Object> searchNewPerfInfo(String empCode, String facCode, String workProgressCode){
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("empName", productionService.getEmpName(empCode));
	   map.put("facName", productionService.getFacName(facCode));
	   map.put("procName", productionService.getProcName(workProgressCode));
	   map.put("prodName", productionService.getProdName(workProgressCode));
	   
	   return map;
   }
   
   //새로운 작업 진행 정보 등록
   @PostMapping("newPerf")
   public Map<String, Object> addNewPerfData(String empCode, String facCode, String workProgressCode, int inputQuantity){
	   return productionService.insertNewPerfData(empCode, facCode, workProgressCode, inputQuantity);
   }
        //생산계획 검색하기.
   @GetMapping("manuPlan")
   public List<ManufactureVO> getManuPlan(@RequestParam(required = false, defaultValue = "") String search,
										   @RequestParam(required = false, defaultValue = "") String keyword) {
	   log.info(search+keyword);
	   List<ManufactureVO> list = productionService.getManuPlan(search,keyword);
	   return list;
   }
   //생산계획 검색하기.
   @GetMapping("manuPlanDetail")
   public List<ManufactureVO> getmanuPlanDetail(@RequestParam(required = true, defaultValue = "") String manuPlanCode) {
	   log.info(manuPlanCode);
	   List<ManufactureVO> list = productionService.getManuPlanDetail(manuPlanCode);
	   return list;
   }
   //생산계획상세 등록
   @PostMapping("manuPlanDetail")
   public void insertManuPlanDetail(@RequestBody List<ManuPlanVO> mList) {
	   
		log.info(mList.toString());
		productionMapper.insertPlanDetailList(mList);
   }
   //생산계획상세 삭제
   @DeleteMapping("manuPlanDetail")
   public int deleteManuPlandetail(@RequestParam(required = true, defaultValue = "") String manuPlanDetailCode) {
	   log.info(manuPlanDetailCode);
	   
	   return productionService.deletePlanDetail(manuPlanDetailCode);
   }
   //생산계획상세 삭제
   @PostMapping("deleteManuPlan")
   public String deleteManuPlan(@RequestParam(required = true, defaultValue = "") String manuPlanCode) {
	   log.info(manuPlanCode);
	   productionService.deleteManuPlan(manuPlanCode);
	   return productionService.deleteManuPlan(manuPlanCode);
   }
   //작업지시 상세 수정
   @PostMapping("updateManuPlan")
   public String updateManuPlan(@RequestBody List<ManuPlanVO> planList) {
	   String result = productionService.updateManuPlan(planList);
	   log.info(result);
	   return productionService.updateManuPlan(planList);
   }
  //공정진행현황 조회
   @GetMapping("searchWorkProgressAjax")
   public List<SearchWorkProgressVO> searchWorkProgress(SearchWorkProgressDTO DTO){
	   return productionService.searchWorkProgressList(DTO);
   }
  //자재입고목록 불러오기
   @GetMapping("getMatStore")
   public List<matSearchVO> getMatStore(
		   @RequestParam(required = true, defaultValue = "") String search1,
		   @RequestParam(required = true, defaultValue = "") String keyword1,
		   @RequestParam(required = true, defaultValue = "") String search2,
		   @RequestParam(required = true, defaultValue = "") String keyword2,
		   @RequestParam(required = true, defaultValue = "") String startDate1,
		   @RequestParam(required = true, defaultValue = "") String endDate1,
		   @RequestParam(required = true, defaultValue = "") String startDate2,
		   @RequestParam(required = true, defaultValue = "") String endDate2
		   ) {
	   List<matSearchVO> list = productionService.getMatStore(search1, keyword1,search2,keyword2,startDate1,endDate1,startDate2,endDate2);
	   return list;
   }
   //자재입고목록 불러오기
   @GetMapping("getMatHold")
   public List<matSearchVO> getMatHold(
		   @RequestParam(required = true, defaultValue = "") String search1,
		   @RequestParam(required = true, defaultValue = "") String keyword1,
		   @RequestParam(required = true, defaultValue = "") String search2,
		   @RequestParam(required = true, defaultValue = "") String keyword2
		   ) {
	   List<matSearchVO> list = productionService.getMatHold(search1, keyword1,search2,keyword2);
	   return list;
   }
   //자재입고목록 불러오기
   @GetMapping("getMatRelease")
   public List<matSearchVO> getMatRelease(
		   @RequestParam(required = true, defaultValue = "") String search1,
		   @RequestParam(required = true, defaultValue = "") String keyword1,
			@RequestParam(required = true, defaultValue = "") String startDate1,
			@RequestParam(required = true, defaultValue = "") String endDate1
		   ) {
	   List<matSearchVO> list = productionService.getMatRelease(search1, keyword1,startDate1,endDate1);
	   return list;
   }
   @GetMapping("getMatStock")
   public List<matSearchVO> getMatStock() {
	   List<matSearchVO> list = productionService.getMatStock();
	   return list;
   }
}
	