package com.sansi.education.user.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.sansi.education.user.configuration.dbProperties.TestRWDbProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author yihang.lv 2018/8/21、11:12
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Autowired
    private TestRWDbProperties testRWDbProperties;

    @Primary
    @Bean(name = "testRWDataSource")
    public DataSource testRWDataSourceDruid() {
        log.info("-------------------- testRWDataSource init ---------------------");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(testRWDbProperties.getDriverClassName());
        dataSource.setUrl(testRWDbProperties.getUrl());
        dataSource.setUsername(testRWDbProperties.getUsername());
        dataSource.setPassword(testRWDbProperties.getPassword());
        dataSource.setInitialSize(testRWDbProperties.getInitialSize());
        dataSource.setMaxActive(testRWDbProperties.getMaxActive());
        dataSource.setMinIdle(testRWDbProperties.getMinIdle());
        dataSource.setMaxWait(testRWDbProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(testRWDbProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setValidationQuery(testRWDbProperties.getValidationQuery());
        dataSource.setTestWhileIdle(testRWDbProperties.isTestWhileIdle());
        return dataSource;
    }

    @Bean(name = "testdbTransactionManager")
    @Primary
    public PlatformTransactionManager xqdbTransactionManager(@Qualifier("testRWDataSource")DataSource testRWDataSource){
        return new DataSourceTransactionManager(testRWDataSource);
    }
}
