package com.aio.mes.manager.mapper;

import java.util.List;

import com.aio.mes.manager.service.EmpVO;

public interface EmployeeMapper {
    public List<EmpVO> empList(EmpVO empVO);
    //등록
    public int empAdd(EmpVO empVO);
    //수정
    public int empModify(EmpVO empVO);
    //삭제
    public int empDelete(EmpVO empVO);
}
