package com.aio.mes.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aio.mes.main.mapper.MainMapper;
import com.aio.mes.main.service.MainService;
import com.aio.mes.main.service.MainVO;

@Service
public class MainServiceImpl implements MainService {
    @Autowired
    MainMapper mainMapper;
    
  //주문량 차트
    @Override
    public List<MainVO> orderChart() {
    	return mainMapper.orderChart();
    }
    //자재주문차트
    @Override
    public List<MainVO> matOrderChart() {
    	return mainMapper.matOrderChart();
    }
    //주문건 요일별차트 
    @Override
    public List<MainVO> orderQuantity() {
    	return mainMapper.orderLine();
    }
   //자재소모량 차트
    @Override
    public List<MainVO> matUsed() {
     	return mainMapper.matUsed();
    }
    //오늘주문건수
    @Override
    public int todayOrder() {
    	return mainMapper.todayOrder();
    }
   //오늘발주건수
    @Override
    public int todayMatRequired() {
    	return mainMapper.todayMatRequired();
    }
   //오늘생산건수
    @Override
    public int todayStore() {
    	return mainMapper.todayStore();
    }
   //오늘출고건수
    @Override
    public int todayRelease() {
    	return mainMapper.todayRelease();
    }
    
}
