package com.aio.mes.manager.service;

import java.util.List;

public interface ProcService {
	
	//공정관리
		public List<ProcVO> procList();
		public int insertProc(List<ProcVO> insertProc); //등록
		public int updateProc(List<ProcVO> updateProc); //수정
		public int deleteProc(List<ProcVO> deleteProc); //삭제
	
		public List<ProcVO> procGetSearchList(ProcVO managerVO) throws Exception;
}
