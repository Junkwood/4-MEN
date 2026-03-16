package com.aio.mes.flow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlowFormController {
  @GetMapping("/admin/flow")
  public String workFlow() {
	  return "web/manager/flow";
  }
}
