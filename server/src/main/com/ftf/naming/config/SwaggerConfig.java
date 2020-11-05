package com.ftf.naming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	// swagger2�������ļ��������������swagger2��һЩ���������ݣ�����ɨ��İ��ȵ�
    @Bean
    public Docket createRestApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  .select()
                  .apis(RequestHandlerSelectors.basePackage("com"))
                  .paths(PathSelectors.any())
                  .build();
    }
    // ���� api�ĵ�����ϸ��Ϣ����,ע�������ע�����õ����ĸ�
    private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                  // ҳ�����
                  .title("434��һ����Ŀ")
                  // �汾��
                  .version("1.0")
                  // ����
                  .description("ȡ��ϵͳAPI")
                  .termsOfServiceUrl("http://www.baidu.com")
                  .build();
    }
}
