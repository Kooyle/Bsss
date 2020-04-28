package com.evan.bs.controller;


import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.service.UserService;
import com.evan.bs.service.UsermsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class UserController {
    @Autowired
    UsermsgService usermsgService;

    @Autowired
    UserService userService;







    @RequestMapping("api/usermsg")
    @ResponseBody
     public Result addOrUpdate(@RequestBody Usermsg usermsg) {
        //获取当前的用户的username
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usermsg.setUsername( u.getUsername());
        return usermsgService.addorupdate(usermsg);

    }



    @RequestMapping("api/loadusermsg")
    @ResponseBody
     public Result add() {


        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String keywords = u.getUsername();
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(usermsgService.list());
        } else {
            return ResultFactory.buildSuccessResult(usermsgService.Search(keywords));
        }

    }

    @RequestMapping("api/searchpersonmsg")
    @ResponseBody
    public Result searchpersonmsg(@RequestBody Usermsg usermsg){

        return ResultFactory.buildSuccessResult(usermsgService.searchpersonmsg(usermsg));
    }

    @RequestMapping("api/searchuid")
    @ResponseBody
    public Result searchuid(@RequestBody Usermsg usermsg){

        return ResultFactory.buildSuccessResult(usermsgService.searchuid(usermsg));
    }

    @RequestMapping("api/editusermsg")
    @ResponseBody
    public Result editusermsg(@RequestBody Usermsg usermsg){

        return ResultFactory.buildSuccessResult(usermsgService.edituser(usermsg));
    }


    @RequestMapping("api/delectuid")
    @ResponseBody
    public void delcid(@RequestBody Usermsg usermsg) throws Exception{


        usermsgService.delectuid(usermsg);
    }

    @RequestMapping("api/repassword")
    @ResponseBody
    public Result repassword(@RequestBody com.evan.bs.pojo.User userinfo){

        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userinfo.setUsername( u.getUsername());

        return ResultFactory.buildSuccessResult(userService.repassword(userinfo));
    }


    @RequestMapping("api/allrepassword")
    @ResponseBody
    public Result allrepassword(@RequestBody com.evan.bs.pojo.User userinfo){


        return ResultFactory.buildSuccessResult(userService.allrepassword(userinfo));
    }



}
