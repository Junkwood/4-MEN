package com.aio.mes.manager.mapper;

import java.util.List;

import com.aio.mes.manager.service.SubCodeVO;

public interface SubCodeMapper {
    public List<SubCodeVO> mainCodeDisplay();
    
    public List<SubCodeVO> subCodeDisplay(String mainCode);
    
    public int subCodeAdd(SubCodeVO subCodeVO);

    public int subCodeModify(SubCodeVO subCodeVo);
    
    public int subCodeDelete(SubCodeVO subCodeVo);
}
