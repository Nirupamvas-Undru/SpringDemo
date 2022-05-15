package com.springboot.resortmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    //add a reference to our security data source
    @Autowired
    private DataSource securityDataSource;

    String manager="MANAGER";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()


                //.antMatchers("/resorts/showAll","/villas/findVillas").hasAnyRole("VIEWER",manager)
                //.antMatchers("/resorts/**","/customers/**","/villas/**").hasRole(manager)
                .antMatchers("/resorts/viewResorts","/villas/viewVillas").permitAll()
                .antMatchers("/resorts/showAll","/resorts/showFormForAdd","/customers/**","/villas/**").hasRole(manager)
                //ACCESS TO SOME PEOPLE
                .and()
                .formLogin()
                //.loginPage("/login")//this displays before home page
                //.loginProcessingUrl("/home")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");//if access is denied

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("nirupamvas").password("nirupamvas").roles(manager));
        //use jdbc authentication we created

    }

}