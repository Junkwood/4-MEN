package com.aio.mes.material.service;

import java.util.List;

import com.aio.mes.mybatis.service.MatOrderDetailHandlerVO;
import com.aio.mes.mybatis.service.MatOrderHandlerVO;

import lombok.Data;

@Data
public class NewMatOrderDTO {
	private List<MatOrderHandlerVO> matOrderRows;
	private List<List<MatOrderDetailHandlerVO>> creativeMatOrderRows;
}
