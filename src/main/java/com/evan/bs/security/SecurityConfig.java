package com.evan.bs.security;

import com.evan.bs.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.FailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    com.evan.bs.security.MyUserDetailService myUserDetailService;

    @Autowired
    UserDAO userDAO;
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHandler authenticationFailHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login","/adminlogin").permitAll()
                              .antMatchers("/admin/**").hasRole("admin")
                               .antMatchers("/company/**").hasRole("company")
                               .antMatchers("/person/**").hasRole("person")
                                .and()
                                .formLogin()
//                                .loginProcessingUrl("/api/login")
//                                .usernameParameter("username")
//                                .passwordParameter("password")
                                //登陆页面
//                                .loginPage("/api/login")
                                //登陆表单提交请求

                                //登陆失败跳转
//                                .successHandler(authenticationSuccessHandler)
//                                .failureHandler(authenticationFailHandler)
                               // .failureUrl("/tologin?error=true")
                                .and()
//                                .logout().logoutSuccessUrl("/api/login")
//                                .and()
                                .headers().frameOptions().sameOrigin();
        http.addFilterAt(customAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
        //允许跨域
        http.cors();
        http.csrf().disable();
    }
    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler());
        filter.setAuthenticationFailureHandler(new MyAuthenticationFailHandler());
        filter.setFilterProcessesUrl("/api/login");

        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
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
