package com.mjc.web;

import cn.hutool.db.Page;
import com.mjc.common.Constants;
import com.mjc.common.IdUtils;
import com.mjc.common.R;
import com.mjc.common.redis.RedisCache;
import com.mjc.config.CloudManageConfig;
import com.mjc.web.response.CaptchaResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author:majunchao
 * @date:2022/7/4 21:54
 */

@RestController
@Api(tags = "验证码")
public class CaptchaController {

    @Autowired
    RedisCache redisCache;

    @GetMapping("/captchaImage")
    @ApiOperation("生成验证码")
    public R getCode(){
        CaptchaResp captchaResp = new CaptchaResp();
        //检验验证码是否开启
        if (!captchaResp.getCaptchaOnOff()){
            return R.failed(captchaResp);
        }


        //生成uuid
        String uuid = IdUtils.simpleUUID();
        //生成唯一标识
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        // 生成验证码
        String Code = String.valueOf((int)((Math.random()*9+1)*1000));

        //把验证码读入redis中(时间为2分钟)
        redisCache.setCacheObject(verifyKey,Code,Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        captchaResp.setUuid(uuid);
        return R.success(captchaResp);
    }
}
