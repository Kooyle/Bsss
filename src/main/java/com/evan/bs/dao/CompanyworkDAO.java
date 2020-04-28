package com.evan.bs.dao;

import com.evan.bs.pojo.Companywork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyworkDAO extends JpaRepository<Companywork,Integer> {

    List<Companywork> findAllByComexperienceAndComeducationAndFinanceAndScaleAndIndustryAndComsalaryAndComnatureofwork(String comexperience, String comeducation, String finance, String scale,String industry,String comsalary,String comnatureofwork);
}
