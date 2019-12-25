package com.jbs.JobbSokerDig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //Access for all (don't forget to add styles and images here)
                .antMatchers("/").permitAll()
                .antMatchers("/images/tomte2.png").permitAll()
                .antMatchers("/loginStyle.css").permitAll()
                .antMatchers("/aboutUs").permitAll()

                //Only Users
                .antMatchers("/userMain").hasAnyRole("USER")
                .antMatchers("/userProfile").hasAnyRole("USER")
                .antMatchers("/userEditProfile").hasAnyRole("USER")
                .antMatchers("/userMyOffers").hasAnyRole("USER")

                //Only companys
                .antMatchers("/companyMain").hasAnyRole("COMPANY")
                .antMatchers("/companyProfile").hasAnyRole("COMPANY")
                .antMatchers("/companyEditProfile").hasAnyRole("COMPANY")
                .antMatchers("/companyCreateOffer").hasAnyRole("COMPANY")
                        //This one should maybe be public?
                .antMatchers("/listCandidate").hasAnyRole("COMPANY")

                .anyRequest().authenticated()
                .and()

                //Login Stuff
                .formLogin().defaultSuccessUrl("/successLogin", true)
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/");
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        //KOM IHÅG ATT TA BORT OCH ÄNDRA TILL EN SÄKER USER
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("123").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("company").password("123").roles("COMPANY").build());
        return manager;
    }


}
