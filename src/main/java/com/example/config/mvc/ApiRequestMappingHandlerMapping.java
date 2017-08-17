package com.example.config.mvc;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * api版本控制器，用于api版本转发
 */
public class ApiRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
	
	private static RequestCondition<ApiVersionCondition> createCondition(ApiVersion apiVersion) {
		return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
	}
	
	@Override
	protected RequestCondition<ApiVersionCondition> getCustomTypeCondition(Class<?> handlerType) {
		RequestMapping classRequestMapping = AnnotationUtils.findAnnotation(handlerType, RequestMapping.class);
		if (classRequestMapping == null) {
			return null;
		}
		StringBuilder mappingUrlBuilder = new StringBuilder();
		if (classRequestMapping.value().length > 0) {
			mappingUrlBuilder.append(classRequestMapping.value()[0]);
		}
		String mappingUrl = mappingUrlBuilder.toString();
		if (!mappingUrl.contains("{version")) {
			return null;
		}
		ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
		return createCondition(apiVersion);
	}
	
	@Override
	protected RequestCondition<ApiVersionCondition> getCustomMethodCondition(Method method) {
		ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
		return createCondition(apiVersion);
	}
}
