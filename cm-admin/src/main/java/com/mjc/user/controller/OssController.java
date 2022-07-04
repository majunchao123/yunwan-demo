package com.mjc.user.controller;

import com.mjc.common.BaseController;
import com.mjc.common.R;
import com.mjc.user.request.LoginRes;
import com.mjc.user.response.LoginResp;
import com.mjc.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:majunchao
 * @date:2022/7/4 21:47
 */
@RestController
@Api(tags = "OSS登录")
@RequestMapping("/oss")
public class OssController extends BaseController {


    @Autowired
    UserService userService;


    @PostMapping("login")
    @ApiOperation("登录方法")
    public R<Object> login(@RequestBody LoginRes loginRes) {
        //生成令牌
        String token = null;
        try {
            token = userService.loginByPhoneAndPassword(loginRes.getPhone(), loginRes.getPassword(),loginRes.getCode(), loginRes.getUuid());
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed(e.getMessage());
        }
        LoginResp loginResp = new LoginResp();
        loginResp.setToken(token);
        return R.success(token);
    }


}
