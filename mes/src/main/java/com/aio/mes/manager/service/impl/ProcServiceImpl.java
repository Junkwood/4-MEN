package com.aio.mes.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aio.mes.manager.mapper.ProcMapper;
import com.aio.mes.manager.service.ProcService;
import com.aio.mes.manager.service.ProcVO;


@Service
public class ProcServiceImpl implements ProcService {
	@Autowired
	ProcMapper procMapper;
	
	
	// =========== 공정관리 ===========
		@Override
		public List<ProcVO> procList() {
			return procMapper.procList();
		}
		
		@Override
		public int insertProc(List<ProcVO> procs) {
			int count = 0;
			for (ProcVO proc : procs) {
				count += procMapper.insertProc(proc);
			}
			return count;
		}

		@Override
		public int updateProc(List<ProcVO> procs) {
			int count = 0;
			for (ProcVO proc : procs) {
				count += procMapper.updateProc(proc);
			}
			return count;
		}

		@Override
		public int deleteProc(List<ProcVO> procs) {
			int count = 0;
			for (ProcVO proc : procs) {
				count += procMapper.deleteProc(proc);
			}
			return count;
		}
		
		@Override
		public List<ProcVO> procGetSearchList(ProcVO managerVO) throws Exception {
			return procMapper.procGetSearchList("proc.getSearchList", managerVO);
		}
}
