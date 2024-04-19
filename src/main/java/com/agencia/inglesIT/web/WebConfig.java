package com.agencia.inglesIT.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void  addViewControllers (ViewControllerRegistry registry){
        registry.addViewController("").setViewName("plantilla");
        registry.addViewController("/login").setViewName("login");
    }
}
