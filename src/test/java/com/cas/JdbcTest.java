package com.cas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午4:27 2021/1/18
 * @version: V1.0
 * @review: 这个是因为我不想重新创建模块了，写一个jdbc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {

    private static final String URL = "jdbc:mysql://localhost:3306/cas?useSSL=false&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";

    /**
     * 1. 注册驱动
     *  Class.forName("com.mysql.jdbc.Driver");
     * 2.获取数据库连接
     * Connection conn  =DriverManager.getConnection(url,user,p);
     *
     * 3.创建向数据发送sql 的statement对象
     * Statement stmt = conn.CreateStatement();
     *
     * 4. 向数据库发送sql
     * ResultSet rs  = stmt.executeQuery(sql)//select语句
     * int updateaSum = stmt.executeUpdate(sql)//insert,update delete语句
     *
     * 5. 处理结果集
     * while(rs.next()){
     *     rs.getString(列名)
     *     rs.getInt(列名)
     * }
     * 6. 关闭资源
     * rs.close();
     * stmt.close();
     * conn.close();
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, "root", "123456");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
//        int i = stmt.executeUpdate("update user set age = 26");
//        System.out.println(i);
        while(rs.next()) {
            System.out.println(rs.getString("name"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }





}
