package com.aio.mes.facility.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.facility.service.FacilityRepairService;
import com.aio.mes.facility.service.FacilityVO;
import com.aio.mes.manager.service.SubCodeParamVO;

@RestController
@RequestMapping("/facility")
public class RepairRestController {
   
	
	@Autowired
	FacilityRepairService repairService;
	
	@GetMapping("/basicList")
	public List<FacilityVO> basicList(FacilityVO facilityVO){
		return repairService.basicList(facilityVO);
	}
	@GetMapping("/repairOptionList")
	public List<FacilityVO> optionList(FacilityVO facilityVO){
		return repairService.repairOptionList(facilityVO);
	}
	@PostMapping("/repairRequest")
	public String request(@RequestBody List <FacilityVO> facilityVO) {
	   int result = repairService.repairAdd(facilityVO);
	   if(result>0){
		  return "success";   
	   }else {
		   return "fail";
	   }
	}
  
	@GetMapping("/repProccessDisplay")
	public List<FacilityVO> grid2BasicList(FacilityVO facilityVO){
		return repairService.grid2BasicList(facilityVO);
	}
	
	@PostMapping("/repairResult")
	public int add(@RequestBody SubCodeParamVO<FacilityVO> facilityVO) {
	  int result = repairService.update(facilityVO);
	  return result;
	}

	
}
