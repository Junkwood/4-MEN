package com.aio.mes.flow.mapper;

import java.util.List;

import com.aio.mes.flow.service.DeleteFlowVO;
import com.aio.mes.flow.service.FlowVO;
import com.aio.mes.flow.service.ModifyFlowVO;

public interface FlowMapper {
	//제품 조회
	public List<FlowVO> flowProdSearch(String prodName);
	//제품코드로 공정흐름도검색
	public List<FlowVO> flowSearch(String prodCode);
	//공정검색
	public List<FlowVO> procSearch(FlowVO flowVO);
	//등록
	public int flowAdd(FlowVO flowVO);
    //수정
	public int flowModify(ModifyFlowVO modifyFlowVO);
	//삭제
	public int flowDelete(DeleteFlowVO deleteFlowVO);
}
