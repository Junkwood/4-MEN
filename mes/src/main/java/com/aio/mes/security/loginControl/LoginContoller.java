package com.aio.mes.security.loginControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 주문관리 
 * @author 신현욱
 * 2024-05-22 
 */
@Controller
public class LoginContoller {
   @GetMapping("/account/login")
     public String LoginPage() {
	   return "account/login";   
   }
}
