package com.aio.mes.flow.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.flow.service.FlowService;
import com.aio.mes.flow.service.FlowVO;
/**
 * 주문관리 
 * @author 신현욱
 * 2024-05-26 
 */
@RestController
public class FlowController {
  
	@Autowired
    FlowService flowService;
	
	@GetMapping("/flow/prodName")
	public List<FlowVO> searchProdName(String prodName){
		return flowService.flowProdSearch(prodName);
	}
	@GetMapping("/flow/prodFlowSearch")
	public List<FlowVO> searchProdFlow(String prodCode){
		return flowService.flowSearch(prodCode);
	}
	@GetMapping("/flow/procSearch")
	public List<FlowVO> procSearch(FlowVO flowVO){
		System.err.println(flowVO.getProcClassCode());
		return flowService.procSearch(flowVO);
	}
	@PostMapping("/flowAdd")
	public String addModfiy(@RequestBody FlowParameter flowParam) {
		int result = flowService.flowAdd(flowParam);
		
		if(result >0) {
			return "success";
		}else {
			return "fail";
		}
	}
}
