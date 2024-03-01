package com.cas.select;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cas.dao.UserMapper;
import com.cas.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 查询测试
 * @author: xianglong
 * @create: 2024-02-29 16:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 ID 查询
     */
    @Test
    public void selectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     *  根据 entity 条件，查询一条记录
     */
    @Test
    public void selectOne() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 2L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /**
     *  查询（根据ID 批量查询）
     */
    @Test
    public void selectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L));
        users.forEach(System.out::println);
    }

    /**
     *  根据 entity 条件，查询全部记录
     */
    @Test
    public void selectList() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.gt("age", 18);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     *  查询（根据 columnMap 条件）
     */
    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1l);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     *  根据 Wrapper 条件，查询全部记录
     *  selectList 和这个功能类似，但是selectList返回的是对象集合
     *  selectMaps返回的是将属性组织成map的key进行返回，需要根据需求进行选择
     */
    @Test
    public void selectMaps() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 2L);
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     *  根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
     */
    @Test
    public void selectObjs() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 2L);
        List<Object> objs = userMapper.selectObjs(wrapper);
        objs.forEach(System.out::println);
    }

    /**
     *  根据 entity 条件，查询全部记录（并翻页）
     */
    @Test
    public void selectPage() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.gt("age", 18);
        Page<User> page = userMapper.selectPage(Page.of(1, 2), wrapper);
        page.getRecords().forEach(System.out::println);
    }

    /**
     *  根据 entity 条件，查询全部记录（并翻页）
     *  返回结果参考selectMaps的解释
     */
    @Test
    public void selectMapsPage() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.gt("age", 18);
        Page<Map<String, Object>> page = userMapper.selectMapsPage(Page.of(1, 2), wrapper);
        page.getRecords().forEach(System.out::println);
    }

    /**
     *  根据 Wrapper 条件，查询总记录数
     */
    @Test
    public void selectCount() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.gt("age", 18);
        Long count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }
}
