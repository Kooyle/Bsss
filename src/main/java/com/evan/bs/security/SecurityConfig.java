package com.evan.bs.security;

import com.evan.bs.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    com.evan.bs.security.MyUserDetailService myUserDetailService;

    @Autowired
    UserDAO userDAO;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login","/index").permitAll()
                                .antMatchers("/admin/**").hasRole("admin")
                                .antMatchers("/person/**").hasRole("person")
                                .antMatchers("/company/**").hasRole("company")
                                .and()
                                .formLogin()
                                .usernameParameter("username")
                                .passwordParameter("password")
                                //登陆页面
                                .loginPage("/login")
                                //登陆表单提交请求
                                .loginProcessingUrl("/login")
                                //登陆失败跳转
                               // .failureUrl("/tologin?error=true")
                               .defaultSuccessUrl("/index")
                                .and()
                                .logout().logoutSuccessUrl("/login")
                                .and().headers().frameOptions().sameOrigin();
        //允许跨域
        http.csrf().disable();
    }
    //加密 BCrypt
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       该方法为使用自定义LoginAuthenticationProvider类继承DaoAuthenticationProvider,改写抛出异常时的提醒
        auth.authenticationProvider(new LoginAuthenticationProvider(myUserDetailService, userDAO));
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());

    }


}
