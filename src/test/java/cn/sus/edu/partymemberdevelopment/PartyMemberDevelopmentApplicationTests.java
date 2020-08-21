package cn.sus.edu.partymemberdevelopment;

import cn.sus.edu.partymemberdevelopment.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyMemberDevelopmentApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("XinHai.Ma");
        user.setPassword("XinHai.Ma");
        redisTemplate.opsForValue().set("XinHai.Ma", user);
    }

}
