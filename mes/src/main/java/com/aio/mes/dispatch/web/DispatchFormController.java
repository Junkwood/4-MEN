package com.aio.mes.dispatch.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DispatchFormController {

	
	@GetMapping("/business/dispatch")
	public String dispatchForm(Model model) {
		return "orders/dispatch";
	}
	@GetMapping("/business/dispatchList")
	public String dispatchListForm() {
		return "orders/dispatchList";
	}
	
}
