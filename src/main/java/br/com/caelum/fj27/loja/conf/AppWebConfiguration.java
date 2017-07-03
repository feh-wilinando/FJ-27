package br.com.caelum.fj27.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.format.DateTimeFormatter;

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


    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }


    @Bean
    public FormattingConversionService mvcConversionService(){

        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);

        DateFormatterRegistrar registrar = new DateFormatterRegistrar();

        registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
        registrar.registerFormatters(conversionService);

        return conversionService;
    }
}
