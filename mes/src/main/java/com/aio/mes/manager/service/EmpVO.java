package com.aio.mes.manager.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
   private String empCode;
   private String empName;
   private String tel;
   private String email;
   private String rank;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date birthDate;
   private String deptId;
   private String password;
}
