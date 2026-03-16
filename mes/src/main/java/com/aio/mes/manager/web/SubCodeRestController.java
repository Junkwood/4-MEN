package com.aio.mes.manager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.manager.service.SubCodeParamVO;
import com.aio.mes.manager.service.SubCodeService;
import com.aio.mes.manager.service.SubCodeVO;
/*
 * @author:신현욱
 */
@RestController
@RequestMapping("/admin")
public class SubCodeRestController {
   
	@Autowired
	SubCodeService subCodeService;
	
	@GetMapping("/mainCodeDisplay")
	public List<SubCodeVO> mainCode() {
	   	List <SubCodeVO> list= subCodeService.mainCodeDisplay();
	   	return list;
	}
	@GetMapping("/subCodeDisplay")
	public List<SubCodeVO> suvCode(String mainCode) {
	   	List <SubCodeVO> list= subCodeService.subCodeDisplay(mainCode);
	   	return list;
	}
	@PostMapping("/subCodeAdd")
	public String add(@RequestBody SubCodeParamVO<SubCodeVO> subCodeParamVO) {
		int result = subCodeService.add(subCodeParamVO);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
}
