package com.evan.bs.service;

import com.evan.bs.dao.ComusermsgDAO;
import com.evan.bs.dao.UserDAO;
import com.evan.bs.dao.UsermsgDAO;
import com.evan.bs.pojo.Comusermsg;
import com.evan.bs.pojo.User;
import com.evan.bs.pojo.Usermsg;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    UsermsgDAO usermsgDAO;

    @Autowired
    ComusermsgDAO comusermsgDAO;

    public Result register(User user){

        if(userDAO.findByUsername(user.getUsername())!=null){
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }
        else {
            user.setUsername(user.getUsername());
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setPerms(user.getPerms());
            userDAO.save(user);
            if(user.getPerms().equals("person")){
                Usermsg usermsg = new Usermsg();
                usermsg.setUsername(user.getUsername());
                usermsgDAO.save(usermsg);
            }
            else{
                Comusermsg comusermsg = new Comusermsg();
                comusermsg.setUsername(user.getUsername());
                comusermsgDAO.save(comusermsg);
            }

            return ResultFactory.buildSuccessResult(user);
        }

    }
    public Result repassword(User userinfo){

        User usermsg = userDAO.findByUsername(userinfo.getUsername());
        if (usermsg != null){
            userinfo.setId(usermsg.getId());
            userinfo.setPerms(usermsg.getPerms());
            userinfo.setPassword(new BCryptPasswordEncoder().encode(userinfo.getPassword()));
            userDAO.save(userinfo);
        }

        return ResultFactory.buildSuccessResult(userinfo);
    }

    public Result allrepassword(User userinfo){

        User usermsg = userDAO.findByUsername(userinfo.getUsername());
        if (usermsg != null){
            userinfo.setId(usermsg.getId());
            userinfo.setPerms(usermsg.getPerms());
            userinfo.setPassword(new BCryptPasswordEncoder().encode("123456789"));
            userDAO.save(userinfo);
        }

        return ResultFactory.buildSuccessResult(userinfo);
    }






}
