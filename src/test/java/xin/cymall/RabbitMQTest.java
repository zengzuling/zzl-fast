package xin.cymall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.cymall.common.mq.sender.Sender;
import xin.cymall.common.utils.RedisUtil;

/**
 * @Author zzl
 * @date 2019/8/13  10:25
 * @Des:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    private Sender sender;
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void testRabbitMQ(){
        redisUtil.set("demo","123123");
        sender.send();

    }
}
