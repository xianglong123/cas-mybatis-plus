package com.cas.update;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

/**
 * @description: 更新测试
 * @author: xianglong
 * @create: 2024-02-29 16:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
     */
    @Test
    public void update() {
        UpdateWrapper<User> update = Wrappers.update();
        update.eq("id", 20L).set("age", 20);
        boolean flag = userService.update(update);
    }

    /**
     * 根据 whereWrapper 条件，更新记录
     */
    @Test
    public void updateByEntity() {
        UpdateWrapper<User> update = Wrappers.update();
        // 可以在这用.set
        update.eq("id", 20L).set("age", 20);

        // 也可以在这里传对象
        User user = new User();
        user.setName("xl");

        boolean flag = userService.update(user, update);
        System.out.println(flag);
    }

    /**
     * 根据 ID 选择修改
     */
    @Test
    public void updateById() {
        User user = new User();
        user.setId(20L);
        user.setName("xl");
        boolean flag = userService.updateById(user);
        System.out.println(flag);
    }

    /**
     * 根据ID 批量更新
     */
    @Test
    public void updateBatchById() {
        boolean flag = userService.updateBatchById(getUsers(20));
    }

    /**
     * 根据ID 批量更新
     */
    @Test
    public void updateBatchByIdWithNum() {
        boolean flag = userService.updateBatchById(getUsers(20), 2);
    }

    private List<User> getUsers(Integer index) {
        List<User> users = new ArrayList<>();
        for (int i = index; i <= index + 5; i ++) {
            users.add(new User((long) i, "tim", index, "tim" + index + "@123.com"));
        }
        return users;
    }
}
