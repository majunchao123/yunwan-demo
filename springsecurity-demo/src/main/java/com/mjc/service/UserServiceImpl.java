package com.mjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author:majunchao
 * @date:2022/7/5 10:31
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;


    /**
     * 自定义用户登录逻辑
     * @param phone
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println("执行自定义执行逻辑");


        //1.查询数据库中username
        if (!"131".equals(phone)){
            throw new UsernameNotFoundException("手机号不存在");
        }
        //2.判断密码是否正确
        String encode = passwordEncoder.encode("123456");
        //3.返回用户对象
        return new User("131",encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));





    }
}
