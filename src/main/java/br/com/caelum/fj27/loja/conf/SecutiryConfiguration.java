package br.com.caelum.fj27.loja.conf;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by nando on 07/07/17.
 */
@EnableWebSecurity
public class SecutiryConfiguration extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/products/form").hasRole("ADMIN")
                .antMatchers("/shopping/**").permitAll()
                .antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                .antMatchers("/products/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }
}
