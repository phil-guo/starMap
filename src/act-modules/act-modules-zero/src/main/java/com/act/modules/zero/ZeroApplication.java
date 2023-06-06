package com.act.modules.zero;

import com.github.yulichang.injector.MPJSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.act.modules.zero.*", "com.act.core.*"})
@MapperScan({"com.act.modules.zero.internal.mapper"})
public class ZeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeroApplication.class, args);
    }

}
