package com.ymw.mybatisplus.component;/**
 * Created by ymingwang on 2019/10/29 0029.
 */

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description: 消费者监听
 *
 * @author: ymingwang
 * @create: 2019-10-29 11:44
 **/
@Component
public class ConsumerListener {

//    @KafkaListener(topics = "testTopic") // 需要开启zookeeper 和 Kafka 服务
    public void onMessage(String message) {
        System.out.println(message);
    }

}
