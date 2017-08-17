package com.example.swaggerdoc;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Configuration
public class Bug1767ListingScanner implements ApiListingScannerPlugin {
	
	// tag::api-listing-plugin[]
	@Override
	public List<ApiDescription> apply(DocumentationContext context) {
		return new ArrayList<ApiDescription>(
				Arrays.asList( //<1>
						new ApiDescription(
								"/api/v1",
								"This is a bug",
								Arrays.asList( //<2>
										new OperationBuilder(
												new CachingOperationNameGenerator())
												.authorizations(new ArrayList())
												.codegenMethodNameStem("bug1767GET") //<3>
												.method(HttpMethod.GET)
												.notes("This is a test method")
												.parameters(
														Arrays.asList( //<4>
																new ParameterBuilder()
																		.description("search by description")
																		.type(new TypeResolver().resolve(String.class))
																		.name("description")
																		.parameterType("query")
																		.parameterAccess("access")
																		.required(true)
																		.modelRef(new ModelRef("string")) //<5>
																		.build()))
												.build()),
								false)));
	}
	// tag::api-listing-plugin[]
	
	@Override
	public boolean supports(DocumentationType delimiter) {
		return DocumentationType.SWAGGER_2.equals(delimiter);
	}
}
