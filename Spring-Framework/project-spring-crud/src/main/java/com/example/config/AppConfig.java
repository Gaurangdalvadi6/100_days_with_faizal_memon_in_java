package com.example.config;

import com.example.db.DatabaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    @Bean(initMethod = "init",destroyMethod = "cleanUp")
    public DatabaseConnection getDatabaseConnection(){
        return new DatabaseConnection();
    }
}
