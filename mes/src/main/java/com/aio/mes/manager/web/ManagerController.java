package com.aio.mes.manager.web;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aio.mes.manager.service.ManagerService;
import com.aio.mes.manager.service.ManagerVO;


/**
 * 관리자페이지 등록,수정,삭제 등 관리
 * @author 채주완
 * 2024-05-22
 */

@Controller
@RequestMapping("/admin/")
public class ManagerController {

	@Autowired
   ManagerService managerService;
   
   // ============ bom관리 ============ 
   @GetMapping("bomManager")
   public String bomProdList(Model model , String entMemberCode) {
       List<ManagerVO> bomProdList = managerService.bomProdList(entMemberCode);
       model.addAttribute("bomProdList", bomProdList);
       return "web/manager/bomManager";
   }

   @GetMapping("bomList")
   @ResponseBody
   public List<ManagerVO> bomList(@RequestParam String prodCode , String entMemberCode) {
	   							// 필수
	   System.out.println("bomList entCode  IMPl : " +entMemberCode);
       return managerService.bomList(prodCode , entMemberCode);
   }

   @GetMapping("getBomCode")
   @ResponseBody
   public String getBomCode(@RequestParam String prodCode) {
       return managerService.getBomCode(prodCode);
   }


   @PostMapping("bom")
   @ResponseBody
   public String insertBom(@RequestBody List<ManagerVO> boms) {
       int result = managerService.insertBom(boms);
       
       if (result > 0) {
    	   
    	   return "등록완료";
       }
       return "fail";
   }
   
   
   
   @PutMapping("bom")
   @ResponseBody
   public String updateBom(@RequestBody List<ManagerVO> boms) {
       int result = managerService.updateBom(boms);
       return result > 0 ? "수정완료" : "fail";
   }

   @DeleteMapping("bom")
   @ResponseBody
   public String deleteBom(@RequestBody List<ManagerVO> boms) {
       int result = managerService.deleteBom(boms);
       return result > 0 ? "삭제완료" : "fail";
   }
   
   // bom 모달창
    @GetMapping("matListAjax")
	@ResponseBody
	public List<ManagerVO> showMatListAjax(){
		return managerService.showMatList();
	}
	
	@PostMapping("matListAjax")
	@ResponseBody
	public List<ManagerVO> searchMatCommonListAjax(String matName){
		return managerService.searchMatList(matName);
	}
   
	
	
	
   // ============ 자재종류관리 ============ 
   @GetMapping("matManager")
   public String materialList(Model model) {
	   List<ManagerVO> materialList = managerService.materialList();
	   model.addAttribute("materialList" , materialList);
	   return "web/manager/matManager";
   }
   
	/*
	 * @GetMapping("getMatCode")
	 * 
	 * @ResponseBody public String getMatCode() { return
	 * managerService.getMatCode(); }
	 */
   
   @PostMapping("mat")
   @ResponseBody
   public String insertMat(@RequestBody List<ManagerVO> mats) {
       int result = managerService.insertMat(mats);
       
       if (result > 0) {
    	   
    	   return "등록완료";
       }
       return "fail";
   }
   
   @PutMapping("mat")
   @ResponseBody
   public String updateMat(@RequestBody List<ManagerVO> mats) {
       int result = managerService.updateMat(mats);
       
       if (result > 0) {
    	   return "수정완료";
       }
       return "fail";
   }
   
   
   @DeleteMapping("mat")
   @ResponseBody
   public String deleteMat(@RequestBody List<ManagerVO> mats) {
       int result = managerService.deleteMat(mats);
       
       if (result > 0) {
    	   return "삭제완료";
       }
       return "fail";
   }
   
