package com.aio.mes;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aio.mes.mybatis.service.workObject;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class workApplicationTests {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test
	void insertdetail() {
		List<workObject> list = new ArrayList<workObject>();
		
		for(int i=1; i<3; i++) {
			workObject wobj=new workObject();
			wobj.setWorkName("a"+i);
			wobj.setEmpCode("emp001");
			wobj.setManuStartDate(new Date(i));
			wobj.setManuEndDate(new Date(i));
			wobj.setRegistrationDate(new Date(i));
			wobj.setPriority(i);
			wobj.setProcessStatus("PS1");
			wobj.setInstructQuantity(10);
			wobj.setProdCode("prod009");
			log.info(wobj.toString());

			list.add(wobj);
		}
		log.info(list.toString());
		//myBatisMapper.insertWorkDetailList(list);
	}

}
