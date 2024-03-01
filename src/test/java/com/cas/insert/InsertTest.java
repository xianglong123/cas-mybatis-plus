package com.cas.insert;

import com.cas.entity.User;
import com.cas.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 新增测试
 * @author: xianglong
 * @create: 2024-02-29 16:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setAge(12);
        user.setId(6L);
        user.setName("tom");
        user.setEmail("123@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
