package com.aio.mes.mybatis.config;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.aio.mes.mybatis.service.InspUpdateMatoHandlerVO;

import oracle.jdbc.OracleConnection;

@MappedTypes(InspUpdateMatoHandlerVO.class)
@MappedJdbcTypes(JdbcType.ARRAY)
public class InspUpdateMatoListTypeHandler extends BaseTypeHandler<Object>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class);

		List<InspUpdateMatoHandlerVO> objList = (List<InspUpdateMatoHandlerVO>) parameter;

		Struct[] list = new Struct[objList.size()];
		for (int idx = 0; idx < objList.size(); idx++) {
			InspUpdateMatoHandlerVO iObj = objList.get(idx);

			Object[] params = new Object[] {
											iObj.getMatInspectCode(),
											iObj.getInspectQuantity(),
											iObj.getErrorQuantity(),
											iObj.getNote(),
											iObj.getEmpCode(),
											iObj.getEmpName()
			};

			Struct str = conn.createStruct("INSP_UPDATE_MATO_MAP", params);
			list[idx] = str;
		}
		;

		Array ary = conn.createOracleArray("INSP_UPDATE_MATO_LIST", list);

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
