package com.hqz.hzuoj.config.rabbitmq;


import com.hqz.hzuoj.common.constants.RabbitMqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQConfig
 *
 * @author bobbi
 * @date 2019/03/16 21:59
 * @email 571002217@qq.com
 * @description
 */
@Configuration
@Slf4j
public class RabbitMqConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean
    public Queue judgeSubmitQueue() {
        return new Queue(RabbitMqConstants.SEND_JUDGE_SUBMIT_QUEUE);
    }

    @Bean
    public Queue judgeResultQueue() {
        return new Queue(RabbitMqConstants.RECEIVE_JUDGE_RESULT_QUEUE);
    }
    @Bean
    public Queue judgeTestSubmitQueue() {
        return new Queue(RabbitMqConstants.SEND_JUDGE_TEST_SUBMIT_QUEUE);
    }
    @Bean
    public Queue judgeTestResultQueue() {
        return new Queue(RabbitMqConstants.RECEIVE_JUDGE_TEST_RESULT_QUEUE);
    }


    @Bean
    public RabbitTemplate rabbitTemplate(){
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
            }
        });
        return rabbitTemplate;
    }
}