   @GetMapping("materialGetSearchList")
   @ResponseBody
   public List<ManagerVO> materialGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
       ManagerVO managerVO = new ManagerVO();
       managerVO.setType(type);
       managerVO.setKeyword(keyword);
       return managerService.materialGetSearchList(managerVO);
   }
   
   // ============ 거래처관리 ============ 
   @GetMapping("clientManager")
   public String clientList(Model model) {
	   List<ManagerVO> clientList = managerService.clientList();
	   model.addAttribute("clientList" , clientList);
	   System.out.println(clientList);
	   return "web/manager/clientManager";
   }
   
   @PostMapping("client")
   @ResponseBody
   public String insertClient(@RequestBody List<ManagerVO> clients) {
       int result = managerService.insertClient(clients);
       
       if (result > 0) {
    	   
    	   return "등록완료";
       }
       return "fail";
   }
   
   @PutMapping("client")
   @ResponseBody
   public String updateClient(@RequestBody List<ManagerVO> clients) {
       int result = managerService.updateClient(clients);
       
       if (result > 0) {
    	   return "수정완료";
       }
       return "fail";
   }
   
   
   @DeleteMapping("client")
   @ResponseBody
   public String deleteClient(@RequestBody List<ManagerVO> clients) {
       int result = managerService.deleteClient(clients);
       
       if (result > 0) {
    	   return "삭제완료";
       }
       return "fail";
   }
   
   @GetMapping("clientGetSearchList")
   @ResponseBody
   public List<ManagerVO> clientGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
       ManagerVO managerVO = new ManagerVO();
       managerVO.setType(type);
       managerVO.setKeyword(keyword);
       return managerService.clientGetSearchList(managerVO);
   }
   
   // ============ 설비관리 ============ 
   @GetMapping("facManager")
   public String facList(Model model) {
	   List<ManagerVO> facList = managerService.facList();
	   model.addAttribute("facList" , facList);
	   return "web/manager/facManager";
   }
   
   
   @PostMapping("fac")
   @ResponseBody
   public String insertFac(@RequestBody List<ManagerVO> facs) {
       int result = managerService.insertFac(facs);
       
       if (result > 0) {
    	   
    	   return "등록완료";
       }
       return "fail";
   }
   
   @PutMapping("fac")
   @ResponseBody
   public String updateFacBtn(@RequestBody List<ManagerVO> facs) {
       int result = managerService.updateFacBtn(facs);
       
       if (result > 0) {
    	   return "수정완료";
       }
       return "fail";
   }
   
   
   @DeleteMapping("fac")
   @ResponseBody
   public String deleteFac(@RequestBody List<ManagerVO> facs) {
       int result = managerService.deleteFac(facs);
       
       if (result > 0) {
    	   return "삭제완료";
       }
       return "fail";
   }
   
   
   
  
   
   // ============ 제품관리 ============ 
   @GetMapping("prodManager")
   public String prodList(Model model) {
	   List<ManagerVO> prodList = managerService.prodList();
	   model.addAttribute("prodList" , prodList);
	   return "web/manager/prodManager";
   }
   
   @PostMapping("prod")
   @ResponseBody
   public String insertProd(@RequestBody List<ManagerVO> prods) {
       int result = managerService.insertProd(prods);
       
       if (result > 0) {
    	   
    	   return "등록완료";
       }
       return "fail";
   }
   
   @PutMapping("prod")
   @ResponseBody
   public String updateProd(@RequestBody List<ManagerVO> prods) {
       int result = managerService.updateProd(prods);
       return result > 0 ? "수정완료" : "fail";
   }

   @DeleteMapping("prod")
   @ResponseBody
   public String deleteProd(@RequestBody List<ManagerVO> prods) {
       int result = managerService.deleteProd(prods);
       return result > 0 ? "삭제완료" : "fail";
   }
   
   @GetMapping("/prodGetSearchList")
   @ResponseBody
   public List<ManagerVO> prodGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
       ManagerVO managerVO = new ManagerVO();
       managerVO.setType(type);
       managerVO.setKeyword(keyword);
       return managerService.prodGetSearchList(managerVO);
   }
   
   // ============ 검색 ============ 
   @GetMapping("bomGetSearchList")
   @ResponseBody
   public List<ManagerVO> bomGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
       ManagerVO managerVO = new ManagerVO();
       managerVO.setType(type);
       managerVO.setKeyword(keyword);
       return managerService.bomGetSearchList(managerVO);
   }
   
  
   
   @GetMapping("/facGetSearchList")
   @ResponseBody
   public List<ManagerVO> facGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
       ManagerVO managerVO = new ManagerVO();
       managerVO.setType(type);
       managerVO.setKeyword(keyword);
       return managerService.facGetSearchList(managerVO);
   }
   
   
   

   
   // ======================    공정관리   ==========================
   
   @GetMapping("procManager")
   public String procList(Model model) {
	   List<ManagerVO> procList = managerService.procList();
	   model.addAttribute("procList" , procList);
	   System.out.println(procList);
	   return "web/manager/procManager";
   }
   
   @PostMapping("proc")
   @ResponseBody
   public String insertProc(@RequestBody List<ManagerVO> procs) {
       int result = managerService.insertProc(procs);
       
       if (result > 0) {
    	   
    	   return "등록완료";
       }
       return "fail";
   }
   
   @PutMapping("proc")
   @ResponseBody
   public String updateProc(@RequestBody List<ManagerVO> procs) {
       int result = managerService.updateProc(procs);
       
       if (result > 0) {
    	   return "수정완료";
       }
       return "fail";
   }
   
   
   @DeleteMapping("proc")
   @ResponseBody
   public String deleteProc(@RequestBody List<ManagerVO> procs) {
       int result = managerService.deleteProc(procs);
       
       if (result > 0) {
    	   return "삭제완료";
       }
       return "fail";
   }
   
   @GetMapping("procGetSearchList")
   @ResponseBody
   public List<ManagerVO> procGetSearchList(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
       ManagerVO managerVO = new ManagerVO();
       managerVO.setType(type);
       managerVO.setKeyword(keyword);
       return managerService.procGetSearchList(managerVO);
   }
   
   @GetMapping("procOptionList")
   @ResponseBody
   public List<ManagerVO> procOptionList() {
       return managerService.procOptionList();
   }
   

   @GetMapping("matOptionList")
   @ResponseBody
   public List<ManagerVO> matOptionList() {
       return managerService.matOptionList();
   }
   
   @GetMapping("facOptionList")
   @ResponseBody
   public List<ManagerVO> facOptionList() {
       return managerService.facOptionList();
   }
   
   @GetMapping("clientOptionList")
   @ResponseBody
   public List<ManagerVO> clientOptionList() {
       return managerService.clientOptionList();
   }
   
// 파일 업로드 경로
   @Value("${upload.path.windows}")
   private String uploadPathWindows;

   @Value("${upload.path.linux}")
   private String uploadPathLinux;

   @PostMapping("uploadFacImage")
   public ResponseEntity<List<String>> uploadFacImage(@RequestParam("files") MultipartFile[] files, @RequestParam("facCode") String facCode) {
       try {
           List<String> fileUrls = managerService.uploadFacImages(files, facCode);
           return ResponseEntity.ok(fileUrls);
       } catch (IOException e) {
           e.printStackTrace();
           return ResponseEntity.status(500).build();
       }
   }

   @GetMapping("download")
   @ResponseBody
   public ResponseEntity<Object> downloadFacImage(@RequestParam String downloadLocation) {
       System.out.println("downloadLocation Controller : " + downloadLocation);
       return managerService.facImageDownloadFile(downloadLocation);
   }
   
   

}

