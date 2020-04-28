package com.evan.bs.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.util.Date;

public interface ShowmagDAO {


     Integer getrid();

     Integer getcid();

     Date getcreatedate();

     String getjob();

     String getcomsalary();

     String getcomexperience();

     String getcomeducation();

     String getcomnatureofwork();

     String getdetails();

     String getworkrequire();

     String getusername();

     String getcomname();

     java.sql.Date getcomdate();

     String getcomemail();

     String getcomphone();

     String getfinance();

     String getindustry();

     String getscale();

     String getcomadress();

     String getintroduction();

}
