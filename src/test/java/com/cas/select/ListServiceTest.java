package com.cas.select;

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
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: xianglong
 * @create: 2024-03-01 11:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     */
    @Test
    public void list() {
        List<User> users = userService.list();
        users.forEach(System.out::println);
    }

    /**
     * 查询列表
     */
    @Test
    public void listByWrapper() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 20L);
        List<User> users = userService.list(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 查询（根据ID 批量查询）
     */
    @Test
    public void listByIds() {
        List<User> users = userService.listByIds(Arrays.asList(1L, 2L));
        users.forEach(System.out::println);
    }

    /**
     * 查询（根据 columnMap 条件）
     */
    @Test
    public void listByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1L);
        List<User> users = userService.listByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 查询所有列表
     */
    @Test
    public void listMaps() {
        List<Map<String, Object>> maps = userService.listMaps();
        maps.forEach(System.out::println);
    }

    /**
     * 查询列表
     */
    @Test
    public void listMapsByWrapper() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 20L);
        List<Map<String, Object>> maps = userService.listMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     * 查询全部记录, 只查第一行记录
     */
    @Test
    public void listObjs() {
        List<Long> ids = userService.listObjs();
        ids.forEach(System.out::println);
    }

    /**
     * 查询全部记录
     */
    @Test
    public void listObjsWithFunction() {
        List<Long> ids = userService.listObjs(x -> (Long)x + 1);
        ids.forEach(System.out::println);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     */
    @Test
    public void listObjsByWrapper() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 20L);
        List<Long> ids = userService.listObjs(wrapper);
        ids.forEach(System.out::println);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     */
    @Test
    public void getById() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 20L);
        List<Long> ids = userService.listObjs(wrapper, x -> (Long) x + 1);
        ids.forEach(System.out::println);
    }
}
