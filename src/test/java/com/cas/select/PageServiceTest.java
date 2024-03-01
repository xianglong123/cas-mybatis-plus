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
public class PageServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 无条件分页查询
     */
    @Test
    public void page() {
        Page<User> page = userService.page(Page.of(1, 2));
        page.getRecords().forEach(System.out::println);
    }

    /**
     * 条件分页查询
     */
    @Test
    public void pageByWrapper() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 20L);
        Page<User> page = userService.page(Page.of(1, 2), wrapper);
        page.getRecords().forEach(System.out::println);
    }

    /**
     * 无条件分页查询
     */
    @Test
    public void pageMaps() {
        Page<Map<String, Object>> mapPage = userService.pageMaps(Page.of(1, 2));
        mapPage.getRecords().forEach(System.out::println);
    }

    /**
     * 条件分页查询
     */
    @Test
    public void pageMapsByWrapper() {
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("id", 20L);
        Page<Map<String, Object>> mapPage = userService.pageMaps(Page.of(1, 2), wrapper);
        mapPage.getRecords().forEach(System.out::println);
    }
}
