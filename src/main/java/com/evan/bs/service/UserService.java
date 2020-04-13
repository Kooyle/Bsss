package com.evan.bs.service;

import com.evan.bs.dao.UserDAO;
import com.evan.bs.pojo.User;
import com.evan.bs.result.ResultFactory;
import com.evan.bs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

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
            return ResultFactory.buildSuccessResult(user);
        }


    }



}
