package com.cas.insert;

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
 * @description: 新增测试
 * @author: xianglong
 * @create: 2024-02-29 16:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 插入一条记录（选择字段，策略插入）
     */
    @Test
    public void save() {
        User user = new User();
        user.setAge(12);
        user.setId(7L);
        user.setName("tom");
        user.setEmail("123@qq.com");
        boolean flag = userService.save(user);
        System.out.println(flag);
    }

    /**
     * 插入（批量）
     */
    @Test
    public void saveBatch() {
        boolean flag = userService.saveBatch(getUsers(20));
        System.out.println(flag);
    }

    /**
     * 插入（批量）, 就是你有一堆集合，我分批次给你插入，集合庞大的时候分批次插入效率更高
     */
    @Test
    public void saveBatchWithNum() {
        boolean flag = userService.saveBatch(getUsers(30), 2);
        System.out.println(flag);
    }

    private List<User> getUsers(Integer index) {
        List<User> users = new ArrayList<>();
        for (int i = index; i <= index + 5; i ++) {
            users.add(new User((long) i, "tim", index, "tim" + index + "@123.com"));
        }
        return users;
    }

}
