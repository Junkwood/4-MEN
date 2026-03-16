package com.aio.mes.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.main.service.MainService;
import com.aio.mes.main.service.MainVO;
/**
 * 주문관리 
 * @author 신현욱
 * 2024-05-24 
 */
@RestController
public class MainRestController {
	 @Autowired
     MainService mainService;
	 
	 @PostMapping("/main/orderChart")
	 public List<MainVO> barChart() {
	     return mainService.orderChart();
	 }
	 @PostMapping("/main/matChart")
	 public List<MainVO> matChart() {
	     return mainService.matOrderChart();
	 }
	 @PostMapping("/main/orderLine")
	 public List<MainVO> orderLine(){
		 return mainService.orderQuantity();
	 }
	 @PostMapping("/main/matUsedChart")
		 public List<MainVO> usedChart(){
			 return mainService.matUsed();
		};
	 
}
