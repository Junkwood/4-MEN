package com.aio.mes.dispatch.service;

import java.sql.SQLException;
import java.util.List;

public interface DispatchService {
    
	//출고 간단조회
	public List<DispatchVO> simpleDispatchList(DispatchSearchVO dispatchSearchVO); 
	//주문코드통해 출고등록시 디스플레이
	public List<DispatchVO> dispatchCall(String entMemberCode, String orderCode);
	//주문코드 출고수정시 메인창에 디스플레이
	public List<DispatchVO> dispatchModifyCall(String entMemberCode, String prodReleaseCode);
	//수량 기입시 디스플레이
	public List<DispatchVO> dispatchReady (String entMemberCode, String prodCode);
     //출고 등록
	public int dispatchAdd(List<DispatchVO> dispatch) throws SQLException;
	//출고 수정
	public int dispatchModify(List<DispatchVO> dispatchVO) throws SQLException;
	//출고 삭제
	public int dispatchRemove(List<DispatchVO> dispatchVO);
	//출고상세 리스트
    public List<DispatchVO> dispatchList(DispatchVO dispatchVO);
}
