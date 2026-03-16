package com.aio.mes.manager.mapper;

import java.util.List;

import com.aio.mes.manager.service.ProcVO;

public interface ProcMapper {
	
	
	//공정관리
		public List<ProcVO> procList();
		public int insertProc(ProcVO proc);
		public int updateProc(ProcVO proc);
		public int deleteProc(ProcVO proc);
		
		public List<ProcVO> procGetSearchList(String string, ProcVO managerVO);
}
