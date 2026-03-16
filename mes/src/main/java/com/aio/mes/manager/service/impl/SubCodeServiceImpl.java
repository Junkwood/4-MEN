package com.aio.mes.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.manager.mapper.SubCodeMapper;
import com.aio.mes.manager.service.SubCodeParamVO;
import com.aio.mes.manager.service.SubCodeService;
import com.aio.mes.manager.service.SubCodeVO;

@Service
public class SubCodeServiceImpl implements SubCodeService{
    
	@Autowired
	SubCodeMapper subCodeMapper;
	
	@Override
    public List<SubCodeVO> mainCodeDisplay() {
    	return subCodeMapper.mainCodeDisplay();
    }
    @Override
    public List<SubCodeVO> subCodeDisplay(String mainCode) {
    	return subCodeMapper.subCodeDisplay(mainCode);
    }
    
    //등록
    @Transactional
    @Override
    public int add(SubCodeParamVO<SubCodeVO> subCodeParamVO) {
    	int result= 0;
    	List<SubCodeVO> add = subCodeParamVO.getAdd();
    	List<SubCodeVO> modify = subCodeParamVO.getModify();
    	List<SubCodeVO> delete = subCodeParamVO.getDrop();
    	for(SubCodeVO deletes:delete) {
    	   result+=subCodeMapper.subCodeDelete(deletes);	
    	}
    	for(SubCodeVO modifys:modify) {
    		result+=subCodeMapper.subCodeModify(modifys);
    	}
    	for(SubCodeVO adds:add) {
    		System.out.println("메인코드"+adds.getMainCode());
    		result+=subCodeMapper.subCodeAdd(adds);
    	}
    	return result;
    }
}
