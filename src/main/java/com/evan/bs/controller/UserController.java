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




    /*@CrossOrigin(allowCredentials ="true")
    @PostMapping("api/usermsg")
    @ResponseBody*/
    /*public Result addOrUpdateMsg(@RequestBody Usermsg usermsg) {
        if(usermsgService.addOrUpdate(usermsg)) {
            return ResultFactory.buildSuccessResult("修改成功");
        }
        return ResultFactory.buildFailResult("参数错误，修改失败");
      }*/
    @CrossOrigin(allowCredentials ="true")
    @RequestMapping("api/usermsg")
    @ResponseBody
     public Result addOrUpdate(@RequestBody Usermsg usermsg) {

        return usermsgService.addorupdate(usermsg);

    }

}
