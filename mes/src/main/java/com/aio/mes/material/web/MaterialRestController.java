package com.aio.mes.material.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.business.service.ClientVO;
import com.aio.mes.material.service.InspectedMatVO;
import com.aio.mes.material.service.InspectiveMatOrderVO;
import com.aio.mes.material.service.MatCommonVO;
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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
@RestController
public class MaterialRestController {
	@Autowired
   	MaterialService materialService;
	
	@GetMapping("matOrderListAjax")
	public List<MatOrderVO> showMatOrderListAjax(){
		return materialService.showMatOrderList();
	}
	@GetMapping("searchMatOrderAjax")
	public List<MatOrderSearchVO> searchMatOrderAjax(MatOrderSearchDTO DTO){
		System.out.println("DTO " + DTO.toString());
		List<MatOrderSearchVO> list = materialService.searchMatOrderList(DTO);
		System.out.println(list.toString());
		return list;
	}
	@PostMapping("matOrderListAjax")
	public List<MatOrderVO> searchMatOrderListAjax(MatOrderDTO matOrderDTO){
		return materialService.searchMatOrderList(matOrderDTO);
	}
	
	@PostMapping("uncompletedMatOrderListAjax")
	public List<MatOrderVO> searchUncompletedMatOrderListAjax(MatOrderDTO matOrderDTO){
		return materialService.searchUnCompletedMatOrderList(matOrderDTO);
	}
	
	@PostMapping("matOrderDetailListAjax")
	public List<MatOrderDetailVO> showMatOrderDetailListAjax(String matOrderCode){
		return materialService.showMatOrderDetailList(matOrderCode);
	}
	
	@PostMapping("checkMatOrderTypeAjax")
	public String checkMatOrderTypeAjax(@RequestBody List<MatOrderVO> matOrderList) {
		//받아온 데이터는 메인 상단 그리드에 들어가 있던 목록이다.
		//수정 중일 경우 => 단건 데이터가 들어있다.
		//등록 중일 경우 => 복수 데이터가 들어있다.(여러건 추가 가능 하기 때문에)

		//현재 작업 중인 건이 생성건인지 수정건인지 판별
		boolean isCreationTask = true;
		if (matOrderList != null && matOrderList.size() > 0) {
			for(MatOrderVO item : matOrderList) {
				//주문번호가 부여되어있지 않다면 생성건이다. 고로 바로 break
				if (item.getMatOrderCode() == null) break;
				
				//DB에 동일한 주문건이 있다면 수정건이다. 상태 변경 후 break
				if (materialService.getMatOrderInfo(item.getMatOrderCode()) != null){
					isCreationTask = false;
					break;
				}
			}
		}
		return isCreationTask ? "isCreationTask" : "isModifyTask";
	}
	
	@GetMapping("matCommonListAjax")
	public List<MatCommonVO> showMatCommonListAjax(){
		return materialService.showMatCommonList();
	}
	
	@PostMapping("matCommonListAjax")
	public List<MatCommonVO> searchMatCommonListAjax(String matName){
		return materialService.searchMatCommonList(matName);
	}
	
	@GetMapping("clientListAjax")
	public List<ClientVO> showClientListAjax(){
		return materialService.showClientList();
	}
	
	@PostMapping("clientListAjax")
	public List<ClientVO> searchClientListAjax(String clientName){
		return materialService.searchClientList(clientName);
	}
	
	@PostMapping("modifyMatOrderAjax")
	public List<String> modifyPrevMatOrderAjax(@RequestBody ModifyMatOrderDTO modifyMatOrderDTO) {
		List<String> list = materialService.modifyPrevMatOrder(modifyMatOrderDTO);
		
		return list;
	}
	
	@PostMapping("saveNewMatOrderAjax")
	public List<String> saveNewMatOrderAjax(@RequestBody NewMatOrderDTO newMatOrderDTO) {
		List<String> list = materialService.saveNewMatOrder(newMatOrderDTO);
		return list;
	}
	
	@DeleteMapping("matOrder/{matOrderCode}")
	public String removeMatOrderAjax(@PathVariable String matOrderCode) {
		return materialService.removeMatOrder(matOrderCode);
	}
	
	@PostMapping("searchInspectableMatOrderDetailsDataAjax")
	public List<InspectiveMatOrderVO> searchInspectableMatOrderDetailsDataAjax(String matOrderCode){
		return materialService.searchInspectableMatOrderDetailsData(matOrderCode);
	}
	
	@PostMapping("createNewInspectionAjax")
	public String createNewInspectionAjax(@RequestBody List<InspMatoHandlerVO> inspectiveMatOrderVOList) {
		return materialService.createNewInspectMatOrder(inspectiveMatOrderVOList);
	}
	
	@GetMapping("inspectedMatOrderListAjax")
	public List<InspectedMatVO> showInspectedMatDataList(){
		return materialService.showInspectedMatDataList();
	}
	@PostMapping("inspectedMatOrderListAjax")
	public List<InspectedMatVO> searchInspectedMatDataList(String matOrderName){
		return materialService.searchInspectedMatDataList(matOrderName);
	}
	
	@PostMapping("searchInspectedMatOrderDataAjax")
	public InspectedMatVO searchInspectedMatOrderDataAjax(String matInspectCode) {
		return materialService.searchInspectedMatOrderData(matInspectCode);
	}
	
	@PostMapping("updateInspectedDataAjax")
	public String updateInspectedDataAjax(@RequestBody List<InspectedMatVO> inspectedMatVOList) {
		return materialService.updateInspectedData(inspectedMatVOList);
	}
	
	@PostMapping("deleteInspectedDataAjax")
	public String deleteInspectedDataAjax(@RequestBody List<InspectedMatVO> inspectedMatVOList) {
		return materialService.deleteInspectedData(inspectedMatVOList);
	}
	
	@PostMapping("getStoredMatDataAjax")
	public Map<String, Boolean> checkStoredMatDataIsHoldAjax(@RequestBody List<InspectedMatVO> inspectedMatVOList) {
		return materialService.checkStoredMatDataIsHold(inspectedMatVOList);
	}
	
	@PostMapping("inspectedMatDataPerDateAjax")
	public List<InspectedMatVO> searchInspectedMatDataListPerDateAjax(String dateString){
		return materialService.searchInspectedMatDataPerDate(dateString);
	}
	
	@GetMapping("needSupplyMatListAjax")
	public List<NeedSupplyMatVO> searchNeedSupplyMatListAjax(String keyword){
		System.out.println("코드: " + keyword);
		return materialService.searchNeedSupplyMatList(keyword);
	}
}

