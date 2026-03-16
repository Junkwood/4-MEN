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

import com.aio.mes.mybatis.service.ManuPlanVO;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleConnection;

@MappedTypes(ManuPlanVO.class)
@MappedJdbcTypes(JdbcType.ARRAY)
@Slf4j
public class ManuPlanDetailArrayTypeHandler extends BaseTypeHandler<Object> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class);

		List<ManuPlanVO> objList = (List<ManuPlanVO>) parameter;
		
		Struct[] list = new Struct[objList.size()];
		for (int idx = 0; idx < objList.size(); idx++) {
			ManuPlanVO mObj = objList.get(idx);
			String regDate=null;
			String staDate=null;
			String endDate=null;
			Integer planQ=null;
			if(mObj.getRegistrationDate()!=null) {
				regDate = sdf.format(mObj.getRegistrationDate());
			}
			
			if(mObj.getRegistrationDate()!=null) {
				staDate = sdf.format(mObj.getStartDate());
			};
			if(mObj.getRegistrationDate()!=null) {
				endDate = sdf.format(mObj.getEndDate());
			};
			
			if(mObj.getPlanQuantity()!=null) {
				planQ=mObj.getPlanQuantity();
			};

			Object[] params = new Object[] { 
											mObj.getManuPlanCode(),
											mObj.getOrderCode(),
											mObj.getPlanName(),
											mObj.getEmpCode(), 
											regDate, 
											staDate, 
											endDate, 
											mObj.getNote(),
											mObj.getManuPlanDetailCode(), 
											mObj.getProdCode(), 
											planQ, 
											mObj.getPriority(),
											mObj.getProcessStatus(),
											mObj.getOrderDetailCode()
											};

			Struct str = conn.createStruct("PLAN_MAP", params);
			list[idx] = str;
		}
		;

		Array ary = conn.createOracleArray("PLAN_LIST", list);

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
