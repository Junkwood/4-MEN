package com.aio.mes.manager.service;

import java.util.List;

import com.aio.mes.business.service.BusinessDetailVO;

public interface InspectService{
    
	public List<InspectVO> inspectList(String entMemberCode, String workInstructDetailCode);
    public List<InspectVO> inspectListInfo(String workProgressCode);
    //public int insertInspect(List<InspectVO> inspects);
    public int updateInspect(List<InspectVO> inspects);
    //public int deleteInspect(List<InspectVO> inspects);
    public String getTestProc(String workInstructDetailCode, String prodName);
    public int updateQuantity(String workProgressCode, Integer prodQuantity, Integer inputQuantity, Integer errorQuantity, Integer instructQuantity);
    public int updateStatus(List<InspectVO> inspects);
    
    //모달
    public List<InspectVO> showWorkProgressList();
    public List<InspectVO> searchWorkProgressList(SearchVO searchVO);
   
    
    //다음공정
    public InspectVO getNextProc(String workInstructDetailCode, int currentProcNum);
    public int updateNextProc(String workInstructDetailCode, Integer prodQuantity, int procNum);
    public int updateProgress(String progress , String workInstructDetailCode, String workProgressCode);
    public boolean checkProgress(String workInstructDetailCode, String workProgressCode, int procNum);
    
    
    //검사공정 
    public List<InspectVO> testFlowProd();
    public List<InspectVO> testFlowProc();
    public List<InspectVO> testFlowList(String procCode);
    public List<InspectVO> testModalData();
    public int insertTestFlow(List<InspectVO> testFlows);
	public int updateTestFlow(List<InspectVO> testFlows);
	public int deleteTestFlow(List<InspectVO> testFlows);
	
	public List<ManagerVO> procOptionList();
	
	public List<InspectVO> inspectDetailList(InspectVO inspectVO);
	
	public List<InspectVO> searchProcList(InspectVO inspectVO) throws Exception;
	
	
}
