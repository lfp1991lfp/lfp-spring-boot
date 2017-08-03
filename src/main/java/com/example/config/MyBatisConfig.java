package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * MyBatis配置.
 */
@Slf4j
public class MyBatisConfig implements TransactionManagementConfigurer {
	
	final
	DataSource dataSource;
	
	@Autowired
	public MyBatisConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage("tk.mybatis.springboot.model");
		
		//添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
