package com.evan.bs.service;

import com.evan.bs.dao.ComusermsgDAO;
import com.evan.bs.dao.UsermsgDAO;
import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.pojo.User;
import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
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

       Usermsg oldusermsg = usermsgDAO.findByUsername(usermsg.getUsername());
       if (oldusermsg != null){
           usermsg.setUid(oldusermsg.getUid());
       }

       usermsgDAO.save(usermsg);

       return ResultFactory.buildSuccessResult(usermsg);
   }




    public List<Usermsg> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return usermsgDAO.findAll(sort);
    }

    public Usermsg Search(String keywords) {
        return usermsgDAO.findByUsername(keywords);
    }

    public List<Usermsg> showusermsg() {
       return usermsgDAO.findAll();
    }

    public List<Usermsg> searchpersonmsg(Usermsg usermsg){

       return usermsgDAO.findAllByExperienceAndEducationAndSalaryAndNatureofwork(usermsg.getExperience(),usermsg.getEducation(),usermsg.getSalary(),usermsg.getNatureofwork());
    }

    public Usermsg searchuid(Usermsg usermsg){

       return usermsgDAO.findByUid(usermsg.getUid());
    }

    public Result edituser(Usermsg usermsg){

       usermsgDAO.save(usermsg);
       return ResultFactory.buildSuccessResult(usermsg);
    }

    public Result delectuid(Usermsg usermsg){

        usermsgDAO.deleteAllByUid(usermsg.getUid());

        return ResultFactory.buildSuccessResult(usermsg);
    }

}

