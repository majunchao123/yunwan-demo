package com.mjc.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Description: 描述信息
 *
 * @date:2022/6/30 10:08
 * @author:白白白
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //配置Swagger的docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "pro");
        //通过environment.acceptsProfiles 显示是否处于自己设定的环境中
        boolean b = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //设置是否启动Swagger
                .enable(b)
                .select()
                //basePackage:指定要扫描的包
                //any():扫描全部的包
                //withMethodAnnotation  扫描方法上的注解
                //withClassAnnotation  扫描类上的注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //paths  过滤地址
                //.paths(PathSelectors.ant("/controller/**"))
                .build();
    }



    //分配任务
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("mjc");
    }



    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("ty");
    }


    //配置swagger信息 = apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("小马", "www.http", "294136893@qq.com");

        return new ApiInfo("小马的学习日记",
                        "Api Documentation",
                        "1.0",
                        "urn:tos",
                        contact,
                        "Apache 2.0",
                        "http://www.apache.org/licenses/LICENSE-2.0",
                        new ArrayList()
        );
    }
}
