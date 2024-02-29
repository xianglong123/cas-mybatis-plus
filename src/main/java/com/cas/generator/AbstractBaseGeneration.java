package com.cas.generator;

/**
 * @description:
 * @author: xianglong
 * @create: 2024-02-29 10:02
 **/
public abstract class AbstractBaseGeneration {

    public static class DBconfig {
        protected static final String DATABASE = "cas";
        protected static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?&useSSL=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        protected static final String TABLE_NAME = "user";
        protected static final String USERNAME = "root";
        protected static final String PASSWORD = "12345678";
    }

    public static class UserConfig {
        protected static final String AUTHOR = "xianglong";


    }

}
