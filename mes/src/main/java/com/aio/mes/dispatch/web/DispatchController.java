package com.aio.mes.dispatch.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.dispatch.service.DispatchSearchVO;
import com.aio.mes.dispatch.service.DispatchService;
import com.aio.mes.dispatch.service.DispatchVO;

@RestController
public class DispatchController {
  
	@Autowired
	DispatchService dispatchService;
	
	//간단 출고조회
	@GetMapping("/simpleDispatch")
	public List<DispatchVO> simple(DispatchSearchVO dispatchSearchVO){
		List<DispatchVO> list = dispatchService.simpleDispatchList(dispatchSearchVO);
		return list;
	}
	@GetMapping("/dispatchCall")
	public List<DispatchVO> call(@RequestParam(required = false, defaultValue = "") String entMemberCode,
			                     @RequestParam String orderCode){
		List<DispatchVO> list = dispatchService.dispatchCall(entMemberCode, orderCode);
		return list;
	}
	@GetMapping("/dispatchModifyCall")
	public List<DispatchVO> modifyCall(@RequestParam(required = false, defaultValue = "") String entMemberCode,
			                     @RequestParam String prodReleaseCode){
		List<DispatchVO> list = dispatchService.dispatchModifyCall(entMemberCode, prodReleaseCode);
		return list;
	}
	@GetMapping("/dispatchReady")
	public List<DispatchVO> ready(@RequestParam(required = false, defaultValue = "") String entMemberCode,
                                  @RequestParam String prodCode){
		List<DispatchVO> list = dispatchService.dispatchReady(entMemberCode, prodCode);
		return list;
	}
	@PostMapping("/dispatchAdd")
	public String addDispatch(@RequestBody List<DispatchVO> dispatch) {
	     int result = 0;
		try {
			result = dispatchService.dispatchAdd(dispatch);
		} catch (SQLException e) {
			result = -1;
		}
	     if(result >0) {
	    	 return "success";
	     }else {
	    	 return "fail";
	     }
	}
	@PostMapping("/dispatchModify")
	public String modifyDispatch(@RequestBody List<DispatchVO> dispatchVO) {
		int result = 0;
		try {
			result = dispatchService.dispatchModify(dispatchVO);
		} catch (SQLException e) {
			result = -1;
		}
		if(result >0) {
			return "success";
		}else {
			return "fail";
		}
	}
	@PostMapping("/dispatchRemove")
	public String removeDispatch(@RequestBody List<DispatchVO> dispatchVO) {
		int result = dispatchService.dispatchRemove(dispatchVO);
		if(result>0) {
			return "success";
		}else{
			return "fail";
		}
	}
	@GetMapping("/dispatchList")
	public List<DispatchVO> dispatchList(DispatchVO dispatchVO) {
		return dispatchService.dispatchList(dispatchVO);
	}
	
	
}
