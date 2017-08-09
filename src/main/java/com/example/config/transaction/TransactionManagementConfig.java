package com.example.config.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 事务配置器.
 * 配置多数据源的事务管理
 */
@EnableTransactionManagement
@Configuration
public class TransactionManagementConfig implements TransactionManagementConfigurer {
	
	@Resource(name = "transactionManagerPrimary")
	private PlatformTransactionManager transactionManagerPrimary;
	
	@Bean(name = "transactionManagerPrimary")
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManagerPrimary;    //默认的事务管理器
	}
}
