package com.bookStore.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("test in conf");
        http.authorizeRequests()
                .antMatchers("/", "/registration", "/signUp", "/login", "/signin", "/logout").permitAll()
                //.antMatchers("/add").access("hasRole('ADMIN')")
                .anyRequest().authenticated();

        http.csrf().disable();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll();
                /*formLogin()
                // указываем страницу с формой логина
               .loginPage("/login")
                // указываем action с формы логина
                .loginProcessingUrl("/j_spring_security_check")
                // указываем URL при неудачном логине
                //.failureUrl("/login?error")
                // указываем URL при удачном логине
                .defaultSuccessUrl("/")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                // даем доступ к форме логина всем
                .permitAll();*/

        http.logout().permitAll();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }




}

