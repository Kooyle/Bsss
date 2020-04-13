package com.evan.bs.security;


import com.evan.bs.dao.UserDAO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
前端session.SPRING_SECURITY_LAST_EXCEPTION.message参数通过getMessage的code传值,而不是后面的defaultMessage
 */


public class LoginAuthenticationProvider extends DaoAuthenticationProvider {


    private UserDAO userDAO;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public LoginAuthenticationProvider(UserDetailsService userDetailsService,UserDAO userDAO) {
        super();
        // 这个地方一定要对userDetailsService赋值，不然userDetailsService是null
        setUserDetailsService(userDetailsService);
        this.userDAO = userDAO;
    }



    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            this.logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        } else {
            String presentedPassword = authentication.getCredentials().toString();
            //判断密码 输入与数据比较
            if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
                this.logger.debug("Authentication failed: password does not match stored value");
                throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
            }else {

            }
        }
    }
}
