package com.aio.mes.finished.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.dispatch.service.DispatchVO;
import com.aio.mes.finished.service.FinishedService;
import com.aio.mes.finished.service.FinishedVO;
/**
 * 주문관리 
 * @author 신현욱
 * 2024-05-22 
 */
@RestController
public class FinishedRestController {
   
	@Autowired
	FinishedService finishedService;
	
	//입고가능재고 조회
	@GetMapping("/finishedList")
	public List<FinishedVO> finishedList(FinishedVO finishedVO){
		List<FinishedVO> list = finishedService.storePossible(finishedVO);
		return list;
	}
	@GetMapping("/alreadyFinished")
	public List<FinishedVO> ListAlreadyFinished(String lot, String prodName) {
		List<FinishedVO> list = finishedService.alreadyFinished(lot, prodName);
		return list;
	}
	@GetMapping("/modifyCheck")
	 public int modifyCheck (String workInstructDetailCode, String prodCode) {
	    return finishedService.modifyCheck(workInstructDetailCode, prodCode);
	}
	//등록
	@PostMapping("/addFinished")
	 public String addFinished(@RequestBody List<FinishedVO> finishedVO) {
		int result = finishedService.addFinished(finishedVO);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	@PostMapping("/updateFinished")
	 public String modifyFinished(@RequestBody List<FinishedVO> finishedVO) {
	   int result = 0;
	try {
		result = finishedService.updateFinished(finishedVO);
	} catch (SQLException e) {
		result=-1;
	}
	   if(result>0) {
		   return "success";
	   }else if(result==-2) {
		   return "same";
	   }else {
		   return "fail";
	   }
	}
	@DeleteMapping("/deleteFinished")
	public String delete(@RequestBody List<FinishedVO> dispatchVO) {
		int result=finishedService.deleteFinished(dispatchVO);
	    if(result>0) {
	    	return "success";
	    }else {
	    	return "fail";
	    }
	}
	@GetMapping("/finishedDetailList")
	public List<FinishedVO> finishedDetailList(FinishedVO finishedVO) {
		return finishedService.finishedList(finishedVO);
	}
   
}
