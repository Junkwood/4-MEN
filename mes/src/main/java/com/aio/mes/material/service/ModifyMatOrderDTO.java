package com.aio.mes.material.service;

import java.util.List;

import com.aio.mes.mybatis.service.MatOrderDetailHandlerVO;
import com.aio.mes.mybatis.service.MatOrderHandlerVO;

import lombok.Data;

@Data
public class ModifyMatOrderDTO {
	private List<MatOrderHandlerVO> matOrderRows;
	private List<MatOrderDetailHandlerVO> createdRows;
	private List<MatOrderDetailHandlerVO> deletedRows;
	private List<MatOrderDetailHandlerVO> updatedRows;
}
