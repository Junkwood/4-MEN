package com.aio.mes.business.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aio.mes.business.service.BusinessDetailVO;
import com.aio.mes.business.service.BusinessService;
import com.aio.mes.business.service.BusinessVO;
import com.aio.mes.business.service.ClientVO;
import com.aio.mes.business.service.GoodsVO;
import com.aio.mes.business.service.OrderParmeter;
import com.aio.mes.business.service.orderSimpleVO;
import com.aio.mes.security.service.LoginUserVO;
/**
 * 주문관리 
 * @author 신현욱
 * 2024-05-22 
 */
@RestController
public class BusinessController {
   @Autowired
   BusinessService businessService;
	 
  //업체조회
  @GetMapping("/clientAjax")
  public List<ClientVO> client(String entMemberCode){
 	 return businessService.clientList();
  }
  //상품조회
  @GetMapping("/goodsListAjax")
  public List<GoodsVO> goods(@RequestParam(required = false, defaultValue = "") String entMemberCode,
                            @RequestParam(required = false, defaultValue = "") String prodName){
	  return businessService.goodsList(entMemberCode, prodName);
  }
  //주문 간단 조회
  @GetMapping("/simpleOrder")
  public List<orderSimpleVO> simple(Model model, BusinessVO businessVo){
	  List<orderSimpleVO> list= businessService.orderSimpleList(businessVo);
	  return list;
  }
  //주문 불러오기
    @GetMapping("orderCodeList")
    public List<BusinessVO> orderCall(@RequestParam(required = false, defaultValue = "") String orderCode){
    	List<BusinessVO> list=businessService.orderCall(orderCode);
    
    	return list;
    }
  //주문 상세 불러오기
    @GetMapping("orderDetailCodeList")
    public List<BusinessDetailVO> orderDetailCall(@RequestParam(required = false, defaultValue = "") String orderCode){
    	List<BusinessDetailVO> list=businessService.orderDetailCall(orderCode);
    	return list;
    }
  //등록 및 수정하기위한 유효성검사
    @GetMapping("/orderCheck")
    public int orderAddorUpdate(@RequestParam(required = false, defaultValue = "") String orderCode,
    		                    @RequestParam(required = false, defaultValue = "") String entMemberCode) {
    	int check = businessService.orderCheck(orderCode, entMemberCode);
    	return check;
    }
    //주문등록
    @PostMapping("/orderAdd")
    @ResponseBody
    public String addOrder(@RequestBody OrderParmeter orderParam){
    	
    	int result = businessService.insertOrder(orderParam);
    	if(result > 0) {
    		return "success";
    	}else {
    		return "fail";
    	}
    	
    }
    //주문수정
    @PostMapping("/orderUpdate")
    public String modifyOrder(@RequestBody OrderParmeter orderparam) {
       int result = businessService.modifyInsert(orderparam);
       
       if(result > 0) {
    	   return "success";
       }else {
    	   return "fail";
       }
    }
    @DeleteMapping("/order/{orderCode}")
    public String DeleteOrder(@PathVariable String orderCode) {
    	int result = businessService.orderDelete(orderCode);
    	
    	if(result > 0) {
    		return "success";
    	}else {
    		return "fail";
    	}
    } 
    //주문 간단 조회(생산계획모달용)
    @GetMapping("/orderManuModal")
    public List<orderSimpleVO> orderManuModal(Model model, BusinessVO businessVo){
    	List<orderSimpleVO> list= businessService.orderManuModal(businessVo);
    	return list;
    }
}
 

