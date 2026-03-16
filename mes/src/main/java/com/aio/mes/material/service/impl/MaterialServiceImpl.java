package com.aio.mes.material.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.business.service.ClientVO;
import com.aio.mes.material.mapper.MaterialMapper;
import com.aio.mes.material.service.InspectedMatVO;
import com.aio.mes.material.service.InspectiveMatOrderVO;
import com.aio.mes.material.service.MatCommonVO;
import com.aio.mes.material.service.MatHoldVO;
import com.aio.mes.material.service.MatOrderDTO;
import com.aio.mes.material.service.MatOrderDetailVO;
import com.aio.mes.material.service.MatOrderSearchDTO;
import com.aio.mes.material.service.MatOrderSearchVO;
import com.aio.mes.material.service.MatOrderVO;
import com.aio.mes.material.service.MaterialService;
import com.aio.mes.material.service.ModifyMatOrderDTO;
import com.aio.mes.material.service.NeedSupplyMatVO;
import com.aio.mes.material.service.NewMatOrderDTO;
import com.aio.mes.mybatis.service.InspMatoHandlerVO;
import com.aio.mes.mybatis.service.InspUpdateMatoHandlerVO;
import com.aio.mes.mybatis.service.MatOrderDetailHandlerVO;
import com.aio.mes.mybatis.service.MatOrderHandlerVO;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;
    
	@Override
	public List<MatOrderDetailVO> showMatOrderDetailList(String matOrderCode) {
		return materialMapper.showMatOrderDetailList(matOrderCode);
	}

	@Override
	public List<MatOrderVO> showMatOrderList() {
		return materialMapper.showMatOrderList();
	}

	@Override
	public List<MatOrderVO> searchMatOrderList(MatOrderDTO matOrderDTO) {
		return materialMapper.searchMatOrderList(matOrderDTO);
	}
	
	@Override
	public List<MatOrderSearchVO> searchMatOrderList(MatOrderSearchDTO DTO) {
		return materialMapper.searchMatOrderList2(DTO);
	}
	
	@Override
	public MatOrderVO getMatOrderInfo(String matOrderCode) {
		return materialMapper.getMatOrderInfo(matOrderCode);
	}

	@Override
	public List<MatCommonVO> showMatCommonList() {
		return materialMapper.showMatCommonList();
	}

	@Override
	public List<MatCommonVO> searchMatCommonList(String matName) {
		return materialMapper.searchMatCommonList(matName);
	}

	@Override
	public List<ClientVO> showClientList() {
		return materialMapper.showClientList();
	}

	@Override
	public List<ClientVO> searchClientList(String clientName) {
		return materialMapper.searchClientList(clientName);
	}

	@Override
	@Transactional
	public List<String> modifyPrevMatOrder(ModifyMatOrderDTO DTO) {
		Map<String, Object> matOrderMap = new HashMap<String, Object>();
		Map<String, Object> createdRowsMap = new HashMap<String, Object>();
		Map<String, Object> deletedRowsMap = new HashMap<String, Object>();
		Map<String, Object> updatedRowsMap = new HashMap<String, Object>();
		
		if(DTO.getMatOrderRows() != null && DTO.getMatOrderRows().size() > 0) {
			
			//자재 발주 정보 업데이트
			matOrderMap.put("p_mato_list", DTO.getMatOrderRows());
			matOrderMap.put("p_output_msg", "");
			materialMapper.updateMatOrderList(matOrderMap);
			
			//자재 상세 정보 - 삽입
			if(DTO.getCreatedRows() != null && DTO.getCreatedRows().size() > 0) {
				for(int i = 0; i < DTO.getCreatedRows().size(); ++i) {
					DTO.getCreatedRows().get(i).setMatOrderDetailCode("");
					DTO.getCreatedRows().get(i).setMatOrderCode("");
				}
				createdRowsMap.put("p_mato_list", DTO.getMatOrderRows());
				createdRowsMap.put("p_matod_insert_list", DTO.getCreatedRows());
				createdRowsMap.put("p_output_msg", "");
				materialMapper.insertMatOrderDetailList(createdRowsMap);
			}
			//자재 상세 정보 - 삭제
			if(DTO.getDeletedRows() != null && DTO.getDeletedRows().size() > 0) {
				deletedRowsMap.put("p_mato_list", DTO.getMatOrderRows());
				deletedRowsMap.put("p_matod_delete_list", DTO.getDeletedRows());
				deletedRowsMap.put("p_output_msg", "");
				materialMapper.deleteMatOrderDetailList(deletedRowsMap);
			}
			if(DTO.getUpdatedRows() != null && DTO.getUpdatedRows().size() > 0) {
				updatedRowsMap.put("p_matod_update_list", DTO.getUpdatedRows());
				updatedRowsMap.put("p_output_msg", "");
				materialMapper.updateMatOrderDetailList(updatedRowsMap);
			}
		}
		List<String> list = new ArrayList<String>();
		
		if(matOrderMap.get("p_output_msg") != null && matOrderMap.get("p_output_msg") != "") {
			list.add((String)matOrderMap.get("p_output_msg"));
		}
		if(createdRowsMap.get("p_output_msg") != null && createdRowsMap.get("p_output_msg") != "") {
			list.add((String)createdRowsMap.get("p_output_msg"));
		}
		if(deletedRowsMap.get("p_output_msg") != null && deletedRowsMap.get("p_output_msg") != "") {
			list.add((String)deletedRowsMap.get("p_output_msg"));
		}
		if(updatedRowsMap.get("p_output_msg") != null && updatedRowsMap.get("p_output_msg") != "") {
			list.add((String)updatedRowsMap.get("p_output_msg"));
		}
		
		return list;
	}

	@Override
	public List<String> saveNewMatOrder(NewMatOrderDTO DTO) {
		List<String> stringList = new ArrayList<String>();
		
		if(DTO.getMatOrderRows() != null && DTO.getMatOrderRows().size() > 0) {
			//등록될 발주 정보 NULL 처리
			for(MatOrderHandlerVO matOrder : DTO.getMatOrderRows()) {
				matOrder.setMatOrderCode("");
			}
			
			System.out.println(DTO.getMatOrderRows().toString());
			//등록 처리
			for(int i = 0; i < DTO.getMatOrderRows().size(); ++i) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				if(DTO.getCreativeMatOrderRows().get(i) != null && DTO.getCreativeMatOrderRows().get(i).size() > 0) {
					//등록될 발주 상세 정보 NULL 처리
					for(MatOrderDetailHandlerVO detail : DTO.getCreativeMatOrderRows().get(i)) {
						detail.setMatOrderDetailCode("");
						detail.setMatOrderCode("");
					}
					//n번째 발주 정보에 해당하는 n번째 리스트 속 상세 정보들이 Insert되어야한다.
					map.put("p_mato_map", DTO.getMatOrderRows().get(i));
					map.put("p_matod_insert_list", DTO.getCreativeMatOrderRows().get(i));
					map.put("p_output_msg", "");
					materialMapper.saveNewMatOrder(map);
					if(map.get("p_output_msg") == "") map.remove("p_output_msg");
					stringList.add((String)map.get("p_output_msg"));
				}
			}
		}
		return stringList; 
	}

	@Override
	public String removeMatOrder(String matOrderCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_mat_order_code", matOrderCode);
		map.put("p_output_msg", "");
		materialMapper.removeMatOrder(map);
		if(map.get("p_output_msg") == "") map.remove("p_output_msg");
		
		return (String)map.get("p_output_msg");
	}

	@Override
	public List<MatOrderVO> searchUnCompletedMatOrderList(MatOrderDTO matOrderDTO) {
		return materialMapper.searchUnCompletedMatOrderList(matOrderDTO);
	}

	@Override
	public List<InspectiveMatOrderVO> searchInspectableMatOrderDetailsData(String matOrderCode) {
		return materialMapper.searchInspectableMatOrderDetailsData(matOrderCode);
	}

	@Override
	public String createNewInspectMatOrder(List<InspMatoHandlerVO> inspectiveMatOrderVOList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_insp_mato_list", inspectiveMatOrderVOList);
		map.put("p_output_msg", "");
		
		materialMapper.insertInspectiveMatoList(map);
		if(map.get("p_output_msg") == "") map.remove("p_output_msg");
		
		return (String)map.get("p_output_msg");
	}

	@Override
	public List<InspectedMatVO> showInspectedMatDataList() {
		return materialMapper.showInspectedMatDataList();
	}
	
	@Override
	public List<InspectedMatVO> searchInspectedMatDataList(String matOrderName) {
		return materialMapper.searchInspectedMatDataList(matOrderName);
	}
	
	@Override
	public InspectedMatVO searchInspectedMatOrderData(String matInspectCode) {
		return materialMapper.searchInspectedMatOrderData(matInspectCode);
	}

	@Override
	public String updateInspectedData(List<InspectedMatVO> inspectedMatVOList) {
		
		if(inspectedMatVOList == null || inspectedMatVOList.size() < 1) {
			return "수정할 정보가 비어 있습니다.";
		}
		
		List<InspUpdateMatoHandlerVO> parseDataList = new ArrayList<InspUpdateMatoHandlerVO>();
		
		for(InspectedMatVO data : inspectedMatVOList) {
			InspUpdateMatoHandlerVO parseData = new InspUpdateMatoHandlerVO();
			parseData.setMatInspectCode(data.getMatInspectCode());
			parseData.setInspectQuantity(data.getInspectQuantity());
			parseData.setErrorQuantity(data.getErrorQuantity());
			parseData.setNote(data.getNote());
			parseData.setEmpCode(data.getEmpCode());
			parseData.setEmpName(data.getEmpName());
			parseDataList.add(parseData);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_insp_mato_list", parseDataList);
		map.put("p_output_msg", "");
		materialMapper.updateInspectedData(map);
		if(map.get("p_output_msg") == "") map.remove("p_output_msg");
		
		return (String)map.get("p_output_msg");
	}

	@Override
	public String deleteInspectedData(List<InspectedMatVO> inspectedMatVOList) {
		if(inspectedMatVOList == null || inspectedMatVOList.size() < 1) {
			return "삭제할 정보가 비어 있습니다.";
		}
		
		List<InspUpdateMatoHandlerVO> parseDataList = new ArrayList<InspUpdateMatoHandlerVO>();
		
		for(InspectedMatVO data : inspectedMatVOList) {
			InspUpdateMatoHandlerVO parseData = new InspUpdateMatoHandlerVO();
			parseData.setMatInspectCode(data.getMatInspectCode());
			parseData.setInspectQuantity(data.getInspectQuantity());
			parseData.setErrorQuantity(data.getErrorQuantity());
			parseData.setNote(data.getNote());
			parseData.setEmpCode(data.getEmpCode());
			parseData.setEmpName(data.getEmpName());
			parseDataList.add(parseData);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_insp_mato_list", parseDataList);
		map.put("p_output_msg", "");
		
		materialMapper.deleteInspectedData(map);
		if(map.get("p_output_msg") == "") map.remove("p_output_msg");
		
		return (String)map.get("p_output_msg");
	}

	@Override
	@Transactional
	public Map<String, Boolean> checkStoredMatDataIsHold(List<InspectedMatVO> inspectedMatVOList) {
		Map<String, Boolean> holdMatData = new HashMap<String, Boolean>();
		for(InspectedMatVO data : inspectedMatVOList) {
			List<MatHoldVO> holdVO = materialMapper.checkStoredMatDataIsHold(data.getMatInspectCode());
			
			if(holdVO != null && holdVO.size() > 0) {
				holdMatData.put(data.getMatInspectCode(), true);
			}
		}
		return holdMatData;
	}

	@Override
	public List<InspectedMatVO> searchInspectedMatDataPerDate(String dateString) {
		List<InspectedMatVO> list = materialMapper.searchInspectedMatDataPerDate(dateString); 
		System.out.println(list);
		return list != null && list.size() > 0 ? list : null;
	}

	@Override
	public List<NeedSupplyMatVO> searchNeedSupplyMatList(String matSupplyNeedInputVal) {
		return materialMapper.searchNeedSupplyMatList(matSupplyNeedInputVal);
	}
}
