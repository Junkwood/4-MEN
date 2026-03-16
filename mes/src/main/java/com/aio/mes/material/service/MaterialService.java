package com.aio.mes.material.service;

import java.util.List;
import java.util.Map;

import com.aio.mes.business.service.ClientVO;
import com.aio.mes.mybatis.service.InspMatoHandlerVO;

public interface MaterialService {
	//자재 발주 정보 목록 뽑기
	public List<MatOrderVO> showMatOrderList();
	public List<MatOrderVO> searchMatOrderList(MatOrderDTO matOrderDTO);
	public List<MatOrderSearchVO> searchMatOrderList(MatOrderSearchDTO DTO);
	public List<MatOrderVO> searchUnCompletedMatOrderList(MatOrderDTO matOrderDTO);
	
	//단건 자재 발주 정보에 대한 자재 상세 목록 뽑기
	public List<MatOrderDetailVO> showMatOrderDetailList(String matOrderCode);
	
	//단건 자재 발주 정보 검색
	public MatOrderVO getMatOrderInfo(String matOrderCode);
	
	//자재 목록 조회
	public List<MatCommonVO> showMatCommonList();
	public List<MatCommonVO> searchMatCommonList(String matName);
	
	//거래처 목록 조회
	public List<ClientVO> showClientList();
	public List<ClientVO> searchClientList(String clientName);
	
	//기존 발주건 수정
	public List<String> modifyPrevMatOrder(ModifyMatOrderDTO DTO);
	
	//신규 발주건 등록
	public List<String> saveNewMatOrder(NewMatOrderDTO DTO);
	
	//기존 발주건 삭제
	public String removeMatOrder(String matOrderCode);
	
	//검수 처리 할 자재 발주 상세 목록 조회
	public List<InspectiveMatOrderVO> searchInspectableMatOrderDetailsData(String matOrderCode);
	
	//신규 자재 발주 검수 처리 등록
	public String createNewInspectMatOrder(List<InspMatoHandlerVO> inspectiveMatOrderVOList);
	
	//기존에 검수처리된 자재 발주 검수 처리내역 조회
	public List<InspectedMatVO> showInspectedMatDataList();
	public List<InspectedMatVO> searchInspectedMatDataList(String matOrderName);

	//검수된 단건 정보 조회
	public 	InspectedMatVO searchInspectedMatOrderData(String matInspectCode);
	
	//검수된 내역 업데이트
	public String updateInspectedData(List<InspectedMatVO> inspectedMatVOList);
	
	//검수된 내역 삭제
	public String deleteInspectedData(List<InspectedMatVO> inspectedMatVOList);
	
	//검수내역 기반의 입고된 자재가 현재 홀드되어있는지 여부 반환
	public Map<String, Boolean> checkStoredMatDataIsHold(List<InspectedMatVO> inspectedMatVOList);
	
	//날짜 기반 검수 내역 조회
	public List<InspectedMatVO> searchInspectedMatDataPerDate(String dateString);
	
	//자재 과부족 현황 조회
	public List<NeedSupplyMatVO> searchNeedSupplyMatList(String matSupplyNeedInputVal);
}
