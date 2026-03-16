package com.aio.mes.manager.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class EmpFormController {
   
	
	@GetMapping("/emp")
	public String subCode() {
		return "web/manager/emp";
	}
}
