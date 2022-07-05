package com.mjc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author:majunchao
 *
 *
 * @date:2022/7/5 10:22
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登录
        http.formLogin()
                //自定义登录页面
                .loginPage("/login.html")
                //自定义登录逻辑
                .loginProcessingUrl("/login")
                //登陆成功后跳转的页面 必须是post方式
                .successForwardUrl("/toMain")
                //登陆失败跳转的页面 必须是post方式
                .failureForwardUrl("/toError")
                //自定义登陆用户名参数
                .usernameParameter("phone");
                //.passwordParameter();

        //授权
        http.authorizeRequests()

                //放行登录页面
                .antMatchers("/login.html").permitAll()
                //放行失败页面
                .antMatchers("/error.html").permitAll()
                .antMatchers("/image/**.*").permitAll()
                //所有请求都必须被认证（登录）
                .anyRequest().authenticated();
        //关闭防护
        http.csrf().disable();

    }

    //构造 PasswordEncoder
    @Bean
    public PasswordEncoder pw(){
        return new BCryptPasswordEncoder();
    }
}
