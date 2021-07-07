package com.cwh.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * <b><code>CodeGenerator</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/7/7 下午12:01.
 *
 * @author caiwenhao
 * @since mybatispulsGenerate 0.1.0
 */public class CodeGenerator {

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Velocity
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("cwh");
        gc.setOutputDir("/home/fs123/ideaWorkspace/mybatispulsGenerate/src/main/java");
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.POSTGRE_SQL);
        dsc.setDriverName("org.postgresql.Driver");
        dsc.setUsername("postgres");
        dsc.setPassword("postgres");
        dsc.setUrl("jdbc:postgresql://192.168.16.65:5432/training_mintaka");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[] { "buy_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.no_change);// 表名生成策略
        strategy.setInclude(new String[] { "caiwenhao_user_terminal_statistics"});// 需要生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.training.entity");
        // pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}
