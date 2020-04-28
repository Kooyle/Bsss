package com.evan.bs.dao;

import java.sql.Date;

public interface ShowinvitationDAO {

     // 个人 表
     Integer getuid();
     String getusername();
     Date getdate1();
     String getname();
     String getsex();
     String getemail();
     String getphone();
     String geteducation();
     String getschool();
     String getnatureofwork();
     String getsalary();
     String getexperience();
     String getcredentials();
     String  getadress();
     String getadvantage();
     String getworkexp1();
     String getworkexp2();
     String getworkexp3();
     // 邀请 表
     Integer getnid();
     Integer getcid();
     Integer getrid();
     String getinvitestate();
     String getinvitemsg();
     String getinviteresult();

     // 岗位表
     java.util.Date getcreatedate();

     String getjob();

     String getcomsalary();

     String getcomexperience();

     String getcomeducation();

     String getcomnatureofwork();

     String getdetails();

     String getworkrequire();

     // 公司信息表

     String getcomname();

     java.sql.Date getcomdate();

     String getcomemail();

     String getcomphone();

     String getfinance();

     String getindustry();

     String getscale();

     String getcomadress();

     String getintroduction();

     // 投递表
     Integer getreid();

     String getresult();

     String getmsg();

     String getstate();

     String getresultstate();
}
