package com.aio.mes.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.aio.mes.manager.service.ManagerVO;

public interface ManagerMapper {
	
	//bom관리   
	public List<ManagerVO> bomList(String prodCode , String entMemberCode);
	public List<ManagerVO> bomProdList(String entMemberCode);
	public int insertBom(ManagerVO bom);
	public int updateBom(ManagerVO bom);
	public int deleteBom(ManagerVO bom);
    
    // bom 모달
	public List<ManagerVO> showMatList();
	public List<ManagerVO> searchMatList(String matName);
    
    // BOM 코드 생성
	public String getBomCode(String prodCode);
	
	//자재관리
	public List<ManagerVO> materialList();
	public int insertMat(ManagerVO mat);
	public int updateMat(ManagerVO mat);
	public int deleteMat(ManagerVO mat);
	
	//거래처관리
	public List<ManagerVO> clientList();
	public int insertClient(ManagerVO client);
	public int updateClient(ManagerVO client);
	public int deleteClient(ManagerVO client);
	public List<ManagerVO> clientOptionList();
	
	//설비관리
	public List<ManagerVO> facList();
	public int insertFac(ManagerVO fac);
	public int updateFacBtn(ManagerVO fac);
	public int deleteFac(ManagerVO fac);
	public List<ManagerVO> facOptionList();
	
	
	//공정관리
	public List<ManagerVO> procList();
	public int insertProc(ManagerVO proc);
	public int updateProc(ManagerVO proc);
	public int deleteProc(ManagerVO proc);	
	public List<ManagerVO> procGetSearchList(String string, ManagerVO managerVO);
	public List<ManagerVO> procOptionList();
	
	public List<ManagerVO> matOptionList();
	
	//제품관리
	public List<ManagerVO> prodList();
	public int insertProd(ManagerVO prod);
	public int updateProd(ManagerVO prod);
	public int deleteProd(ManagerVO prod);
	
	
	//검색
	public List<ManagerVO> bomGetSearchList(String string, ManagerVO managerVO);
	public List<ManagerVO> clientGetSearchList(String string, ManagerVO managerVO);
	public List<ManagerVO> facGetSearchList(String string, ManagerVO managerVO);
	public List<ManagerVO> prodGetSearchList(String string, ManagerVO managerVO);
	public List<ManagerVO> materialGetSearchList(String string, ManagerVO managerVO);
	
	
	//번호증가 받아오기
	public String getClientCode();
	
	//검사기준관리 임시
	public List<ManagerVO> testList(String entMemberCode);
	public int insertTest(ManagerVO insertTest);
	public int updateTest(ManagerVO updateTest);
	public int deleteTest(ManagerVO deleteTest);
	public List<ManagerVO> testGetSearchList(String string, ManagerVO managerVO);
	
	
	
    void updateFac(ManagerVO managerVO);
    String selectFacImageFileName(String downloadLocation);
    
    
    public List<ManagerVO> searchProcList(String string, ManagerVO managerVO);
}
