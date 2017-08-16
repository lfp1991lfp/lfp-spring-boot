package com.example.swaggerdoc;

import com.example.config.mvc.ApiVersion;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Optional;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
public class VersionApiReader implements ParameterBuilderPlugin {
	private TypeResolver resolver;
	
	public VersionApiReader(TypeResolver resolver) {
		this.resolver = resolver;
	}
	
	@Override
	public void apply(ParameterContext parameterContext) {
		ResolvedMethodParameter methodParameter = parameterContext.resolvedMethodParameter();
		Optional<ApiVersion> requestParam = methodParameter.findAnnotation(ApiVersion.class);
		if (requestParam.isPresent()) {
			parameterContext.parameterBuilder()
					.parameterType("query")    //head表示加到头部
					.description("版本号控制")
					.required(true)
					.name("version")
					.type(resolver.resolve(String.class));
		}
	}
	
	@Override
	public boolean supports(DocumentationType documentationType) {
		return true;
	}
}
