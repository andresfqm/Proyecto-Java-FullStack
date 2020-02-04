package com.quintana;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
// Esta clase es para configurar las librerias de documentacion swagger que se agregaron el pom.xml
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Andres Quintana", "https://andresfqm.com.co", "andresfqm@hotmail.com");
	
	public static final ApiInfo DEFAEUL_API_INFO = new ApiInfo("Medi-app Api Documentation", "Aplicacion curso full stack", "1.0.0", "PREMIUM", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAEUL_API_INFO);
	}
	

}
