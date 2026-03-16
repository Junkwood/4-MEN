package com.aio.mes.manager.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.aio.mes.business.service.BusinessDetailVO;
import com.aio.mes.manager.service.InspectVO;
import com.aio.mes.manager.service.ManagerVO;
import com.aio.mes.manager.service.SearchVO;

public interface InspectMapper {
	//목록
    public List<InspectVO> inspectList(String entMemberCode, String workInstructDetailCode);
    public List<InspectVO> inspectListInfo(String workProgressCode);
    public List<InspectVO> showWorkProgressList();
    public List<InspectVO> searchWorkProgressList(SearchVO SearchVO);
    //등록, 수정
    public int insertInspect(InspectVO insertInspect);
    public int updateInspect(InspectVO updateInspect);
    public int updateNextProc(String workInstructDetailCode, Integer prodQuantity , int procNum);
    
    //다음 번호
    public String getNewTestProcessCode();
    public String getTestProc(String workInstructDetailCode , String prodName);
    
    //생산량 업데이트
    public int updateQuantity(String workProgressCode, Integer prodQuantity , Integer inputQuantity, Integer errorQuantity, Integer instructQuantity );
    //상태 업데이트
    public int updateStatus(InspectVO inspect);
    public int updateProgress(String progress , String workInstructDetailCode, String workProgressCode);
      
    //다음공정
    public InspectVO getNextProc(@Param("workInstructDetailCode") String workInstructDetailCode, @Param("currentProcNum") int currentProcNum);
    public List<String> checkProgress(@Param("workInstructDetailCode") String workInstructDetailCode, @Param("procNum") int procNum);
    public int countProgress(@Param("workInstructDetailCode") String workInstructDetailCode, @Param("procNum") int procNum);
    
    public List<InspectVO> testFlowProd();
    public List<InspectVO> testFlowProc();
    public List<InspectVO> testModalData();
    public List<InspectVO> testFlowList(String procCode);
    public int insertTestFlow(InspectVO testFlows);
	public int updateTestFlow(InspectVO testFlows);
	public int deleteTestFlow(InspectVO testFlows);
	
	public List<ManagerVO> procOptionList();
    
	public List<InspectVO> inspectDetailList(InspectVO inspectVO);
	
	public List<InspectVO> searchProcList(String string, InspectVO inspectVO);
}
