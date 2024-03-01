package com.cas.insert;

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

/**
 * @description:
 * @author: xianglong
 * @create: 2024-03-01 10:49
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertAndUpdateServiceTest {

    @Autowired
    private UserService userService;

    /**
     * TableId 注解存在更新记录，否插入一条记录
     * ==>  Preparing: SELECT id,name,age,email FROM user WHERE id=?
     * ==> Parameters: 7(Long)
     * <==    Columns: id, name, age, email
     * <==        Row: 7, tom, 12, 123@qq.com
     * <==      Total: 1
     * Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2000261e]
     * Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2000261e] from current transaction
     * ==>  Preparing: UPDATE user SET name=?, age=?, email=? WHERE id=?
     * ==> Parameters: tom(String), 12(Integer), 123@qq.com(String), 7(Long)
     * <==    Updates: 1
     */
    @Test
    public void saveOrUpdate() {
        User user = new User();
        user.setAge(12);
        user.setId(90L);
        user.setName("tom");
        user.setEmail("123@qq.com");
        boolean flag = userService.saveOrUpdate(user);
        System.out.println(flag);
    }

    /**
     * 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
     * 已计划删除，不推荐使用
     */
    @Test
    public void saveOrUpdateByWrapper() {
        // 不推荐
    }

    /**
     * 批量修改插入
     */
    @Test
    public void saveOrUpdateBatch() {
        boolean flag = userService.saveOrUpdateBatch(getUsers(35));
        System.out.println(flag);
    }

    /**
     * 批量修改插入
     */
    @Test
    public void saveOrUpdateBatchByNum() {
        boolean flag = userService.saveOrUpdateBatch(getUsers(40), 2);
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
