package xin.cymall.common.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author zzl
 * @date 2019/8/13  10:11
 * @Des: rabbit发消息
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        amqpTemplate.convertAndSend("hello", context);
    }
}
