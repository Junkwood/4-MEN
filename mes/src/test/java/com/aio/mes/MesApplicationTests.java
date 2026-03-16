package com.aio.mes;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aio.mes.material.mapper.MaterialMapper;
import com.aio.mes.material.service.MatOrderVO;

@SpringBootTest
class MesApplicationTests {
	@Autowired
	MaterialMapper materialMapper;
	
	@Test
	void contextLoads() {
		List<MatOrderVO> list = materialMapper.showMatOrderList();
		for(int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i).getEmpCode());
		}
		
	}

}
