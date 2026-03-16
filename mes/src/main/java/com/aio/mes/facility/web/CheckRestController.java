package com.aio.mes.facility.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.facility.service.FacilityCheckService;
import com.aio.mes.facility.service.FacilityVO;
import com.aio.mes.manager.service.EmpVO;
import com.aio.mes.manager.service.SubCodeParamVO;

@RestController
@RequestMapping("/facility")
public class CheckRestController {
   
	
	@Autowired
	FacilityCheckService checkService;
	
	@GetMapping("/checkList")
	public List<FacilityVO> checkList(FacilityVO facilityVO){
		return checkService.checkList(facilityVO);
	}
	@GetMapping("/optionList")
	public List<FacilityVO> optionList(){
		return checkService.optionList();
	}
	@PostMapping("/checkAdd")
	public String add(@RequestBody List<FacilityVO> facilityVO) {
		int result = checkService.add(facilityVO);
		
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	@GetMapping("/process")
	public List<FacilityVO> process(FacilityVO facilityVO) {
		   return checkService.checkProcess(facilityVO);
	}
	@PostMapping("/processResult")
	public int add(@RequestBody SubCodeParamVO<FacilityVO> facilityVO) {
		int result = checkService.update(facilityVO);
		return result;
	}
}
