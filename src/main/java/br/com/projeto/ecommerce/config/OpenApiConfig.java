package br.com.projeto.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api Ecommerce com Java")
                        .version("v1")
                        .description("Projeto desenvolvido para aprimorar meus conhecimentos em:" +
                                " - Java; " +
                                " - Lógica de Programação; " +
                                " - Banco de dados; " +
                                " - Docker; " +
                                " - Cloud.")
                        .termsOfService("")
                        .license(new License().name("Apache 2.0")
                                .url("")));
    }

}
