package com.mjc.user.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author:majunchao
 * @date:2022/7/4 23:23
 */
@Data
public class LoginRes {


    @ApiModelProperty("唯一标识")
    private String uuid;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("密码")
    private String password;

    private String code;



}
