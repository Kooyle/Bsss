package com.evan.bs.security;


import com.evan.bs.dao.UserDAO;
import com.evan.bs.pojo.User;
import com.evan.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    private UserDAO userDAO;

    public UserDetails loadUserByUsername(String username) throws AuthenticationException {

        //从数据库根据用户名获取用户信息
        User user = userDAO.findByUsername(username);
        //创建一个新的UserDetails对象,使用自己定义的实现类,以便实现扩展的session
        if (user == null){
            String message = "账号密码错误";
            throw new BadCredentialsException("帐号不存在，请重新输入");
        }



        //创建一个集合来存放权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getPerms()));
        //实例化UserDetails对象
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(), true, true, true, true, authorities);

    }


}
