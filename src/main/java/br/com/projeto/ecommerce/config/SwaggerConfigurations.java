package br.com.projeto.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	// http://localhost:8080/swagger-ui/index.html

	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
	@Bean
	public OpenAPI infoDocs() {
		return new OpenAPI()
				.info(new Info()
						.title("Ecommerce")
						.description("loja virtual de produtos eletronicos")
						.version("1.0")
						.license(new License().name("Apache 2.0").url("")));
	}
}
