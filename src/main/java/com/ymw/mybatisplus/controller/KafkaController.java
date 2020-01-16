package com.ymw.mybatisplus.controller;/**
 * Created by ymingwang on 2019/10/29 0029.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: ymingwang
 * @create: 2019-10-29 11:41
 **/
//@RestController
//@Component
public class KafkaController {

//    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

//    @GetMapping("/message/send")
    public boolean send(@RequestParam String message) {
        kafkaTemplate.send("testTopic", message);
        return true;
    }
}
