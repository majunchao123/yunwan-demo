package com.mjc.user.service.impl;

import com.mjc.common.Constants;
import com.mjc.common.redis.RedisCache;
import com.mjc.user.mapper.UserMapper;
import com.mjc.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:majunchao
 * @date:2022/7/4 23:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisCache redisCache;

    @Autowired
    UserMapper userMapper;

    @Override
    public String loginByPhoneAndPassword(String phone, String password,String code, String uuid) throws Exception {
        //校验验证码
        String captchaKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(captchaKey);
        if (captcha==null){
            throw new Exception("验证码获取失败");
        }
        if (!StringUtils.equals(captcha,code)){
            throw new Exception("验证码错误");
        }
        //从数据库中取手机号  判断
        userMapper.selectUserDetailByPhone(phone);

        //1.是否存在

        //2.账号锁定

        //3.账号



        return null;
    }
}
