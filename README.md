# cas-mybatis-plus

### 官网地址
    https://baomidou.com/
---

### 体会
    能快速实现对单表的CURD操作，单表确实可以用，但是问题是大部分业务场景可能都会用到多表查询。
    如果单表用mybatis-plus，多表用mybatis。这样感觉很不方便管理，我的体会就是自己私下学学技术可以，
    这个框架有局限性，如果随着版本的迭代，能做到多表操作则可以用。
---

### 数据sql
    create table if not exists user
    (
    	id bigint auto_increment comment '主键ID'
    		primary key,
    	name varchar(30) null comment '姓名',
    	age int null comment '年龄',
    	email varchar(50) null comment '邮箱',
    	version int null comment '乐观锁',
    	deleted int null,
    	create_time datetime null comment '创建时间',
    	update_time datetime null comment '更新时间'
    );
    
    # 这个sql粘贴，运行。然后改改配置就能运行里面的测试用例了
---

### 环境
    gradle6.4.1 
    springboot2.2.1.RELEASE
---   
    
###    

    
