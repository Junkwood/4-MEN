package com.aio.mes.dispatch.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.dispatch.mapper.DispatchMapper;
import com.aio.mes.dispatch.service.DispatchSearchVO;
import com.aio.mes.dispatch.service.DispatchService;
import com.aio.mes.dispatch.service.DispatchVO;
import com.aio.mes.production.web.ProductionRestController;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DispatchServiceImpl implements DispatchService{
	
	@Autowired
	DispatchMapper dispatchMapper;
  
	//출고조회
	@Override
    public List<DispatchVO> simpleDispatchList(DispatchSearchVO dispatchSearchVO) {
	     return dispatchMapper.simpleDispatchList(dispatchSearchVO);
    }
	//주문코드통해 출고 디스플레이
	@Override
	public List<DispatchVO> dispatchCall(String entMemberCode, String orderCode) {
		return dispatchMapper.dispatchCall(entMemberCode, orderCode);
	}
	@Override
	public List<DispatchVO> dispatchModifyCall(String entMemberCode, String prodReleaseCode) {
		return dispatchMapper.dispatchModifyCall(entMemberCode, prodReleaseCode);
	}
	@Override
	public List<DispatchVO> dispatchReady(String entMemberCode, String prodCode) {
		return dispatchMapper.dispatchReady(entMemberCode, prodCode);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int dispatchAdd(List<DispatchVO> dispatch) throws SQLException {
		int dispatchResult= 0;
		for(DispatchVO dispatchs :dispatch) {
			dispatchResult += dispatchMapper.dispatchAdd(dispatchs);
		}
		for(DispatchVO dispatchVOs : dispatch) {
			int check = dispatchMapper.quantityCheck(dispatchVOs);
			if(check==0) {
		        dispatchVOs.setProcessStatus("PS3");
		        dispatchMapper.statusModify1(dispatchVOs);
			}else if(check>0) {
				dispatchVOs.setProcessStatus("PS2");
				dispatchMapper.statusModify1(dispatchVOs);
			}else {
				try {
					throw new Exception();
				}catch(Exception ex) {
					dispatchResult=-1;
					throw new SQLException();
				}
			}
		}
		
		return dispatchResult;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int dispatchModify(List<DispatchVO> dispatchVO) throws SQLException {
		int dispatchResult = 0;
		for(DispatchVO dispatchVOs : dispatchVO) {
		 dispatchResult+=dispatchMapper.dispatchModify(dispatchVOs);
		}
		for(DispatchVO dispatchVOs : dispatchVO) {
			int check = dispatchMapper.quantityCheck(dispatchVOs);
			if(check==0) {
		        dispatchVOs.setProcessStatus("PS3");
		        dispatchMapper.statusModify1(dispatchVOs);
			}else if(check>0) {
				dispatchVOs.setProcessStatus("PS2");
				dispatchMapper.statusModify1(dispatchVOs);
			}else {
				try {
					throw new Exception();
				}catch(Exception ex) {
					dispatchResult=-1;
					throw new SQLException();
				}
			}
		}
		return dispatchResult;
	}
	//삭제 
	@Override
	public int dispatchRemove(List<DispatchVO> dispatchVO) {
		int result = 0;
		for(DispatchVO dispatchVOs : dispatchVO) {
		result =  dispatchMapper.dispatchDelete(dispatchVOs);
		
	  }for(DispatchVO dispatchVOs : dispatchVO) {
			int check = dispatchMapper.quantityCheck(dispatchVOs);
			if(check>0) {
				int orderCheck = dispatchMapper.orderquantity(dispatchVOs);
				if(check==orderCheck) {
					dispatchVOs.setProcessStatus("PS1");
					dispatchMapper.statusModify1(dispatchVOs);	
				}
				else {
				dispatchVOs.setProcessStatus("PS2");
				dispatchMapper.statusModify1(dispatchVOs);
				}
			}
		}
		return result;
	}
	@Override
	public List<DispatchVO> dispatchList(DispatchVO dispatchVO) {
		return dispatchMapper.dispatchList(dispatchVO);
	}
}
