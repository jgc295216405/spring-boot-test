package com.example.demo.config;

import com.example.demo.Service.ServiceC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.bind.PropertiesConfigurationFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.PropertySourceFactory;

/**
 * Created by hzjiaoguangcai on 2017/8/17.
 */

@Configuration
//@ComponentScan({"com.example.demo.Service"})

@PropertySource(value = {"classpath:core-config.yml","application.properties"})

public class TestConfigBean {
//    @Bean
//    public static PropertiesPropertySource propertyConfigurer() {
//        return new PropertiesPropertySource();
//    }
    @Bean
//    @ConfigurationProperties(value = "classpath:common.properties")
    ServiceC getServiceC(@Value("${server.port}") int a,@Value("${spring.velocity.resourceLoaderPath}") String b){
        return new ServiceC(a);
    }


}
