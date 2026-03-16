package com.aio.mes.business.service;

import java.util.List;

public interface BusinessService {
	
	
	//업체 조회
    public List<ClientVO> clientList();
    //상품 조회
    public List<GoodsVO> goodsList(String entMemberCode, String prodName);
	//주문 간단조회
	public List<orderSimpleVO> orderSimpleList(BusinessVO businessVo);
	//주문조회값 불러오기
	public List<BusinessVO> orderCall(String orderCode);
	//주문상세값 불러오기
	public List<BusinessDetailVO> orderDetailCall(String orderCode);
	//주문코드 자동증가
	public String getOrderNo();
	//주문상세코드 자동증가
	public String getOrderDetail();
	//등록 및 수정하기위한 유효성검사
	public int orderCheck(String orderCode, String entMemberCode);
	//주문등록
	public int insertOrder(OrderParmeter orderParmeter);
    //수정시 생기는 등록
	public int modifyInsert(OrderParmeter orderParmeter);
	//주문삭제
	public int orderDelete(String orderCode);
	//주문 상세 등록
	public List<BusinessDetailVO> orderDetailList(BusinessDetailVO detailVO);
	//주문 간단조회(생산계획모달용)
	public List<orderSimpleVO> orderManuModal(BusinessVO businessVo);
}
