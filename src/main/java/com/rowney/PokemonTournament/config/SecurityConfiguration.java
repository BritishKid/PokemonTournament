//package com.rowney.PokemonTournament.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SecurityConfiguration extends SpringBootWebSecurityConfiguration {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/h2-console/**").permitAll();
//
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }
//}