package com.aio.mes.facility.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aio.mes.facility.service.FacilityService;
import com.aio.mes.facility.service.FacilityVO;

@Controller
public class FacilityController {
   @Autowired
   FacilityService facilityService;
   
   
   //비가동처리 키오스크
   @GetMapping("/prod/noOperation") 
   public String machineNoForm(Model model) { 
	   List<FacilityVO> user = facilityService.searchUser();
	   List<FacilityVO> rank = facilityService.searchRank();
	   List<FacilityVO> noReason = facilityService.noOperReason();
	   List<FacilityVO> status = facilityService.status();
	   model.addAttribute("user",user);
	   model.addAttribute("rank",rank);
	   model.addAttribute("noReason",noReason);
	   model.addAttribute("status",status);
	   
	   return"facility/noOperation"; 
	   
   }
	@GetMapping("/facility/check")
	public String facilityCheck() {
		return "facility/check";
	}
	
	@GetMapping("/facility/repair")
	public String rapairForm() {
		return "facility/repair";
	}
	@GetMapping("/facility/noList")
	public String noList() {
	    return "facility/noList";	
	}
	
}
