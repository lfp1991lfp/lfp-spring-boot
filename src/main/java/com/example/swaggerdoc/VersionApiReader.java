package com.example.swaggerdoc;

import com.example.config.mvc.ApiVersion;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Optional;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

@Configuration
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
					.parameterType("header")    // header, cookie, body, query
					.description("版本号")
					.defaultValue("v" + requestParam.get().value())
					.required(true)
					.name("version")
					.type(resolver.resolve(Integer.class));
		}
	}
	
	@Override
	public boolean supports(DocumentationType documentationType) {
		return true;
	}
}
