package com.act.startup.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2WebMvc
@SuppressWarnings("all")
public class Knife4jConfiguration {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        //指定使用Swagger2规范
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //描述字段支持Markdown语法
                        .title("act.startup 接口文档")
                        .description("# 星图管理")
                        .termsOfServiceUrl("https://doc.xiaominfo.com/")
//                        .contact("1228115857@qq.com")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("Startup")
                .select()
                //这里指定Controller扫描包路径
                .apis(basePackage("com.act.modules.zero.internal.controllers;com.act.modules.starmap.internal.controllers"))
                //加了RestController,ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).map(handlerPackage(basePackage)::apply).orElse(true);
    }

    private Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(";")) {
                assert input != null;
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private Optional<Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }
}