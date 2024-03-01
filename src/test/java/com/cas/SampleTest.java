package com.cas;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cas.entity.User;
import com.cas.dao.UserMapper;
import org.junit.Assert;
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
 * 【单表操作】
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * mybatis-plus查询操作【单表】
     */
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

//    /**
//     * mybatis-plus 插入操作【单表】
//     */
//    @Test
//    public void testInsert() {
//        System.out.println(("----- testInsert method test ------"));
//        User user = new User("xl", 23, "1391086179@qq.com");
//        int insert = userMapper.insert(user);
//        Assert.assertEquals(1, insert);
//    }
//
//    /**
//     * mybatis-plus更新操作【单表】
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println(("----- testUpdate method test ------"));
//        User user = new User(11L,"xl", 24, "1391086179@qq.com");
//        int insert = userMapper.updateById(user);
//        Assert.assertEquals(1, insert);
//    }

    /**
     * 乐观锁 要先开启乐观锁配置：com.cas.config.MyBatisPlusConfig
     */
    @Test
    public void testOptimisticLocker() {
        // 查询用户信息
        User user = userMapper.selectById(1L);
        // 修改用户信息
        user.setName("xl2");
        user.setAge(23);
        userMapper.updateById(user);
    }

    /**
     * 查询多个，根据主键
     */
    @Test
    public void testSelects() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * 根据条件查询，name=xl
     */
    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xl");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 分页查询
     */
    @Test
    public void testPage() {
        Page<User> userPage = new Page<>(2 , 2);
        Page<User> userIPage = userMapper.selectPage(userPage, null);
        System.out.println("总页数： "+userIPage.getPages());
        System.out.println("总记录数： "+userIPage.getTotal());
        userIPage.getRecords().forEach(System.out::println);
    }

    /**
     * 根据主键删除单条数据【物理删除】
     * 配置了逻辑删除之后就都变成了【逻辑删除】
     */
    @Test
    public void testDelete() {
        userMapper.deleteById(4L);
    }

    /**
     * 根据主键删除多条数据【物理删除】
     */
    @Test
    public void testDeletes() {
        userMapper.deleteBatchIds(Arrays.asList(2L, 3L));
    }

    /**
     * 根据条件删除【物理删除】
     */
    @Test
    public void testDeleteMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xl");
        userMapper.deleteByMap(map);

    }


}
