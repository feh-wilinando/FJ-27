package br.com.caelum.fj27.loja.conf;

import br.com.caelum.fj27.loja.infra.JsonViewResolver;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nando on 02/07/17.
 */
@EnableWebMvc
@ComponentScan(basePackages = "br.com.caelum.fj27.loja")
@EnableCaching
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposedContextBeanNames("shoppingCart");
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

    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public CacheManager cacheManager(){

        CacheBuilder<Object, Object> builder = CacheBuilder
                                                    .newBuilder()
                                                        .maximumSize(100)
                                                            .expireAfterAccess(5, TimeUnit.MINUTES);


        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(builder);

        return cacheManager;
    }


    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        List<ViewResolver> resolverList = Arrays.asList(internalResourceViewResolver(), new JsonViewResolver());

        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();

        viewResolver.setViewResolvers(resolverList);
        viewResolver.setContentNegotiationManager(manager);

        return viewResolver;
    }
}
