package com.ymw.mybatisplus.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: ymingwang
 * @create: 2019-11-05 16:07
 **/
@Component("MySchedules")
public class MySchedules {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 每分钟执行一次
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void testSchedule1() {
        System.out.println(dateFormat.format(new Date()) + "一分钟到啦");
    }

}
