package com.aio.mes.manager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aio.mes.manager.service.ProcService;
import com.aio.mes.manager.service.ProcVO;

@Controller
public class ProcController {
	   
	
	   @Autowired
	   ProcService procService;
	
	// ============ 공정관리 ============ 
	   @GetMapping("procManager")
	   public String procList(Model model) {
		   List<ProcVO> procList = procService.procList();
		   model.addAttribute("procList" , procList);
		   return "web/manager/procManager";
	   }
	   
	   
	   
	   @GetMapping("/procGetSearchList")
	   @ResponseBody
	   public List<ProcVO> procGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
		   ProcVO procVO = new ProcVO();
		   procVO.setType(type);
		   procVO.setKeyword(keyword);
	       return procService.procGetSearchList(procVO);
	   }
	   
	   @PostMapping("insertProc")
	   @ResponseBody
	   public String insertProc(@RequestBody List<ProcVO> procs) {
	       int result = procService.insertProc(procs);
	       
	       if (result > 0) {
	    	   
	    	   return "등록완료";
	       }
	       return "fail";
	   }
	   
	   @PostMapping("updateProc")
	   @ResponseBody
	   public String updateClient(@RequestBody List<ProcVO> procs) {
	       int result = procService.updateProc(procs);
	       
	       if (result > 0) {
	    	   return "수정완료";
	       }
	       return "fail";
	   }
	   
	   
	   @PostMapping("deleteProc")
	   @ResponseBody
	   public String deleteClient(@RequestBody List<ProcVO> procs) {
	       int result = procService.deleteProc(procs);
	       
	       if (result > 0) {
	    	   return "삭제완료";
	       }
	       return "fail";
	   }
}
