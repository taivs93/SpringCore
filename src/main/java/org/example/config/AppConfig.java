package org.example.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

}
