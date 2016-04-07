package com.springboot.example.common.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author <a href="mailto:jean@eastcode.org">Jean Seurin</a>
 * @since 26/08/15 - 15:18
 */
//@MapperScan("com.ptmind.api.userinfo.mapper", markerInterface = tk.mybatis.mapper.common.Mapper.class)
@Configuration
public class MybatisConfiguration {

    /**
     * 将mybatis的sqlSessionFactory交给spring管理
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, PageHelper pageHelper) {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.springboot.example.**.model");
        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
        return sessionFactory;
    }

    /**
     * 分页插件
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper interceptor = new PageHelper();
        Properties props = new Properties();
        props.setProperty("dialect", "mysql");
        props.setProperty("reasonable", "true");
        interceptor.setProperties(props);
        return interceptor;
    }

    /**
     * 通用mapper插件,支持通用的增删改查
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.springboot.example.**.mapper");
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        Properties props = new Properties();
        props.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        props.setProperty("IDENTITY", "MYSQL");
        props.setProperty("notEmpty", "true");
        scannerConfigurer.setProperties(props);
        return scannerConfigurer;
    }
}
