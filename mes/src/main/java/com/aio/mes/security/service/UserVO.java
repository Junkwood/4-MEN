package com.aio.mes.security.service;

import lombok.Data;

@Data
public class UserVO {
     private String empCode;
     private String entMemberCode;
     private String password;
     private String empName;
     private String tel;
     private String email;
     private String rank;
     private String birthDate;
     private String deptId;
     
}
