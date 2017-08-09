package com.example.demo;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//如果不使用@ComponentScan指明对象扫描范围，默认指扫描当前启动类所在的包里的对象
@ServletComponentScan(basePackages = "com.example.*")
@ComponentScan(basePackages = "com.example.*")//组件扫描,若basePackages不配，// 则默认所在的包名
@MapperScan("com.example.*.*.mapper")
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public DruidStatInterceptor druidStatInterceptor() {
		return new DruidStatInterceptor();
	}
	
	@Bean
	public JdkRegexpMethodPointcut druidStatPointcut() {
		JdkRegexpMethodPointcut druidStatPointcut = new JdkRegexpMethodPointcut();
		String patterns = "com.example.*.*.service.*";
		druidStatPointcut.setPatterns(patterns);
		return druidStatPointcut;
	}
	
	//需要设置proxy-target-class: true
	@Bean
	public Advisor druidStatAdvisor() {
		return new DefaultPointcutAdvisor(druidStatPointcut(), druidStatInterceptor());
	}
}
