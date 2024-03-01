package com.cas.update;

import com.cas.dao.UserMapper;
import com.cas.entity.User;
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
public class UpdateTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 ID 修改
     */
    @Test
    public void updateById() {
        User user = new User();
        user.setAge(12);
        user.setId(6L);
        user.setName("tom");
        user.setEmail("123@qq.com");
        int insert = userMapper.updateById(user);
    }

    /**
     * 根据 whereWrapper 条件，更新记录
     */
    @Test
    public void update() {
        User user = new User();
        user.setAge(12);
        user.setId(6L);
        user.setName("tom");
        user.setEmail("123@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
