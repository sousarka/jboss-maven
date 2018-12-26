package com.ss.intgtest;

import com.ss.business.config.CommonConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfig.class)
@ComponentScan(basePackages = { "com.ss.business" })
class TestConfig {

}