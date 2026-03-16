package com.aio.mes.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.manager.mapper.EmployeeMapper;
import com.aio.mes.manager.service.EmpService;
import com.aio.mes.manager.service.EmpVO;
import com.aio.mes.manager.service.SubCodeParamVO;
import com.aio.mes.manager.service.SubCodeVO;

@Service
public class EmpServiceImpl implements EmpService{
   @Autowired
   EmployeeMapper empMapper;
   @Autowired
	PasswordEncoder passwordEncoder;
   @Override
	public List<EmpVO> empList(EmpVO empVO) {
		List<EmpVO> list = empMapper.empList(empVO);
	   return list;
	}
   //등록
   @Transactional
   @Override
	public int add(SubCodeParamVO<EmpVO> subCodeParamVO) {
		int result = 0;
		List<EmpVO> add =subCodeParamVO.getAdd();
		List<EmpVO> modify =subCodeParamVO.getModify();
		List<EmpVO> delete =subCodeParamVO.getDrop();
		for(EmpVO deletes : delete) {
			result+=empMapper.empDelete(deletes);
		}
		for(EmpVO modifys:modify) {
			System.err.println(modifys.getPassword());
		    if(modifys.getPassword()!=null) {
		    	modifys.setPassword(passwordEncoder.encode(modifys.getPassword()));
		    };	
			result+=empMapper.empModify(modifys);
		}
		for(EmpVO adds :add) {
			if(adds.getPassword()!=null) {
				adds.setPassword(passwordEncoder.encode(adds.getPassword()));
		    };	
			result+=empMapper.empAdd(adds);
		}
	   return result;
	}
}
