package com.jbs.JobbSokerDig.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                .antMatchers("/images/Adroit-logo-shortcut.png").permitAll()
                .antMatchers("/images/profileExample.jpg").permitAll()
                .antMatchers("/images/adroit-logo-ex.jpg").permitAll()
                .antMatchers("/images/adroit-logo-transparent.png").permitAll()
                .antMatchers("/images/logo-transparent-white.png").permitAll()
                .antMatchers("/images/adroit-transparent-logo-small.png").permitAll()
                .antMatchers("/style.css").permitAll()
                //Public for testing purpose
                .antMatchers("/test").permitAll()
                .antMatchers("/test2").permitAll()
                .antMatchers("/init").permitAll()

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

    @Autowired
    private SecurityLoginDetailsService securityLoginDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(securityLoginDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}
