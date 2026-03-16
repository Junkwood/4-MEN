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

import com.aio.mes.mybatis.service.MatOrderHandlerVO;

@MappedTypes(MatOrderHandlerVO.class)
@MappedJdbcTypes(JdbcType.STRUCT)
public class MatOrderObjectTypeHandler extends BaseTypeHandler<Object>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		MatOrderHandlerVO mObj = (MatOrderHandlerVO) parameter;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderDate = sdf.format(mObj.getOrderDate());
		
		Object[] params = new Object[] {
					mObj.getMatOrderCode(),
					mObj.getOrderName(),
					orderDate,
					mObj.getEmpCode(),
					mObj.getEmpName(),
					mObj.getOrderStatus()
							};
		
		Connection conn = ps.getConnection();
		Struct str = conn.createStruct("MATO_MAP", params);
		ps.setObject(i, str);
		
	}

	@Override
	public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
