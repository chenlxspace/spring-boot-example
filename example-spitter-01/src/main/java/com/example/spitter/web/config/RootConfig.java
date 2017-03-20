package com.example.spitter.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
//扫描com.example.spitter包及子包下所有Component，但除com.example.spitter.web包及其子包不扫描
@ComponentScan(basePackages = {"com.example.spitter"},
        excludeFilters = {
                @Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
        })
public class RootConfig {

    //定义包扫描过滤表达式
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("com\\.example\\.spitter\\.web"));
        }
    }
}
