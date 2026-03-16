package com.aio.mes.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.aio.mes.business.service.BusinessDetailVO;
import com.aio.mes.manager.mapper.InspectMapper;
import com.aio.mes.manager.service.InspectService;
import com.aio.mes.manager.service.InspectVO;
import com.aio.mes.manager.service.ManagerVO;
import com.aio.mes.manager.service.SearchVO;
import com.aio.mes.security.service.LoginUserVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InspectServiceImpl implements InspectService {
    @Autowired
    InspectMapper inspectMapper;

    @Override
    public List<InspectVO> inspectList(String entMemberCode , String workInstructDetailCode) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUserVO loggedInUser = (LoginUserVO) authentication.getPrincipal();
        entMemberCode = loggedInUser.getEntMemberCode();
        return inspectMapper.inspectList(entMemberCode , workInstructDetailCode);
    }

    @Override
    public List<InspectVO> inspectListInfo(String workProgressCode)  {
        return inspectMapper.inspectListInfo(workProgressCode);
    }

    /*@Override
    public int insertInspect(List<InspectVO> inspects) {
        int count = 0;
        for (InspectVO inspect : inspects) {
            count += inspectMapper.insertInspect(inspect);
        }
        return count;
    }
*/
    public int updateInspect(List<InspectVO> inspects) {
        int count = 0;
        for (InspectVO inspect : inspects) {
            log.info(inspect.toString());
            if (inspect.getTestProcessCode() == null) {
            	String newTestProcessCode = inspectMapper.getNewTestProcessCode();
                //inspect.setTestProcessCode(newTestProcessCode);
                //count += inspectMapper.insertInspect(inspect);
            	inspect.setTestProcessCode(newTestProcessCode);
                count += inspectMapper.insertInspect(inspect);
                inspectMapper.updateInspect(inspect);
            } else {
                
                count += inspectMapper.updateInspect(inspect);
            }
        }
        return count;
    }

	/*
	 * @Override public int deleteInspect(List<InspectVO> inspects) { int count = 0;
	 * for (InspectVO inspect : inspects) { count +=
	 * inspectMapper.deleteInspect(inspect); } return count; }
	 */

    @Override
    public String getTestProc(String workInstructDetailCode , String prodName) {
        return inspectMapper.getTestProc(workInstructDetailCode , prodName);
    }

    @Override
    public int updateQuantity(String workProgressCode, Integer prodQuantity , Integer inputQuantity, Integer errorQuantity, Integer instructQuantity) {
        return inspectMapper.updateQuantity(workProgressCode, prodQuantity , inputQuantity , errorQuantity , instructQuantity);
    }

    @Override
    public List<InspectVO> showWorkProgressList() {
        return inspectMapper.showWorkProgressList();
    }

    @Override
    public List<InspectVO> searchWorkProgressList(SearchVO SearchVO) {
        return inspectMapper.searchWorkProgressList(SearchVO);
    }

    @Override
    public int updateStatus(List<InspectVO> inspects) {
        int count = 0;
        for (InspectVO inspect : inspects) {
            count += inspectMapper.updateStatus(inspect);
        }
        return count;
    }

    @Override
    public int updateNextProc(String workInstructDetailCode, Integer prodQuantity , int procNum) {
        return inspectMapper.updateNextProc(workInstructDetailCode, prodQuantity , procNum);
    }

    @Override
    public InspectVO getNextProc(String workInstructDetailCode, int currentProcNum) {
        return inspectMapper.getNextProc(workInstructDetailCode, currentProcNum);
    }

    @Override 
    public int updateProgress(String progress , String workInstructDetailCode, String workProgressCode) { 
        return inspectMapper.updateProgress( progress ,  workInstructDetailCode,  workProgressCode); 
    }

    @Override
    public boolean checkProgress(String workInstructDetailCode, String workProgressCode, int procNum) {
        int previousProgressCount = inspectMapper.countProgress(workInstructDetailCode, procNum);

        if (previousProgressCount > 0) {
            List<String> previousProgress = inspectMapper.checkProgress(workInstructDetailCode, procNum);
            if (!previousProgress.isEmpty()) {
                return false;
            }
        }

        inspectMapper.updateProgress( "Y" , workInstructDetailCode, workProgressCode);
        return true;
    }

    @Override
    public List<InspectVO> testFlowProd() {
        return inspectMapper.testFlowProd();
    }

    @Override
    public List<InspectVO> testFlowProc() {
        return inspectMapper.testFlowProc();
    }

    @Override
    public List<InspectVO> testFlowList(String procCode) {
        return inspectMapper.testFlowList(procCode);
    }
    @Override
	public List<InspectVO> testModalData() {
		return inspectMapper.testModalData();
	}

	@Override
	public int insertTestFlow(List<InspectVO> testFlows) {
		int count = 0;
		for (InspectVO testFlow : testFlows) {
			count += inspectMapper.insertTestFlow(testFlow);
		}
		return count;
	}

	@Override
	public int updateTestFlow(List<InspectVO> testFlows) {
		int count = 0;
		for (InspectVO testFlow : testFlows) {
			count += inspectMapper.updateTestFlow(testFlow);
		}
		return count;
	}

	@Override
	public int deleteTestFlow(List<InspectVO> testFlows) {
		int count = 0;
		for (InspectVO testFlow : testFlows) {
			count += inspectMapper.deleteTestFlow(testFlow);
		}
		return count;
	}
	
	@Override
	public List<ManagerVO> procOptionList() {
		return inspectMapper.procOptionList();
	}

	@Override
	  public List<InspectVO> inspectDetailList(InspectVO inspectVO) {
		return inspectMapper.inspectDetailList(inspectVO);
	 }
	
	 @Override
		public List<InspectVO> searchProcList(InspectVO inspectVO) throws Exception {
			return inspectMapper.searchProcList("test.getSearchList", inspectVO);
		}
    
}
