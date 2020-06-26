package com.yhq.mybatisplusdemo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author: YHQ
 * @Date: 2020/6/26 18:27
 */
public class code {

    public static void main(String args[]){
        AutoGenerator autoGenerator = new AutoGenerator();

        // 1. 主要设置
        GlobalConfig gc = new GlobalConfig();
        String path = System.getProperty("user.dir");
        gc.setAuthor("yhq");
        gc.setOutputDir(path+"/src/main/java");
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
//        gc.setSwagger2(true);
        autoGenerator.setGlobalConfig(gc);

        // 2. 数据源设置
        DataSourceConfig config = new DataSourceConfig();
        config.setUrl("jdbc:mysql://localhost:3306/yun");
        config.setDriverName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("root");
        config.setDbType(DbType.MYSQL);

        autoGenerator.setDataSource(config);

        // 3. 包设置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.yhq");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setController("controller");
        autoGenerator.setPackageInfo(pc);

        // 4. 策略配置

        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("tb_brand");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok
        strategy.setLogicDeleteFieldName("deleted");
        strategy.setVersionFieldName("version");

        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);

        autoGenerator.setStrategy(strategy);

        autoGenerator.execute();

    }
}
