package com.example.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 配置mvc配置
 */
@Configuration
@EnableWebMvc
public class ApplicationConfigMVC extends WebMvcConfigurerAdapter {
	
	/**
	 * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
	 * 需要重新指定静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		//配置swagger日志的访问
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}
	
	/**
	 * 配置servlet处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		super.configurePathMatch(configurer);
		configurer
				.setUseSuffixPatternMatch(false)    //禁止使用带后缀的地址
				.setUseTrailingSlashMatch(true);    //不区分末尾是否带斜杠的链接，比如http://host:port/a和http://host:port/a/一致
	}
}
