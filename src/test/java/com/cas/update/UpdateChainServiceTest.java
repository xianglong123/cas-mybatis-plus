package com.cas.update;

import com.cas.entity.User;
import com.cas.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 更新测试
 * @author: xianglong
 * @create: 2024-02-29 16:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateChainServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 链式更改 普通
     */
    @Test
    public void update() {
        boolean id = userService.update().eq("id", 21L).remove();
        System.out.println(id);
    }

    /**
     * 链式更改 lambda 式。注意：不支持 Kotlin
     */
    @Test
    public void lambdaUpdate() {
        boolean id = userService.lambdaUpdate().eq(User::getId, 22L).remove();
        System.out.println(id);
    }
}
