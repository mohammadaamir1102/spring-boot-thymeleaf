package com.aamir.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

@Configuration
@PropertySources({@PropertySource("classpath:db-config.properties")})
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName(Objects.requireNonNull(environment.getProperty("spring.datasource.driver-class-name")));
        dmds.setUrl(Objects.requireNonNull(environment.getProperty("spring.datasource.url")));
        dmds.setUsername(Objects.requireNonNull(environment.getProperty("spring.datasource.username")));
        dmds.setPassword(Objects.requireNonNull(environment.getProperty("spring.datasource.password")));
//        dmds.setConnectionProperties(hibernateProperties());
        return dmds;
    }

//    private final Properties hibernateProperties(){
//        Properties hiberProperties = new Properties();
//        hiberProperties.setProperty("hibernate.hbm2ddl.auto","update");
//        hiberProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
//        hiberProperties.setProperty("hibernate.show_sql","true");
//        hiberProperties.setProperty("hibernate.format_sql","true");
//        return hiberProperties;
//
//    }

    @Bean
    public JpaProperties jpaProperties() {
        Map<String, String> hibernateProperties = new HashMap<>();
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.format_sql", "true");

        JpaProperties jpaProperties = new JpaProperties();
        jpaProperties.setProperties(hibernateProperties);
        return jpaProperties;
    }




}
