package com.leiming.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//安全配置类注解
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().logout().logoutSuccessUrl("/").deleteCookies("JSESSIONID").and().authorizeRequests()
                .antMatchers("/index","/","/searchCatalog","/saveVisitor","/search","/saveBlogComment","/findAllMessage","/saveMessage","/user","/archives","/blogDetail","/gustbook","/link","/blog","/mood","/css/**","/images/**","/js/**","/layer/**","/lib/**","/social/**","/statics/**","/upload/**").permitAll().anyRequest().authenticated().and().csrf().disable()
                ;
    }
}
