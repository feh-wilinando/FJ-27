package br.com.caelum.fj27.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by nando on 02/07/17.
 */
@EnableWebMvc
@ComponentScan(basePackages = "br.com.caelum.fj27.loja")
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
