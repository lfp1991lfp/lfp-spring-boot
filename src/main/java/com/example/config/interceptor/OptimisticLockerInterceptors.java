package com.example.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * 乐观锁机制
 */

@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class OptimisticLockerInterceptors implements Interceptor {
	
	private Properties props = null;
	
	@Override
	public Object intercept(Invocation invocation) throws Exception {
		try {
			Object[] args = invocation.getArgs();
			MappedStatement ms = (MappedStatement) args[0];
			if (SqlCommandType.UPDATE.ordinal() != ms.getSqlCommandType().ordinal()) {
				return invocation.proceed();
			}
			Object parameter = args[1];
			Executor executor = (Executor) invocation.getTarget();
			BoundSql boundSql = ms.getBoundSql(parameter);
			log.info("mybatis intercept sql:{}", boundSql.getSql());
			return invocation.proceed();
		} catch (Exception e) {
		
		}
		
		return invocation.proceed();
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
	
	@Override
	public void setProperties(Properties properties) {
		String dialect = properties.getProperty("dialect");
		log.info("mybatis intercept dialect:{}", dialect);
		if (!properties.isEmpty()) props = properties;
	}
}
