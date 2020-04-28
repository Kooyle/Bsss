package com.evan.bs.security;

import com.evan.bs.dao.UserDAO;
import com.evan.bs.pojo.User;
import com.evan.bs.result.Result;
import com.evan.bs.result.ResultFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserDAO userDAO;
    public static final String RETURN_TYPE = "html";

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        Iterator iterator =  authentication.getAuthorities().iterator();
        String perms = iterator.next().toString();
        JSONObject user_jsonObject;
        if ("ROLE_person".equals(perms))
            user_jsonObject = new JSONObject(ResultFactory.buildSuccessPersonResult("登陆成功"));
        else if ("ROLE_company".equals(perms))
            user_jsonObject = new JSONObject(ResultFactory.buildSuccessCompanyResult("登陆成功"));
        else
            user_jsonObject = new JSONObject(ResultFactory.buildSuccessAdminResult("登陆成功"));
        response.getWriter().write(user_jsonObject.toString());

    }
}
