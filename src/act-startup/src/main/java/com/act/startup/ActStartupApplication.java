package com.act.startup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.act.modules.starmap.*","com.act.modules.zero.*", "com.act.core.*", "com.act.startup.*"})
@MapperScan({"com.act.modules.zero.internal.mapper"})
public class ActStartupApplication {    public static void main(String[] args) {
        SpringApplication.run(ActStartupApplication.class, args);
    }}
