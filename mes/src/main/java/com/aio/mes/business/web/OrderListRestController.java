package com.aio.mes.business.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.business.service.BusinessDetailVO;
import com.aio.mes.business.service.BusinessService;

@RestController
@RequestMapping("/order")
public class OrderListRestController {
    
	@Autowired
	BusinessService businessService;
	
	@GetMapping("/detailList")
	public List<BusinessDetailVO> detailList(BusinessDetailVO detailVO){
		return businessService.orderDetailList(detailVO);
	}
}
