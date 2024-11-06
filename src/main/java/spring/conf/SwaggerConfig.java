package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean // 필수항목
    public Docket api() {
    	final ApiInfo apiInfo = new ApiInfoBuilder()
    			.title("SpringReact Rest API 명세서")
    			.description("<h3>SpringReact swagger 연습</h3>")
    			.version("1.0")
    			.build();
    	return new Docket(DocumentationType.SWAGGER_2)
    			.apiInfo(apiInfo)
    			.select()
    			.apis(RequestHandlerSelectors.basePackage("com"))
    			.paths(regex("/.*"))
    			.build();

    
    }

  
}

