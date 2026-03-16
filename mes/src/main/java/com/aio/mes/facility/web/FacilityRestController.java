package com.aio.mes.facility.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.facility.service.FacilityService;
import com.aio.mes.facility.service.FacilityVO;
/**
 * 주문관리 
 * @author 신현욱
 * 2024-05-22 
 */
@RestController
public class FacilityRestController {
   @Autowired
   FacilityService facilityService;
   
   @GetMapping("/work/empDisplay")
   public List<FacilityVO> userDisplay(FacilityVO facilityVO){
	  List<FacilityVO> list = facilityService.employeeDisplay(facilityVO);
	  return list;
   }
   @GetMapping("/work/facDisplay")
   public List<FacilityVO> facDisplay(FacilityVO facilityVO){
	  List<FacilityVO> list = facilityService.facilityDisplay(facilityVO);
	  return list;
   }
   @GetMapping("/work/noReasonList")
   public List<FacilityVO> noList(){
	   List<FacilityVO> list = facilityService.noReasonList();
       return list;
   }
   @PostMapping("/work/noAdd")
   public String noAdd(@RequestBody List<FacilityVO> facilityVO) {
	     int result = facilityService.noStart(facilityVO);
	     
	     if(result>0) {
	    	 return "success";
	     }else {
	    	 return "fail";
	     }
   }
   @PostMapping("/work/noEnd")
   public String noEnd(FacilityVO facilityVO) {
      int result = facilityService.noEnd(facilityVO);
      
      if(result>0) {
    	  return "success";
      }else {
    	  return "fail";
      }
   }
   @GetMapping("/facility/noDetailListGo")
   public List<FacilityVO> noDetailListGo(FacilityVO facilityVO){
	 return facilityService.noReasonDetailList(facilityVO);   
   }
}
