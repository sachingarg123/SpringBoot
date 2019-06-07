package com.rest.webservices.restfulwebservices;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Sachin Garg", "http://localhost:8080", "sachingarg.hcl@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("User API Documentation", 
			  "User API Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	
	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>();

	@Bean
	public Docket api(){
		DEFAULT_PRODUCES_CONSUMES.add("application/json");
		DEFAULT_PRODUCES_CONSUMES.add("application/xml");
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_CONSUMES).consumes(DEFAULT_PRODUCES_CONSUMES);
	}
 
    @SuppressWarnings("deprecation")
    private ApiInfo metadata() {
        return new ApiInfoBuilder().title("Java Code Geeks").description("API reference guide for developers").termsOfServiceUrl("https://www.javacodegeeks.com/").contact("Batra, Yatin").version("1.0").build();  
    }
}
