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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: 新增测试
 * @author: xianglong
 * @create: 2024-02-29 16:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GetServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 根据 ID 查询
     */
    @Test
    public void getById() {
        User user = userService.getById(10L);
        System.out.println(user);
    }

    /**
     * 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")
     */
    @Test
    public void getOne() {
        QueryWrapper<User> query = Wrappers.query();
        query.gt("id", 20L).last("LIMIT 1");
        User user = userService.getOne(query);
        System.out.println(user);
    }

    /**
     * 根据 Wrapper，查询一条记录,可以选择多条结果是否抛异常
     */
    @Test
    public void getOneNoError() {
        QueryWrapper<User> query = Wrappers.query();
        query.gt("id", 20L);
        // true 抛 | false 不抛
        User user = userService.getOne(query, false);
        System.out.println(user);
    }

    /**
     * 根据 Wrapper，查询一条记录[官方介绍说只查询一条，其实底层sql会查询满足条件的所有数据，在通过代码选择第一条, 推荐自己加wrapper.last("LIMIT 1")]
     */
    @Test
    public void getMap() {
        QueryWrapper<User> query = Wrappers.query();
        query.gt("id", 20L).last("LIMIT 1");
        Map<String, Object> map = userService.getMap(query);
        System.out.println(map);
    }

    /**
     * 根据 Wrapper，查询一条记录
     * 这里只能查询表格的第一行数据，后面的Function是对这个数据的额外处理
     */
    @Test
    public void getObj() {
        QueryWrapper<User> query = Wrappers.query();
        query.gt("id", 20L).last("LIMIT 1");
        Object obj = userService.getObj(query, x -> (Long)x + 1);
        System.out.println(obj);
    }

    private List<User> getUsers(Integer index) {
        List<User> users = new ArrayList<>();
        for (int i = index; i <= index + 5; i ++) {
            users.add(new User((long) i, "tim", index, "tim" + index + "@123.com"));
        }
        return users;
    }

}
