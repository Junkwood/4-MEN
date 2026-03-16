package com.aio.mes.business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aio.mes.business.service.BusinessService;

@Controller
@RequestMapping("/business")
public class OrderListFormController {
   
	@Autowired
	   BusinessService businessService;
	
	@GetMapping("/orderList")
	public String orderList() {
		return "orders/orderList";
	}
}
