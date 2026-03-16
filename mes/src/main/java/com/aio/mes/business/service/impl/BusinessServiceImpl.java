package com.aio.mes.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.business.mapper.BusinessMapper;
import com.aio.mes.business.service.BusinessDetailDeleteVO;
import com.aio.mes.business.service.BusinessDetailModifyVO;
import com.aio.mes.business.service.BusinessDetailVO;
import com.aio.mes.business.service.BusinessService;
import com.aio.mes.business.service.BusinessVO;
import com.aio.mes.business.service.ClientVO;
import com.aio.mes.business.service.GoodsVO;
import com.aio.mes.business.service.OrderParmeter;
import com.aio.mes.business.service.orderSimpleVO;
import com.aio.mes.security.service.LoginUserVO;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessMapper businessMapper;

	
   
    //업체조회
    @Override
	public List<ClientVO> clientList() {
	  return businessMapper.clientList();
	}
    //상품조회
    @Override
    public List<GoodsVO> goodsList(String entMemberCode, String prodName) {
    	return businessMapper.goodsList(entMemberCode, prodName);
    }
    //주문간단조회
	@Override
	public List<orderSimpleVO> orderSimpleList(BusinessVO businessVo) {
		// TODO Auto-generated method stub
		return businessMapper.orderSimpleList(businessVo);
	}
	//주문 불러오기
    @Override
    public List<BusinessVO> orderCall(String orderCode) {
    	return businessMapper.orderCall(orderCode);
    }
    //주문 상세조회
    @Override
    public List<BusinessDetailVO> orderDetailCall(String orderCode) {
    	return businessMapper.orderDetailCall(orderCode); 
    	
    }
    //주문 자동증가
    @Override
    public String getOrderNo() {
    	return businessMapper.getOrderNo();
    }
    @Override
    public String getOrderDetail() {
    	return businessMapper.getOrderDetailNo();
    }
    @Override
    public int orderCheck(String orderCode, String entMemberCode) {
    	
      int check=	businessMapper.orderCheck(orderCode, entMemberCode);
        return check;
    }
    @Transactional
    @Override
    public int insertOrder(OrderParmeter orderParmeter) {
    	List<BusinessVO> insertOrder =orderParmeter.getOrder();
    	List<BusinessDetailVO> insertDetailOrders = orderParmeter.getOrderDetail();
        
    	int orderResult = 0;
    	
    	for (BusinessVO insertOrderItem : insertOrder) {
    		orderResult += businessMapper.orderAdd(insertOrderItem);
    	}
    	for(BusinessDetailVO insertOrderDetail  : insertDetailOrders) {
    		businessMapper.orderDetailAdd(insertOrderDetail);
    	}
    	 
    	return orderResult;
    }
    //주문 변경
    @Transactional
	@Override
	public int modifyInsert(OrderParmeter orderParmeter) {
        
		List<BusinessVO> modifyOrder= orderParmeter.getOrder();
		List<BusinessDetailVO> modifyDetailOrder = orderParmeter.getOrderDetail();
		List<BusinessDetailModifyVO> modifyDetailUpdate = orderParmeter.getOrderModify();
		List<BusinessDetailDeleteVO> modifyDetailDelete = orderParmeter.getOrderDelete();
		
		int modifyResult=0;
		
	    //주문수정
		for(BusinessVO modifyOrders : modifyOrder) {
			modifyResult += businessMapper.orderUpdate(modifyOrders);
		}
		//수정중 주문상세 인서트 
		for(BusinessDetailVO modifyDetailOrders : modifyDetailOrder) {
			modifyResult += businessMapper.orderDetailAdd(modifyDetailOrders);
		}
		//수정중 주문상세 업데이트
		for(BusinessDetailModifyVO modifyDetailUpdates : modifyDetailUpdate) {
			modifyResult += businessMapper.orderDetailUpdate(modifyDetailUpdates);
		}
		//수정중 주문상세 삭제
		for(BusinessDetailDeleteVO modifyDetailDeletes : modifyDetailDelete) {
			modifyResult += businessMapper.orderDetailDelete(modifyDetailDeletes);
		}
		
		return modifyResult;
	}
  //주문삭제
   public int orderDelete(String orderCode) {
	   int result = 0;
	    result += businessMapper.orderDetailDrop(orderCode);
	    result += businessMapper.orderDelete(orderCode);
	   return result;
   }
   //=======================================================
   //주문조회페이지
  @Override
  public List<BusinessDetailVO> orderDetailList(BusinessDetailVO detailVO) {
	return businessMapper.orderDetailList(detailVO);
  }
  //주문간단조회(생산계획 모달용)
	@Override
	public List<orderSimpleVO> orderManuModal(BusinessVO businessVo) {
		
		return businessMapper.orderManuModal(businessVo);
	}
}
