package com.mypet.social;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.validator.constraints.NotBlank;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.mypet.social.dao")
@ConfigurationProperties(prefix = "mybatis", ignoreUnknownFields = false)
public class MybatisConfig {

    @NotBlank
    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @NotBlank
    private String mapperLocation;

    public String getMapperLocation() {
        return mapperLocation;
    }

    public void setMapperLocation(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource() {

        return new com.mchange.v2.c3p0.ComboPooledDataSource();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {

        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver.getResource(getConfig()));
        sessionFactory.setMapperLocations(resolver.getResources(getMapperLocation()));
        return sessionFactory.getObject();
    }

}

