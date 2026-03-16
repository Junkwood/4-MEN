package com.aio.mes.manager.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aio.mes.business.service.BusinessDetailVO;
import com.aio.mes.manager.service.InspectService;
import com.aio.mes.manager.service.InspectVO;
import com.aio.mes.manager.service.ManagerService;
import com.aio.mes.manager.service.ManagerVO;
import com.aio.mes.manager.service.SearchVO;

@Controller
@RequestMapping("/test/")
public class InspectController {

	@Autowired
	InspectService inspectService;
	
	@Autowired
	ManagerService managerSerivce;
	
	
	// ========================= 검사처리관리 =====================
	@GetMapping("inspectManager") // 페이지 띄우기
	public String inspectPage(Model model) {
		return "test/inspectManager";
	}

	@GetMapping("inspectList")
	@ResponseBody
	public List<InspectVO> inspectList(@RequestParam(required = true, defaultValue = "ent001") String entMemberCode,
			@RequestParam(required = false) String workInstructDetailCode) {

		return inspectService.inspectList(entMemberCode, workInstructDetailCode);
	}

	@GetMapping("inspectListInfo")
	@ResponseBody
	public List<InspectVO> inspectListInfo(@RequestParam String workProgressCode) {
		return inspectService.inspectListInfo(workProgressCode);
	}
	
	@PutMapping("inspect")
	@ResponseBody
	public String updateInspect(@RequestBody List<InspectVO> inspects) {
	    int updatedCount = inspectService.updateInspect(inspects);
	    return "Updated " + updatedCount + " records successfully.";
	}

	@GetMapping("getTestProc")
	@ResponseBody
	public String getTestProc(@RequestParam String workInstructDetailCode, @RequestParam String prodName) {
		return inspectService.getTestProc(workInstructDetailCode, prodName);
	}

	@PutMapping("updateQuantity")
	@ResponseBody
	public String updateQuantity(@RequestBody Map<String, Object> requestData) {
		try {
			String workProgressCode = (String) requestData.get("workProgressCode");
			int prodQuantity = (int) requestData.get("prodQuantity");
			int inputQuantity = (int) requestData.get("inputQuantity");
			int errorQuantity = (int) requestData.get("errorQuantity");
			int instructQuantity = (int) requestData.get("instructQuantity");

			int updatedRows = inspectService.updateQuantity(workProgressCode, prodQuantity, inputQuantity,
					errorQuantity, instructQuantity);

			if (updatedRows > 0) {
				return "{\"message\":\"업데이트 성공:  " + updatedRows + "\"}";
			} else {
				return "{\"error\":\"업데이트 실패: .\"}";
			}
		} catch (Exception e) {
			return "{\"error\":\"서버 오류: " + e.getMessage() + "\"}";
		}
	}

	@PutMapping("updateStatus")
	@ResponseBody
	public String updateStatus(@RequestBody List<InspectVO> inspects) {
		int result = inspectService.updateStatus(inspects);
		System.out.println("result : " + result );
		System.out.println("inspects " + inspects);
		return result > 0 ? "수정완료" : "fail";
	}

	@GetMapping("workProgressListAjax")
	@ResponseBody
	public List<InspectVO> showWorkProgressListAjax() {
		return inspectService.showWorkProgressList();
	}

	@PostMapping("workProgressListAjax")
	@ResponseBody
	public List<InspectVO> searchWorkProgressListAjax(SearchVO SearchVO) {
		return inspectService.searchWorkProgressList(SearchVO);
	}

	@GetMapping("getNextProcess")
	@ResponseBody
	public InspectVO getNextProc(@RequestParam String workInstructDetailCode, @RequestParam int currentProcNum) {
		System.out.println("getNextProcess - workInstructDetailCode : " + workInstructDetailCode);
		System.out.println("currentProcNum - currentProcNum :" + currentProcNum);
		return inspectService.getNextProc(workInstructDetailCode, currentProcNum);
	}

	@PutMapping("updateNextProc")
	@ResponseBody
	public String updateNextProc(@RequestBody Map<String, Object> requestData) {

		try {
			String workInstructDetailCode = (String) requestData.get("workInstructDetailCode");
			int prodQuantity = (int) requestData.get("prodQuantity");
			int procNum = (int) requestData.get("procNum");
			int updatedRows = inspectService.updateNextProc(workInstructDetailCode, prodQuantity, procNum);

			if (updatedRows > 0) {
				return "{\"message\":\"업데이트 성공:  " + updatedRows + "\"}";
			} else {
				return "{\"error\":\"업데이트 실패: .\"}";
			}
		} catch (Exception e) {
			return "{\"error\":\"서버 오류: " + e.getMessage() + "\"}";
		}

	}


