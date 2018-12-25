package com.ss.web.config;

import java.util.ArrayList;
import java.util.List;

import com.ss.business.config.CommonConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ss.web.controller", "com.ss.business" })
@Import(CommonConfig.class)
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
   public MappingJackson2HttpMessageConverter jsonMessageConverter() {
      List<MediaType> supportedMediaTypes = new ArrayList<>();
      MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
      supportedMediaTypes.add(MediaType.APPLICATION_JSON);
      converter.setSupportedMediaTypes(supportedMediaTypes);
      return converter;
   }

   @Bean
   public RequestMappingHandlerAdapter handleAdapter() {
      List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
      RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
      messageConverters.add(jsonMessageConverter());
      adapter.setMessageConverters(messageConverters);
      return adapter;
   }
}
