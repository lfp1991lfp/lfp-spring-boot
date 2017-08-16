package com.example.config.mvc;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 版本号条件判定
 * 向下适配兼容
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
	
	// 路径中版本的前缀， 这里用 /v[1-9]/的形式,已经定义好了v
	private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("/v(\\d+).*");
	
	private int apiVersion;
	
	ApiVersionCondition(int apiVersion) {
		this.apiVersion = apiVersion;
	}
	
	public int getApiVersion() {
		return apiVersion;
	}
	
	@Override
	public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
		// 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
		return new ApiVersionCondition(apiVersionCondition.getApiVersion());
	}
	
	@Override
	public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
		Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
		if (m.find()) {
			Integer version = Integer.valueOf(m.group(1));
			return version >= this.apiVersion ? this : null;
		} else {
			return this;
		}
	}
	
	@Override
	public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
		// 优先匹配最新的版本号
		return apiVersionCondition.getApiVersion() - this.apiVersion;
	}
}
