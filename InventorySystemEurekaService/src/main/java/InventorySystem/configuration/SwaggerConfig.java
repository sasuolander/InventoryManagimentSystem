package inventorysystem.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger
//http://localhost:8080/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("inventorysystem.controller"))//endpoints
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo()).tags(new Tag("Order","Order management"),
                        new Tag("Product","Product management"),
                        new Tag("Purchase","Purchase management"),
                        new Tag("Supplier","Supplier management")
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("My API").version("0.2.0").build();
    }
}