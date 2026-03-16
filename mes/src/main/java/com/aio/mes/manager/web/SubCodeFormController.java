package com.aio.mes.manager.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class SubCodeFormController {
   
	
	@GetMapping("/subCode")
	public String subCode() {
		return "codeManage/codeManage";
	}
}
