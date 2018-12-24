package com.ss.web.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ss.web.controller")
public class WebAppConfig {

    @Bean
   public ViewResolver viewResolver() {
      InternalResourceViewResolver bean = new InternalResourceViewResolver();
 
      bean.setViewClass(JstlView.class);
      bean.setPrefix("/WEB-INF/jsp/");
      bean.setSuffix(".jsp");
 
      return bean;
   }

@Bean
 public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
  MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
  return jsonConverter;
 }
}

