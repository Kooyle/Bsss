package com.evan.bs.controller;

import com.evan.bs.pojo.User;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.io.Console;

@Controller
public class LoginController {

    @Autowired
    UserService userService;



    @RequestMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user){

        return userService.register(user);
    }
 /*   @CrossOrigin
    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String perms = user.getPerms();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        user.setPerms(perms);

        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }*/

}
