package com.hqz.hzuoj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: HQZ
 * @CreateTime: 2020/6/29 17:22
 * @Description: TODO
 */
@Component
@Slf4j
public class JudgeProducer {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSubmitResult(String queueName, Object message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }

    public void sendTestResult(String queueName, Object message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
