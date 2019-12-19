package com.engrs.showcase.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer
{
  /**
   * @return Docket
   */
  @Bean
  public Docket showcaseApi()
  {
    return new Docket(DocumentationType.SWAGGER_2)
      .useDefaultResponseMessages(false)
      .apiInfo(getApiInfo())
      .select()
      .apis(withClassAnnotation(RestController.class))
      .apis(withMethodAnnotation(ApiOperation.class))
      .paths(PathSelectors.any())
      .build()
      .pathMapping("/");
  }

  /**
   * @return ApiInfo
   */
  private static ApiInfo getApiInfo()
  {
    return new ApiInfo(
      "Showcase REST API (v1)",
      "Showcase API",
      "v1",
      "",
      new Contact("","",""),
      "",
      "", Collections.emptyList());
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler("swagger-ui.html")
      .addResourceLocations("classpath:/META-INF/resources/");

    registry.addResourceHandler("/webjars/**")
      .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
