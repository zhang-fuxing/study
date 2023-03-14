package com.b.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zfx
 * @date 2022-07-24 10:21
 */
@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               .allowedOriginPatterns("*")
               .allowCredentials(true)
               .allowedMethods("GET","POST")
               .allowedHeaders("*")
               .maxAge(3600);
    }
}
