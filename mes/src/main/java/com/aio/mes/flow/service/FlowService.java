package com.aio.mes.flow.service;

import java.util.List;

import com.aio.mes.flow.web.FlowParameter;

public interface FlowService {
	//제품 조회
	public List<FlowVO> flowProdSearch(String prodName);
	//제품코드로 공정흐름도검색
	public List<FlowVO> flowSearch(String prodCode);
	//공정검색
	public List<FlowVO> procSearch(FlowVO flowVO);
	//등록
	public int flowAdd(FlowParameter flowParameter);
}
