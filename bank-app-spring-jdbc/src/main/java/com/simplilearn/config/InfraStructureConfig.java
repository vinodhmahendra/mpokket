package com.simplilearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class InfraStructureConfig {

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/studentdb");
        dataSource.setUsername("root");
        dataSource.setPassword("Simplilearn");

        return dataSource;
    }
}
