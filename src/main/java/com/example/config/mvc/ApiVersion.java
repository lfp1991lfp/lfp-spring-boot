package com.example.config.mvc;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 版本号控制器
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
	/**
	 * 版本号
	 *
	 * @return 版本号
	 */
	int value();
}
