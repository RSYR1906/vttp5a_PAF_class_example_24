package vttp.batch5.PAF.day24_in_class.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    // http://localhost:8080/swagger-ui/index.html (will show all the created APIs in Swagger)
    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI().info(
                new Info()
                        .title("PAF Day 24")
                        .description("Testing API using OpenAPI public interface")
                        .version("1.0"));
    }
}
