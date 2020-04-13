package com.evan.bs.service;

import com.evan.bs.dao.UsermsgDAO;
import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsermsgService {
    @Autowired
    UsermsgDAO usermsgDAO;


   /* public List<Usermsg> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "uid");
        return UsermsgDAO.findAll(sort);
    }*/


   public Result addorupdate(Usermsg usermsg){

       usermsg.setName(usermsg.getName());
       usermsg.setSex(usermsg.getSex());
       usermsg.setDate1(usermsg.getDate1());
       usermsg.setEmail(usermsg.getEmail());
       usermsg.setPhone(usermsg.getPhone());
       usermsg.setEducation(usermsg.getEducation());
       usermsg.setSchool(usermsg.getSchool());
       usermsg.setNatureofwork( usermsg.getNatureofwork());
       usermsg.setSalary(usermsg.getSalary());
       usermsg.setEducation(usermsg.getEducation());
       usermsg.setExperience(usermsg.getExperience());
       usermsg.setCredentials(usermsg.getCredentials());
       usermsg.setAdress(usermsg.getAdress());
       usermsg.setAdvantage(usermsg.getAdvantage());
       usermsg.setWorkexp1(usermsg.getWorkexp1());
       usermsg.setWorkexp2(usermsg.getWorkexp2());
       usermsg.setWorkexp3(usermsg.getWorkexp3());
       usermsgDAO.save(usermsg);
       User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       usermsg.setUsername( u.getUsername());

       return ResultFactory.buildSuccessResult(usermsg);
   }

    public boolean addOrUpdate(Usermsg usermsg) {
        try {
            usermsgDAO.save(usermsg);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}

