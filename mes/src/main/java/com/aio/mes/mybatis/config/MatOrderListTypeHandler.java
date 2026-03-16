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

import com.aio.mes.mybatis.service.MatOrderHandlerVO;

import oracle.jdbc.OracleConnection;

@MappedTypes(MatOrderHandlerVO.class)
@MappedJdbcTypes(JdbcType.ARRAY)
public class MatOrderListTypeHandler extends BaseTypeHandler<Object>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class);

		List<MatOrderHandlerVO> objList = (List<MatOrderHandlerVO>) parameter;

		Struct[] list = new Struct[objList.size()];
		for (int idx = 0; idx < objList.size(); idx++) {
			MatOrderHandlerVO mObj = objList.get(idx);

			String orderDate = sdf.format(mObj.getOrderDate());
			
			System.out.println(orderDate);
			
			Object[] params = new Object[] { 
											mObj.getMatOrderCode(),
											mObj.getOrderName(),
											orderDate,
											mObj.getEmpCode(),
											mObj.getEmpName(),
											mObj.getOrderStatus()
											};

			Struct str = conn.createStruct("MATO_MAP", params);
			list[idx] = str;
		}
		;

		Array ary = conn.createOracleArray("MATO_LIST", list);

		ps.setArray(i, ary);

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
