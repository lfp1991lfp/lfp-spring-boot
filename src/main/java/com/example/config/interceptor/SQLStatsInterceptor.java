package com.example.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

@Slf4j
public class SQLStatsInterceptor implements Interceptor {
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		return null;
	}
	
	@Override
	public Object plugin(Object o) {
		return null;
	}
	
	@Override
	public void setProperties(Properties properties) {
	
	}
}
