	package com.aio.mes.mybatis.config;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.aio.mes.mybatis.service.workObject;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleConnection;

@MappedTypes(workObject.class)
@MappedJdbcTypes(JdbcType.ARRAY)
@Slf4j
public class WorkInstructDetailArrayTypeHandler extends BaseTypeHandler<Object> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class);

		List<workObject> objList = (List<workObject>) parameter;
		
		Struct[] list = new Struct[objList.size()];
		for (int idx = 0; idx < objList.size(); idx++) {
			workObject wObj = objList.get(idx);
			String regDate=null;
			String staDate=null;
			String endDate=null;
			Integer holdQ=0;
			if(wObj.getRegistrationDate()!=null) {
				regDate = sdf.format(wObj.getRegistrationDate());
			}
			
			if(wObj.getRegistrationDate()!=null) {
				staDate = sdf.format(wObj.getManuStartDate());
			};
			if(wObj.getRegistrationDate()!=null) {
				endDate = sdf.format(wObj.getManuEndDate());
			};
			
			if(wObj.getHoldQuantity()!=null) {
				holdQ=wObj.getHoldQuantity();
			};

			Object[] params = new Object[] { 
											wObj.getWorkInstructCode(),
											wObj.getManuPlanCode(),
											wObj.getWorkName(),
											wObj.getEmpCode(), 
											regDate, 
											staDate, 
											endDate, 
											wObj.getWorkInstructDetailCode(),
											wObj.getProdCode(), 
											wObj.getInstructQuantity(), 
											wObj.getPriority(), 
											wObj.getProcessStatus(),
											holdQ,
											wObj.getProgress(),
											wObj.getLot(),
											wObj.getManuPlanDetailCode()
											};

			Struct str = conn.createStruct("WORK_MAP", params);
			list[idx] = str;
		}
		;

		Array ary = conn.createOracleArray("WORK_LIST", list);

		ps.setArray(i, ary);

	}

	@Override
	public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	}

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
