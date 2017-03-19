package com.example.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties加载properties文件内的配置
 * prefix属性指定properties的配置前缀
 *
 * Created by Richard on 2017/3/19.
 */
@Component
@PropertySource("classpath:config/author.properties")
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AuthorSettings{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
