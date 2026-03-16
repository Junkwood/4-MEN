package com.aio.mes.finished.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aio.mes.finished.service.FinishedService;
import com.aio.mes.finished.service.FinishedVO;


@Controller
public class FinishedFormController {
	@Autowired
	FinishedService finishedService;
	@GetMapping("/business/finished")
	public String dispatchForm(Model model) {
		String auto =finishedService.autoLot(); 
		model.addAttribute("auto",auto);
		return "orders/finished";
	}
	@GetMapping("/business/inventory")
	public String Finished() {
		return "orders/inventoryList";
	}
}
