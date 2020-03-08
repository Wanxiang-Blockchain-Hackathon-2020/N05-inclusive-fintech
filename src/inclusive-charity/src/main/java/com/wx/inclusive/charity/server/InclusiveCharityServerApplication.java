package com.wx.inclusive.charity.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by ly on 10/24/18
 * @author wxuser
 */
@SpringBootApplication(scanBasePackages = "com.wx.inclusive.charity.server",exclude={DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = false)
@MapperScan(basePackages = "com.wx.inclusive.charity.server.mapper")
public class InclusiveCharityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InclusiveCharityServerApplication.class,args);
    }
}
