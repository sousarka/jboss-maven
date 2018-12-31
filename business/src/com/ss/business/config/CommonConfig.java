package com.ss.business.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.spring.annotations.KModuleAnnotationPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = { "com.ss.business" })
public class CommonConfig {

    @Bean
    public static KModuleAnnotationPostProcessor kiePostProcessor() {
        return new  KModuleAnnotationPostProcessor();
    }

    @Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
    }
    
    @Bean
    @Scope("prototype")
    public StatelessKieSession appKSession(KieContainer kieContainer) {
        return kieContainer.newStatelessKieSession("appKSession");
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:dev"); // name of the resource bundle
        source.setDefaultEncoding("UTF-8");
        return source;
    }

}