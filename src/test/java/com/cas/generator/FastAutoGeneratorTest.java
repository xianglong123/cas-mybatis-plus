package com.cas.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.EnjoyTemplateEngine;

import java.sql.SQLException;

/**
 * <p>
 * 快速生成
 * </p>
 *
 * @author lanjerry
 * @since 2021-09-16
 */
public class FastAutoGeneratorTest extends BaseGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
        .Builder("jdbc:mysql://localhost:3306/cas?useSSL=false&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true", "root", "12345678");

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        // 初始化数据库脚本
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
            // 数据库配置
            .dataSourceConfig((scanner, builder) -> builder.schema(scanner.apply("请输入表名称")))
            // 全局配置
            .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称")))
            // 包配置
            .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名")))
            // 策略配置
            .strategyConfig((scanner, builder) -> builder.addInclude(scanner.apply("请输入表名，多个表名用,隔开")))
            /*
                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker 或 Enjoy
               .templateEngine(new BeetlTemplateEngine())
               .templateEngine(new FreemarkerTemplateEngine())
               .templateEngine(new EnjoyTemplateEngine())
             */
            .execute();
    }
}