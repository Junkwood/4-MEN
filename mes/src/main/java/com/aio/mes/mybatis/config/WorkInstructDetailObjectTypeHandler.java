package com.aio.mes.mybatis.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.text.SimpleDateFormat;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.aio.mes.mybatis.service.workObject;

@MappedTypes(workObject.class)
@MappedJdbcTypes(JdbcType.STRUCT)
public class WorkInstructDetailObjectTypeHandler extends BaseTypeHandler<Object> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		workObject wObj = (workObject) parameter;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regDate = sdf.format(wObj.getRegistrationDate());
		String staDate = sdf.format(wObj.getManuStartDate());
		String endDate = sdf.format(wObj.getManuEndDate());

		Object[] params = new Object[] {
										wObj.getWorkName(),
										wObj.getEmpCode(), 
										regDate, 
										staDate, 
										endDate, 
										wObj.getProdCode(), 
										wObj.getInstructQuantity(), 
										wObj.getPriority(), 
										wObj.getProcessStatus(),
										};

		Connection conn = ps.getConnection();
		Struct str = conn.createStruct("WORK_MAP", params);
		ps.setObject(i, str);
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
		return null;
	}

}
