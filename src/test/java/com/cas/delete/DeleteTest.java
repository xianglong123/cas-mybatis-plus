package com.cas.delete;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cas.dao.UserMapper;
import com.cas.entity.User;
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
public class DeleteTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 entity 条件，删除记录
     */
    @Test
    public void deleteByEntity() {
        // 创建一个 Wrapper 条件
        QueryWrapper<User> wrapper = Wrappers.query();
        // 设置删除条件，例如：id 等于6 的记录
        wrapper.eq("id", 6L);
        userMapper.delete(wrapper);
    }

    /**
     * 删除（根据ID 批量删除）
     */
    @Test
    public void deleteBatchIds() {
        userMapper.deleteBatchIds(Arrays.asList(1L, 2L));
    }

    /**
     * 根据 ID 删除
     */
    @Test
    public void deleteById() {
        userMapper.deleteById(3L);
    }

    /**
     * 根据 columnMap 条件，删除记录
     */
    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Sandy");
        userMapper.deleteByMap(map);
    }
}
