package com.aio.mes.dispatch.mapper;

import java.util.List;

import com.aio.mes.dispatch.service.DispatchSearchVO;
import com.aio.mes.dispatch.service.DispatchVO;

public interface DispatchMapper {
	//출고 간단 조회
	public List<DispatchVO> simpleDispatchList(DispatchSearchVO dispatchSearchVO);
    //주문코드 클릭생성시 메인창에 디스플레이
	public List<DispatchVO> dispatchCall(String entMemberCode, String orderCode);
	//주문코드 클릭수정시 메인창에 디스플레이
	public List<DispatchVO> dispatchModifyCall(String entMemberCode, String prodReleaseCode);
	//수량 기입시 디스플레이
	public List<DispatchVO> dispatchReady (String entMemberCode, String prodCode);
	 //출고 등록
	public int dispatchAdd(DispatchVO dispatch);    
	//출고 수정
	public int dispatchModify(DispatchVO dispatch);
	//출고 삭제
	public int dispatchDelete(DispatchVO dispatchVO);
	//주문상세 상태변경
	public int statusModify(String processStatus,String orderCode,String prodCode);
	//수량 체크
	public int quantityCheck(DispatchVO dispatchVO);
	//주문수량 체크
	public int orderquantity(DispatchVO dispatchVO);
	//주문상세 상태변경
	public int statusModify1(DispatchVO dispatchVO);
	//출고상세 리스트
	public List<DispatchVO> dispatchList(DispatchVO dispatchVO);
}

