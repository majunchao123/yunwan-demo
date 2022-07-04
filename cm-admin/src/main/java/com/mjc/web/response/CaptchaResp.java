package com.mjc.web.response;

import lombok.Data;

/**
 * @author:majunchao
 * @date:2022/7/4 21:59
 */
@Data
public class CaptchaResp {
    private Boolean captchaOnOff = true;
    private String uuid;
    private String img;
}
