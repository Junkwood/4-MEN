package com.aio.mes.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error/404")
    public String handle404Error() {
        return "error/404"; 
    }

    @GetMapping("/error/403")
    public String handle403Error() {
        return "error/403"; 
    }

    @GetMapping("/error/500")
    public String handle500Error() {
        return "error/500"; 
    }
}
  