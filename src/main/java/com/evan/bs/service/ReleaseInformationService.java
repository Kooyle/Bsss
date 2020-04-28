package com.evan.bs.service;

import com.evan.bs.dao.CompanyworkDAO;
import com.evan.bs.dao.ComusermsgDAO;
import com.evan.bs.dao.ReleaseInformationDAO;
import com.evan.bs.dao.ShowmagDAO;
import com.evan.bs.pojo.Companywork;
import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.pojo.ReleaseInformation;
import com.evan.bs.pojo.showmsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseInformationService {

    @Autowired
    ReleaseInformationDAO releaseInformationDAO;

    @Autowired
    ComusermsgDAO comusermsgDAO;

    @Autowired
    CompanyworkDAO companyworkDAO;



    public Result releaseInformation(String s,ReleaseInformation releaseInformation){

        Comusermsg comusermsg = comusermsgDAO.findByUsername(s);
        releaseInformation.setCid(comusermsg.getCid());

        releaseInformationDAO.save(releaseInformation);

        return ResultFactory.buildSuccessResult(releaseInformation);
    }


    public List<ReleaseInformation> releaseInformationlist(String s)  {
        Comusermsg comusermsg = comusermsgDAO.findByUsername(s);
        int i = comusermsg.getCid();

        return releaseInformationDAO.findAllByCid(i);
    }

   public List<ShowmagDAO> showmsg(){
        return releaseInformationDAO.getshowmsg();
   }

    public List<Companywork> searchcompanymsg(Companywork companywork){

        return companyworkDAO.findAllByComexperienceAndComeducationAndFinanceAndScaleAndIndustryAndComsalaryAndComnatureofwork(companywork.getComexperience(),companywork.getComeducation(),companywork.getFinance(),companywork.getScale(),companywork.getIndustry(),companywork.getComsalary(),companywork.getComnatureofwork());
    }

    public Result sad(ReleaseInformation releaseInformation,Comusermsg comusermsg){

        String message = releaseInformation.getComexperience();
        return ResultFactory.buildFailResult(message);
    }
}
