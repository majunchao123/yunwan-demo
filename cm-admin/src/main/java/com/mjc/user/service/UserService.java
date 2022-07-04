package com.mjc.user.service;

/**
 * @author:majunchao
 * @date:2022/7/4 23:27
 */
public interface UserService {



    String loginByPhoneAndPassword(String phone, String password, String code,String uuid) throws Exception;
}
