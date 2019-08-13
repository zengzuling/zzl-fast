package xin.cymall.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zzl
 * @date 2019/8/13  9:45
 * @Des: rabbit mq配置
 */
@Configuration
public class RabbitConfig {
    public static final Logger log = LoggerFactory.getLogger(RabbitConfig.class);

    @Bean
    public Queue helloQueue() {
        return new Queue("hello",true);
    }
}
