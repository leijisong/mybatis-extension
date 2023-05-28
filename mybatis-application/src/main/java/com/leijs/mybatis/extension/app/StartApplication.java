package com.leijs.mybatis.extension.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author leijisong
 * @date 2023/5/28 下午7:27
 */
@SpringBootApplication(scanBasePackages = {"com.leijs.mybatis.extension"}, exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.leijs.mybatis.extension.app.dal.mapper"})
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
