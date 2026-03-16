package com.aio.mes.material.web;

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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Controller
public class MaterialController {
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/mat/matOrderPage")
	public String matOrderPage(Model model) {
		return "material/management";
	}	
	@GetMapping("/mat/matInspectPage")
	public String matInspectPage(Model model) {
		return "material/inspection";
	}
	@GetMapping("/mat/matOrderListPage")
	public String matOrderListPage(Model model) {
		return "material/search";
	}
	
	@GetMapping("/mat/downloadFile")
	public void downloadFile(String matOrderCode, HttpServletResponse response, Model model) throws JRException, IOException, SQLException{
		//InputStream jasperStream = getClass().getResourceAsStream("/jaspers/matList.jasper");
		//JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		Connection conn = dataSource.getConnection();
		
		InputStream stream = getClass().getResourceAsStream("/jaspers/matOrder.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(stream);
		
		//파라미터 맵
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("p_mat_order_code", matOrderCode);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
		response.setContentType("application/pdf");
		//response.setHeader("Content-Disposition", "attachment; filename= 자재발주서.pdf");
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	@GetMapping("/matList")
	public String matList(Model model) {
		return "material/matList";
	}
}
