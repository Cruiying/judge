package com.hqz.hzuoj.controller;

import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.common.constants.RabbitMqConstants;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqConstants.SEND_JUDGE_TEST_SUBMIT_QUEUE)
    public void testLister(Message message, Channel channel) {
        try {
            //手动确认消息已经被消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
