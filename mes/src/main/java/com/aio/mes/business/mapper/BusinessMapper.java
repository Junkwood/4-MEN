package com.aio.mes.business.mapper;

import java.util.List;

import com.aio.mes.business.service.BusinessDetailDeleteVO;
import com.aio.mes.business.service.BusinessDetailModifyVO;
import com.aio.mes.business.service.BusinessDetailVO;
import com.aio.mes.business.service.BusinessVO;
import com.aio.mes.business.service.ClientVO;
import com.aio.mes.business.service.GoodsVO;
import com.aio.mes.business.service.orderSimpleVO;


public interface BusinessMapper {
     
	//업체명 조회
	public List<ClientVO> clientList();
	//상품조회
	public List<GoodsVO> goodsList(String entMemberCode,String prodName);
	//주문 간단 조회 
	public List<orderSimpleVO> orderSimpleList(BusinessVO businessVO);
    //주문조회값 불러오기
	public List<BusinessVO> orderCall(String orderCode);
	//주문상세값 불러오기
	public List<BusinessDetailVO> orderDetailCall(String orderCode);
	//주문코드 자동증가
	public String getOrderNo();
	//상세주문코드 자동증가
	public String getOrderDetailNo();
	//등록 및 수정하기위한 유효성검사
	public int orderCheck(String orderCode, String entMemberCode);
    //주문등록
	public int orderAdd(BusinessVO businessVO);
	//주문상세등록
	public int orderDetailAdd(BusinessDetailVO businessDetail);
    //주문수정
	public int orderUpdate(BusinessVO business);
    //주문상세수정
	public int orderDetailUpdate(BusinessDetailModifyVO businessDetail);
	//주문상세 수정 시 삭제
	public int orderDetailDelete(BusinessDetailDeleteVO businessDetail);
	//주문삭제
	public int orderDelete(String orderCode);
    //주문상세 삭제
	public int orderDetailDrop(String orderCode);
	//주문 목록 상세 조회
	public List<BusinessDetailVO> orderDetailList(BusinessDetailVO detailVO);
	//주문 간단 조회(생산계획용)
	public List<orderSimpleVO> orderManuModal(BusinessVO businessVO);
}
