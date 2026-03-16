package com.aio.mes.material.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aio.mes.business.service.ClientVO;
import com.aio.mes.material.service.InspectedMatVO;
import com.aio.mes.material.service.InspectiveMatOrderVO;
import com.aio.mes.material.service.MatCommonVO;
import com.aio.mes.material.service.MatHoldVO;
import com.aio.mes.material.service.MatOrderDTO;
import com.aio.mes.material.service.MatOrderDetailVO;
import com.aio.mes.material.service.MatOrderSearchDTO;
import com.aio.mes.material.service.MatOrderSearchVO;
import com.aio.mes.material.service.MatOrderVO;
import com.aio.mes.material.service.ModifyMatOrderDTO;
import com.aio.mes.material.service.NeedSupplyMatVO;
import com.aio.mes.material.service.NewMatOrderDTO;
import com.aio.mes.mybatis.service.InspUpdateMatoHandlerVO;
import com.aio.mes.mybatis.service.MatOrderDetailHandlerVO;
import com.aio.mes.mybatis.service.MatOrderHandlerVO;

public interface MaterialMapper {
	//자재 발주 정보 목록 뽑기
	public List<MatOrderVO> showMatOrderList();
	public List<MatOrderVO> searchMatOrderList(MatOrderDTO matOrderDTO);
	public List<MatOrderSearchVO> searchMatOrderList2(MatOrderSearchDTO DTO);
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
	public void modifyPrevMatOrder(ModifyMatOrderDTO DTO);
	
	//신규 발주건 등록
	public void saveNewMatOrder(NewMatOrderDTO DTO);
	
	//기존 발주건 삭제
	public void removeMatOrder(Map<String, Object> parameterMap);
	
	//검수 처리 할 자재 발주 상세 목록 조회
	public List<InspectiveMatOrderVO> searchInspectableMatOrderDetailsData(String matOrderCode);
	
	//기존에 검수처리된 자재 발주 검수 처리내역 조회
	public List<InspectedMatVO> showInspectedMatDataList();
	public List<InspectedMatVO> searchInspectedMatDataList(String matOrderName);
	
	//검수된 단건 정보 조회
	public InspectedMatVO searchInspectedMatOrderData(String matInspectCode);
	
	//검수내역 기반의 입고된 자재가 현재 홀드되어있는지 여부 반환
	public List<MatHoldVO> checkStoredMatDataIsHold(String matInspectCode);
	
	//날짜 기반 검수 내역 조회
	public List<InspectedMatVO> searchInspectedMatDataPerDate(String dateString);
	
	// MatOrder Modify
	public void updateMatOrderList(Map<String, Object> parameterMap);
	
	// MatOrderDetail Modify
	public void insertMatOrderDetailList(Map<String, Object> parameterMap);
	public void deleteMatOrderDetailList(Map<String, Object> parameterMap);
	public void updateMatOrderDetailList(Map<String, Object> parameterMap);
	
	// save new MatOrder
	public void saveNewMatOrder(Map<String, Object> parameterMap);
	
	// save new inspect mat order details
	public void insertInspectiveMatoList(Map<String, Object> parameterMap);

	// update inspected mat orders data
	public void updateInspectedData(Map<String, Object> parameterMap);

	// delete inspected mat orders data
	public void deleteInspectedData(Map<String, Object> parameterMap);
	
	//자재 과부족 현황 조회
	public List<NeedSupplyMatVO> searchNeedSupplyMatList(String matSupplyNeedInputVal);
}
     
