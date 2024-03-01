package com.cas.select;

import com.cas.entity.User;
import com.cas.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 链式编程
 * @author: xianglong
 * @create: 2024-03-01 11:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryChainServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 链式查询 普通
     */
    @Test
    public void query() {
        User user = userService.query().eq("id", 20L).one();
        System.out.println(user);
    }

    /**
     * 链式查询 lambda 式。注意：不支持 Kotlin
     */
    @Test
    public void lambdaQuery() {
        User one = userService.lambdaQuery().eq(User::getId, 20L).one();
        System.out.println(one);
    }
}
