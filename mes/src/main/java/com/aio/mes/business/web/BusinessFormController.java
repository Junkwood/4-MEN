package com.aio.mes.business.web;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aio.mes.business.service.BusinessService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Controller
public class BusinessFormController {
   @Autowired
   BusinessService businessService;
   @Autowired
   private DataSource dataSource;
  
   
	
   @GetMapping("/business/add") 
   public String orderAdd(Model model) { 
	   String auto =businessService.getOrderNo();
	   String detailAuto = businessService.getOrderDetail();
	   model.addAttribute("auto",auto);
	   model.addAttribute("detailAuto", detailAuto);
	   return"orders/add"; 
  }
   @GetMapping("/order/downloadFile")
	public void downloadFile(String orderCode,HttpServletResponse response) throws JRException, IOException, SQLException{
		//InputStream jasperStream = getClass().getResourceAsStream("/jaspers/testA4.jasper");
		//JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	   Connection conn = dataSource.getConnection();
		
		InputStream stream = getClass().getResourceAsStream("/jaspers/Order.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(stream);
		//파라미터 맵
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orderCode", orderCode);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
		//response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=Order.pdf");
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	 
 
}
 

