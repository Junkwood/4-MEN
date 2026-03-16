package com.aio.mes.finished.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;

import com.aio.mes.finished.mapper.FinishedMapper;
import com.aio.mes.finished.service.FinishedService;
import com.aio.mes.finished.service.FinishedVO;

@Service
public class FinishedServiceImpl implements FinishedService {
	@Autowired
	FinishedMapper finishedMapper;

	@Override
	public List<FinishedVO> storePossible(FinishedVO finishedVO) {
		return finishedMapper.storePossible(finishedVO);
	}

	@Override
	public String autoLot() {
		return finishedMapper.autoLot();
	}

	@Override
	public List<FinishedVO> alreadyFinished(String lot, String prodName) {
		return finishedMapper.alreadyFinished(lot, prodName);
	}

	@Override
	public int modifyCheck(String workInstructDetailCode, String prodCode) {

		return modifyCheck(workInstructDetailCode, prodCode);
	}

	// 등록
	@Override
	public int addFinished(List<FinishedVO> finishedVO) {
		int result = 0;
		for (FinishedVO finishedVOs : finishedVO) {
			result += finishedMapper.addFinished(finishedVOs);
		}
		return result;
	}

	// 입고한 완제품 수정
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateFinished(List<FinishedVO> finishedVO) throws SQLException {
		int result = 0;
		for (FinishedVO finishedVOs : finishedVO) {
			// 상품코드와 작업지시상세코드를 전해주고 거기에 맞는 수량을 파악한다.
			result += finishedMapper.updateFinished(finishedVOs);
		}
		for (FinishedVO finishedVOs : finishedVO) {
			 int dispatchCheck =finishedMapper.dispatchCheck(finishedVOs);
	    	  if(dispatchCheck>0) {
	    		  result=-2;
	    		  break;
	    	  }
		int modifyCheck = finishedMapper.modifyCheck(finishedVOs);
		if (modifyCheck < 0) {
			try {
				throw new Exception();
			} catch(Exception ex) {
				result=-1;
				throw new SQLException();
			}
		}
	}
		return result;
	}
	//입고한 제품 삭제
    @Transactional
	@Override
	public int deleteFinished(List<FinishedVO> finishedVO) {
		int result= 0 ;
    	for(FinishedVO finishedVOs: finishedVO) {
    	  int dispatchCheck =finishedMapper.dispatchCheck(finishedVOs);
    	  if(dispatchCheck>0) {
    		  result=-1;
    		  break;
    	  }
		  result += finishedMapper.deleteFinished(finishedVOs);	
		}
		return result;
	}
    
    //완제품 입고 조회
    @Override
    public List<FinishedVO> finishedList(FinishedVO finishedVO) {
    	return finishedMapper.finishedList(finishedVO);
    }
    
}
