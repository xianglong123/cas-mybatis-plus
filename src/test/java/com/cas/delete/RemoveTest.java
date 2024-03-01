package com.cas.delete;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cas.entity.User;
import com.cas.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 删除测试
 * @author: xianglong
 * @create: 2024-02-29 17:09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoveTest {

    @Autowired
    private UserService userService;

    /**
     * 根据 queryWrapper 设置的条件，删除记录
     */
    @Test
    public void remove() {
        // 创建一个 Wrapper 条件
        QueryWrapper<User> wrapper = Wrappers.query();
        // 设置删除条件，例如：id 等于6 的记录
        wrapper.eq("id", 6L);
        userService.remove(wrapper);
    }

    /**
     * 根据 ID 删除
     */
    @Test
    public void removeById() {
        userService.removeById(2L);
    }

    /**
     * 根据 columnMap 条件，删除记录
     */
    @Test
    public void removeByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 4L);
        userService.removeByMap(map);
    }

    /**
     * 删除（根据ID 批量删除）
     */
    @Test
    public void removeByIds() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Sandy");
        userService.removeByIds(Arrays.asList(5L, 7L));
    }
}
