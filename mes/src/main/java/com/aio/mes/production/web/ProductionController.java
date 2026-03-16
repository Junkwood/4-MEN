package com.aio.mes.production.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aio.mes.production.service.ProductionService;

@Controller
@RequestMapping("/prod")
public class ProductionController {
   @Autowired
   ProductionService productionService;
   
   //작업지시 페이지 불러오기
   @GetMapping("/workInstruct")
   public String worInstruct(Model model) {
	   return "work/list";
   }
   //공정목록 페이지 불러오기
   @GetMapping("/workProgress")
   public String workProgress(Model model) {
	   return "work/progressList";
   }
   //공정목록 페이지 불러오기
   @GetMapping("/selectEmp")
   public String selectEmp(Model model,@RequestParam(required = true, defaultValue = "")String workProgressCode) {
       model.addAttribute("workProgressCode", workProgressCode);
	   return "work/selectEmpFac";
   }
   
   //공정 진행 페이지 불러오기
   @GetMapping("/saveProgress")
   public String saveProgress(Model model, @RequestParam(required = false, defaultValue = "")String perfCode,
		   									@RequestParam(required = false, defaultValue = "")String empCode,
		   									@RequestParam(required = false, defaultValue = "")String workProgressCode,
		   									@RequestParam(required = false, defaultValue = "")String facCode,
		   									@RequestParam(required = false, defaultValue = "")String inputQuantity
		   ) {
	   model.addAttribute("perfCode", perfCode);
	   model.addAttribute("empCode", empCode);
	   model.addAttribute("workProgressCode", workProgressCode);
	   model.addAttribute("facCode", facCode);
	   model.addAttribute("inputQuantity",inputQuantity);

	   return "work/saveProgress";
   }
   //생산계획 페이지 불러오기
   @GetMapping("/manufacturePlan")
   public String manufacturePlan(Model model) {
	   return "manufacture/planList";
   }
   //작업지시 목록 페이지 불러오기
   @GetMapping("/workInstructList")
   public String workInstruct(Model model) {
	   return "work/workList";
   }
   //공정진행현황 조회 페이지 불러오기
   @GetMapping("/searchWorkProgress")
   public String searchWorkProgress(Model model) {
	   return "work/searchworkprogress";
   }
}
