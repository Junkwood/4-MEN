package com.aio.mes.flow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aio.mes.flow.mapper.FlowMapper;
import com.aio.mes.flow.service.DeleteFlowVO;
import com.aio.mes.flow.service.FlowService;
import com.aio.mes.flow.service.FlowVO;
import com.aio.mes.flow.service.ModifyFlowVO;
import com.aio.mes.flow.web.FlowParameter;

@Service
public class FlowServiceImpl implements FlowService{
    @Autowired
    FlowMapper flowMapper;
	
	//제품검색
	@Override
    public List<FlowVO> flowProdSearch(String prodName) {
    	return flowMapper.flowProdSearch(prodName);
    }
	//제품코드통해 공정흐름도 검색

	@Override
	public List<FlowVO> flowSearch(String prodCode) {
		return flowMapper.flowSearch(prodCode);
	}
	//공정검색
		public List<FlowVO> procSearch(FlowVO flowVO){
			return flowMapper.procSearch(flowVO);
		};
	//등록
	@Transactional
	@Override
	public int flowAdd(FlowParameter flowParameter) {
	int result = 0;
	List<FlowVO> flowAdd = flowParameter.getAdd();
	List<ModifyFlowVO> flowModify = flowParameter.getModify();
	List<DeleteFlowVO> flowDelete = flowParameter.getDrop();
	
	for(DeleteFlowVO flowDeletes : flowDelete) {
	   result += flowMapper.flowDelete(flowDeletes);	
	}
	for(ModifyFlowVO flowModifys : flowModify) {
		if(flowModifys.getNote()==null) {
			flowModifys.setNote("");
		}
		result += flowMapper.flowModify(flowModifys);
	}
	for(FlowVO flowAdds : flowAdd) {
		if(flowAdds.getNote() == null) {
			flowAdds.setNote("");
		}
		result += flowMapper.flowAdd(flowAdds);
	}
		
		return result;
	}
}
