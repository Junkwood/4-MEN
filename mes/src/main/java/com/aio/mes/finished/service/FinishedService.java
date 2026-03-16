package com.aio.mes.finished.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface FinishedService {
	
	//입고가능재고
	public List<FinishedVO> storePossible(FinishedVO finishedVO);
	//lot번호 자동증가
	public String autoLot();
	//입고된목록출력
	public List<FinishedVO> alreadyFinished(String lot,String prodName);
	public int modifyCheck (String workInstructDetailCode, String prodCode);
	//등록
	public int addFinished (List<FinishedVO> finishedVO);
	//수정
	public int updateFinished (List<FinishedVO> finishedVO) throws SQLException;
	//삭제
	public int deleteFinished(List<FinishedVO> finishedVO);
	//완제품 입고 조회
    public List<FinishedVO> finishedList(FinishedVO finishedVO);
}
