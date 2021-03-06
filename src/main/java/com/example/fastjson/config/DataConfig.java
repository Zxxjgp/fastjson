package com.example.fastjson.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName DataConfig
 * @date 2019/4/29  14:36
 */
@Configuration
@MapperScan(basePackages = "com.example.fastjson.mapper" ,sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataConfig {
    @Bean("db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean  sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();

    }


    /**
     * 配置事务管理
     */
    @Bean("db1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 数据库的操作
     * @param sqlSessionFactory
     * @return
     */
    @Bean("db1SqlSessionTemplate")
    public SqlSessionTemplate  testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
