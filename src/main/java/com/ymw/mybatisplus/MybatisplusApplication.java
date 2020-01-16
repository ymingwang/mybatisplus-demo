package com.ymw.mybatisplus;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@EnableScheduling
@SpringBootApplication
//@MapperScan(basePackages = {"com.ymw.mybatisplus.mapper"})
@Controller
public class MybatisplusApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MybatisplusApplication.class, args);
        SpringApplication springApplication = new SpringApplication(MybatisplusApplication.class);
        // 禁用banner
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
        System.out.println("-启动成功-");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toIndex2")
    public String toIndex2() {
        return "index2";
    }
}