	@PutMapping("updateProgress")
	@ResponseBody
	public Map<String, Object> updateProgress(@RequestBody Map<String, Object> request) {
		Map<String, Object> response = new HashMap<>();
		try {
			String workInstructDetailCode = (String) request.get("workInstructDetailCode");
			String workProgressCode = (String) request.get("workProgressCode");
			int procNum = (int) request.get("procNum");
			System.out.println("workProgressCode : " + workProgressCode);
			boolean canUpdate = inspectService.checkProgress(workInstructDetailCode, workProgressCode,
					procNum);
			if (canUpdate) {
				response.put("status", "성공");
				response.put("message", "해당 공정의 처리가 완료되었습니다.");
			} else {
				response.put("status", "실패");
				response.put("message", "이전 공정의 상태가 완료되지 않았습니다.");
			}
		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", "실패");
		}
		return response;
	}
	// ========================= 검사흐름도관리 =====================
	@GetMapping("testFlowManager") 
	public String inspectFlowPage(Model model) {
		return "test/testFlowManager";
	}
	
	@GetMapping("testFlowProd")
	@ResponseBody
	public List<InspectVO> testFlowProd() {
		return inspectService.testFlowProd();
	}
	
	@GetMapping("testFlowProc")
	@ResponseBody
	public List<InspectVO> testFlowProc(){
		return inspectService.testFlowProc();
	}
	
	@GetMapping("testFlowList")
	@ResponseBody
	public List<InspectVO> testFlowList(@RequestParam String procCode){
		return inspectService.testFlowList(procCode);
	}
	
	@GetMapping("testModalData")
	@ResponseBody
	public List<InspectVO> testModalData(){
		return inspectService.testModalData();
	}
	
	
	 @PostMapping("testFlow")
	   @ResponseBody
	   public String insertTestFlow(@RequestBody List<InspectVO> testFlows) {
	       int result = inspectService.insertTestFlow(testFlows);
	       
	       if (result > 0) {
	    	   
	    	   return "등록완료";
	       }
	       return "fail";
	   }
	   
	   @PutMapping("testFlow")
	   @ResponseBody
	   public String updateTestFlow(@RequestBody List<InspectVO> testFlows) {
	       int result = inspectService.updateTestFlow(testFlows);
	       
	       if (result > 0) {
	    	   return "수정완료";
	       }
	       return "fail";
	   }
	   
	   
	   @DeleteMapping("testFlow")
	   @ResponseBody
	   public String deleteTestFlow(@RequestBody List<InspectVO> testFlows) {
	       int result = inspectService.deleteTestFlow(testFlows);
	       
	       if (result > 0) {
	    	   return "삭제완료";
	       }
	       return "fail";
	   }
	   
	   
	   
	   // ========================= 검사기준관리 =====================
	   //검사기준
	   @GetMapping("testManager")
	   public String testList(Model model , String entMemberCode) {
	       List<ManagerVO> testList = managerSerivce.testList(entMemberCode);
	       model.addAttribute("testList", testList);
	       return "test/testManager";
	   }
	   
	   @PostMapping("test")
	   @ResponseBody
	   public String insertTest(@RequestBody List<ManagerVO> tests) {
	       int result = managerSerivce.insertTest(tests);
	       
	       if (result > 0) {
	    	   
	    	   return "등록완료";
	       }
	       return "fail";
	   }
	   
	   
	   
	   @PutMapping("test")
	   @ResponseBody
	   public String updateTest(@RequestBody List<ManagerVO> tests) {
	       int result = managerSerivce.updateTest(tests);
	       return result > 0 ? "수정완료" : "fail";
	   }

	   @DeleteMapping("test")
	   @ResponseBody
	   public String deleteTest(@RequestBody List<ManagerVO> tests) {
	       int result = managerSerivce.deleteTest(tests);
	       return result > 0 ? "삭제완료" : "fail";
	   }


	   @GetMapping("testGetSearchList")
	   @ResponseBody
	   public List<ManagerVO> testGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
	       ManagerVO managerVO = new ManagerVO();
	       managerVO.setType(type);
	       managerVO.setKeyword(keyword);
	       return managerSerivce.testGetSearchList(managerVO);
	   }
	   
	   @GetMapping("procOptionList")
	   @ResponseBody
	   public List<ManagerVO> procOptionList() {
	       return inspectService.procOptionList();
	   }
	   
	   @GetMapping("testList")
		public String orderList() {
			return "test/testList";
		}
	   
	   
	   @GetMapping("inspectDetailList1")
		public String inspectList1() {
			return "test/testList";
		}
	   
	   @GetMapping("inspectDetailList2")
		public List<InspectVO> inspectDetailList(InspectVO inspectVO){
			return inspectService.inspectDetailList(inspectVO);
		}
	   
	   @GetMapping("searchProcList")
	   @ResponseBody
	   public List<InspectVO> searchProcList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
		   InspectVO inspectVO = new InspectVO();
		   inspectVO.setType(type);
		   inspectVO.setKeyword(keyword);
	       return inspectService.searchProcList(inspectVO);
	   }
}

