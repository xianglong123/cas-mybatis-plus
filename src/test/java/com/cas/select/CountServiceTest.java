package com.cas.select;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cas.entity.User;
import com.cas.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @description:
 * @author: xianglong
 * @create: 2024-03-01 11:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 查询总记录数
     */
    @Test
    public void count() {
        long count = userService.count();
        System.out.println(count);
    }

    /**
     * 条件分页查询
     */
    @Test
    public void countByWrapper() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 20L);
        Long count = userService.count(wrapper);
        System.out.println(count);
    }
}
