package com.roje.manager;

import com.roje.manager.configuration.WebProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Ro
 */
@EnableConfigurationProperties(value = {
        WebProperties.class
})
@EnableJpaAuditing
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        //设置默认表引擎
        System.setProperty("hibernate.dialect.storage_engine","innodb");
        SpringApplication.run(WebApplication.class, args);
    }
}


