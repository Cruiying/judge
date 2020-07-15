package com.hqz.hzuoj.controller;

import com.alibaba.fastjson.JSONObject;
import com.hqz.hzuoj.common.constants.RabbitMqConstants;
import com.hqz.hzuoj.service.JudgeDispatcherService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: HQZ
 * @CreateTime: 2020/6/29 13:33
 * @Description: TODO
 */
@Component
@Slf4j
public class JudgeConsumer {

    @Resource
    private JudgeDispatcherService judgeDispatcherService;

    /**
     * 监听用户提交
     * @param message
     * @param channel
     */
    @RabbitListener(queues = RabbitMqConstants.SEND_JUDGE_SUBMIT_QUEUE)
    public void submitLister(Message message, Channel channel) {
        try {
            //手动确认消息已经被消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
            judgeDispatcherService.RunningSubmit(jsonObject.getInteger("submitId"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听用户自测
     * @param message
     * @param channel
     */
    @RabbitListener(queues = RabbitMqConstants.SEND_JUDGE_TEST_SUBMIT_QUEUE)
    public void testLister(Message message, Channel channel) {
        try {
            //手动确认消息已经被消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
            judgeDispatcherService.RunningTest(jsonObject.getInteger("testId"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
