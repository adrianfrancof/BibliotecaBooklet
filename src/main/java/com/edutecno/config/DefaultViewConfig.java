package com.edutecno.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//configuracion para la vista por default que se ejecuta desde el principio del inicio del aplicativo
@Configuration
public class DefaultViewConfig implements WebMvcConfigurer {
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/home");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
