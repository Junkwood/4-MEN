package com.aio.mes.manager.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;



public interface ManagerService {
	
	//bom관리
	public List<ManagerVO> bomList(String prodCode , String entMemberCode);
	public List<ManagerVO> bomProdList(String entMemberCode);
	public int insertBom(List<ManagerVO> insertBom); //등록
	public int updateBom(List<ManagerVO> updateBom); //수정
	public int deleteBom(List<ManagerVO> deleteBom); //삭제
	//bom 모달
	public List<ManagerVO> showMatList();
	public List<ManagerVO> searchMatList(String matName);
	public String getBomCode(String prodCode);
	
	//자재관리
	public List<ManagerVO> materialList();
	public int insertMat(List<ManagerVO> insertMat); //등록
	public int updateMat(List<ManagerVO> updateMat); //수정
	public int deleteMat(List<ManagerVO> deleteMat); //삭제
	public List<ManagerVO> matOptionList();
	//거래처관리
	public List<ManagerVO> clientList(); //목록
	public int insertClient(List<ManagerVO> insertClient); //등록
	public int updateClient(List<ManagerVO> updateClient); //수정
	public int deleteClient(List<ManagerVO> deleteClient); //삭제
	public List<ManagerVO> clientOptionList();
	
	//설비관리
	public List<ManagerVO> facList();
	public int insertFac(List<ManagerVO> insertFac); //등록
	public int updateFacBtn(List<ManagerVO> updateFac); //수정
	public int deleteFac(List<ManagerVO> deleteFac); //삭제
	public List<ManagerVO> facOptionList();
	
	
	//공정관리
	public List<ManagerVO> procList();
	public int insertProc(List<ManagerVO> insertProc); //등록
	public int updateProc(List<ManagerVO> updateProc); //수정
	public int deleteProc(List<ManagerVO> deleteProc); //삭제
	public List<ManagerVO> procGetSearchList(ManagerVO managerVO) throws Exception;
	public List<ManagerVO> procOptionList();
	
	
	//제품관리
	public List<ManagerVO> prodList();
	public int insertProd(List<ManagerVO> insertProd); //등록
	public int updateProd(List<ManagerVO> updateProd); //수정
	public int deleteProd(List<ManagerVO> deleteProd); //삭제
	
	
	//검색필터
	public List<ManagerVO> bomGetSearchList(ManagerVO managerVO) throws Exception;
	public List<ManagerVO> prodGetSearchList(ManagerVO managerVO) throws Exception;
	
	public List<ManagerVO> materialGetSearchList(ManagerVO managerVO) throws Exception;
	public List<ManagerVO> facGetSearchList(ManagerVO managerVO) throws Exception;
	public List<ManagerVO> clientGetSearchList(ManagerVO managerVO) throws Exception;
	
	public String getClientCode();
	
	//검사항목 임시
	public List<ManagerVO> testList(String entMemberCode);
	public int insertTest(List<ManagerVO> insertTest);
	public int updateTest(List<ManagerVO> updateTest);
	public int deleteTest(List<ManagerVO> deleteTest);
	public List<ManagerVO> testGetSearchList(ManagerVO managerVO) throws Exception;

	public ResponseEntity<Object> facImageDownloadFile(String downloadLocation);
	public  List<String> uploadFacImages(MultipartFile[] uploadFiles, String facCode) throws IOException;
	    //void updateFac(ManagerVO managerVO);
	    //String selectFacImageFileName(String downloadLocation);
	public List<ManagerVO> searchProcList(ManagerVO managerVO) throws Exception;
}
