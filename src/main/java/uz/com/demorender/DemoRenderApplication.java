package uz.com.demorender;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "online shopping store",
                version="1.1.0.0.0",
                description = "This project was created for an online store, it will provide you with convenience"
        )
)
public class DemoRenderApplication {

    public static void main(String[] args)  {
        SpringApplication.run(DemoRenderApplication.class, args);
    }

}
