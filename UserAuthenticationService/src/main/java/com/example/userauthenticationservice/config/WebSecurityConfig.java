package com.example.userauthenticationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//  			.authorizeRequests((authorizeRequests) ->
//                authorizeRequests
//                        .requestMatchers("/**").hasRole("USER")
//        )
//                .formLogin(withDefaults());
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().permitAll()
                )
                .csrf(csrf ->
                        csrf.disable()
                )
                .httpBasic(Customizer.withDefaults());
//                .authorizeHttpRequests(authz -> authz
//                        .anyRequest().authenticated() // Yêu cầu xác thực cho tất cả các yêu cầu
//                )
//                .httpBasic(withDefaults()); // Sử dụng xác thực HTTP Basic
        return http.build();
    }

    //
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                .anyRequest().requestMatchers("/ignore1", "/ignore2"); // Bỏ qua các đường dẫn này khỏi bảo mật
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}