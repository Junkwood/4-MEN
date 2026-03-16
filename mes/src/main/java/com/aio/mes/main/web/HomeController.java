package com.aio.mes.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aio.mes.main.service.MainService;

@Controller
public class HomeController {
	@Autowired
	MainService mainService;
	 @GetMapping("/")
	   public String homePage(Model model) {
		 int todayOrder = mainService.todayOrder();
		 int todayMatRequired =mainService.todayMatRequired();
		 int todayStore = mainService.todayStore();
		 int todayRelease = mainService.todayRelease();
		 model.addAttribute("todayOrder",todayOrder);
		 model.addAttribute("todayMatRequired",todayMatRequired);
		 model.addAttribute("todayStore",todayStore);
		 model.addAttribute("todayRelease",todayRelease);
		 return "home";
	 }
}
