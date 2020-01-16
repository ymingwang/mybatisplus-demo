package com.ymw.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.ymw.mybatisplus.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig {

    /**
     * 性能分析拦截器，不建议生产使用 用来观察sql执行时长
     * 默认dev，staging环境开启
     * @Author ymingwang
     * @Date 2019/6/12 0012 18:51
     * @Param
     * @return
     */
    @Bean
    @Profile({"dev", "staging"})
    public PerformanceInterceptor performanceInterceptor(){
        //启用性能分页插件，sql是否格式化 默认false ，此处开启
        return new PerformanceInterceptor().setFormat(true);
    }

    /**
     * 分页插件
     * @Author ymingwang
     * @Date 2019/6/12 0012 19:07
     * @Param []
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
