package br.com.caelum.fj27.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by nando on 12/07/17.
 */

public class DataSourceConfigurationTest {


    @Bean
    @Profile("test")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/fj27_test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
