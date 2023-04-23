package com.test.muyu.config;

import com.test.muyu.filter.IpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IpFilterConfig {
    @Bean
    public IpFilter ipFilter(){
        return new IpFilter();
    }

    @Bean(name = "ipFilterConf")
    public FilterRegistrationBean ipFilterConfig(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(ipFilter());//注册自定义过滤器
        filterRegistrationBean.addUrlPatterns("/submit");
        filterRegistrationBean.setName("adminFilterConf");//设置过滤器名称
        return filterRegistrationBean;
    }
}
