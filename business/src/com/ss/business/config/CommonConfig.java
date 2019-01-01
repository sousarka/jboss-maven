package com.ss.business.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.spring.annotations.KModuleAnnotationPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
    public StatelessKieSession session1(KieContainer kieContainer) {
        return kieContainer.newStatelessKieSession("session1");
    }

    @Bean
    public StatelessKieSession session2(KieContainer kieContainer) {
        return kieContainer.newStatelessKieSession("session2");
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:dev"); // name of the resource bundle
        source.setDefaultEncoding("UTF-8");
        return source;
    }

}