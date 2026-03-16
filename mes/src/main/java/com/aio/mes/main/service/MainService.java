package com.aio.mes.main.service;

import java.util.List;

public interface MainService {
	//주문량 차트
	public List<MainVO> orderChart();
    //자재주문차트
   public List<MainVO> matOrderChart();
    //주문건 요일별차트 
   public List<MainVO> orderQuantity();
    //자재소모량 차트
   public List<MainVO> matUsed();
    //오늘주문건수
   public int todayOrder();
    //오늘발주건수
 	public int todayMatRequired();
 	//오늘생산건수
 	public int todayStore();
 	//오늘출고건수
 	public int todayRelease();
}
