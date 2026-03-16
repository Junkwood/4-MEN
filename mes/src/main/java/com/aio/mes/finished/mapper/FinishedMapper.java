package com.aio.mes.finished.mapper;

import java.util.List;

import com.aio.mes.finished.service.FinishedVO;

public interface FinishedMapper {
    //입고가능재고 파악
	public List<FinishedVO> storePossible(FinishedVO finishedVO);
     //lot번호 자동증가
     public String autoLot();
    //입고된목록출력
     public List<FinishedVO> alreadyFinished(String lot,String prodName);
     //?     
     public int modifyCheck (FinishedVO finishedVO);
     //등록
     public int addFinished (FinishedVO finishedVO);
     //수정
     public int updateFinished(FinishedVO finishedVO);
     //삭제
     public int deleteFinished(FinishedVO finishedVO);
    //삭제할때 출고할 품목이 있는지 체크하기
     public int dispatchCheck(FinishedVO finishedVO);
   //완제품 입고 조회
     public List<FinishedVO> finishedList(FinishedVO finishedVO);
}
