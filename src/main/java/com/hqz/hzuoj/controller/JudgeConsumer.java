package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.constants.RabbitMqConstants;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: HQZ
 * @CreateTime: 2020/6/29 13:33
 * @Description: TODO
 */
@Component
@Slf4j
public class JudgeConsumer {

    @RabbitListener(queues = RabbitMqConstants.SEND_JUDGE_SUBMIT_QUEUE)
    public void submitLister(Message message, Channel channel) {
        try {
            //手动确认消息已经被消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.err.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqConstants.SEND_JUDGE_TEST_SUBMIT_QUEUE)
    public void testLister(Message message, Channel channel) {
        try {
            //手动确认消息已经被消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.err.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
