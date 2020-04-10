package com.evan.bs.controller;

import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.service.UsermsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class UserController {
    @Autowired
    UsermsgService usermsgService;

    @CrossOrigin(allowCredentials ="true")
    @PostMapping("api/usermsg")
    @ResponseBody
    /*public Result addOrUpdateMsg(@RequestBody Usermsg usermsg) {
        if(usermsgService.addOrUpdate(usermsg)) {
            return ResultFactory.buildSuccessResult("修改成功");
        }
        return ResultFactory.buildFailResult("参数错误，修改失败");
      }*/
     public Result usermsg(@RequestBody Usermsg usermsg) {
            String name = usermsg.getName();
            String sex = usermsg.getSex();
            Date date1 = usermsg.getDate1();
            String email = usermsg.getEmail();
            String phone = usermsg.getPhone();
            String education = usermsg.getEducation();
            String school = usermsg.getSchool();
            String natureofwork = usermsg.getNatureofwork();
            String salary = usermsg.getSalary();
            String experience = usermsg.getExperience();
            String credentials = usermsg.getCredentials();
            String adress = usermsg.getAdress();
            String advantage = usermsg.getAdvantage();
            String workexp1 = usermsg.getWorkexp1();
            String workexp2 = usermsg.getWorkexp2();
            String workexp3 = usermsg.getWorkexp3();

        name = HtmlUtils.htmlEscape(name);
            usermsg.setName(name);
            usermsg.setSex(sex);
            usermsg.setDate1(date1);
            usermsg.setEmail(email);
            usermsg.setPhone(phone);
            usermsg.setEducation(education);
            usermsg.setSchool(school);
            usermsg.setNatureofwork(natureofwork);
            usermsg.setSalary(salary);
            usermsg.setEducation(education);
            usermsg.setExperience(experience);
            usermsg.setCredentials(credentials);
            usermsg.setAdress(adress);
            usermsg.setAdvantage(advantage);
            usermsg.setWorkexp1(workexp1);
            usermsg.setWorkexp2(workexp2);
            usermsg.setWorkexp3(workexp3);

            usermsgService.add(usermsg);
            //*usermsgService.addOrUpdate(usermsg);*//*

     //*return ResultFactory.buildSuccessResult("修改成功");*//*
        return ResultFactory.buildSuccessResult(usermsg);

    }

}
