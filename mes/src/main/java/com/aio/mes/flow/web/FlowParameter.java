package com.aio.mes.flow.web;

import java.util.List;

import com.aio.mes.flow.service.DeleteFlowVO;
import com.aio.mes.flow.service.FlowVO;
import com.aio.mes.flow.service.ModifyFlowVO;

import lombok.Data;

@Data
public class FlowParameter {
  private List<FlowVO> add;
  private List<ModifyFlowVO> modify;
  private List<DeleteFlowVO> drop;
}
