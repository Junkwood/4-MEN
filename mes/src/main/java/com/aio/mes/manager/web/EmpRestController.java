package com.aio.mes.manager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.manager.service.EmpService;
import com.aio.mes.manager.service.EmpVO;
import com.aio.mes.manager.service.SubCodeParamVO;

@RestController
@RequestMapping("/admin")
public class EmpRestController {
  
	@Autowired
	EmpService empService;
	
	@GetMapping("/empList")
	public List<EmpVO> empList(EmpVO empVO) {
		 System.err.println(empVO.getEmpName());
		 return empService.empList(empVO);
	}
	@PostMapping("/empAdd")
	public String add(@RequestBody SubCodeParamVO<EmpVO> empVO) {
		int result = empService.add(empVO);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
}
