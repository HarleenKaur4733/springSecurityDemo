package com.security.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable csrf for testing/api use
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register").permitAll() // register is public
                        .anyRequest().authenticated() // everything else needs login
                )
                .formLogin(form -> form.defaultSuccessUrl("/", true)) // enables Form Login UI
                .httpBasic(Customizer.withDefaults()); // enables Basic Auth 🟢

        return http.build();
    }

    // In memory authentication
    // you can pass multiple users here
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("user1")
                .password("{noop}password1") // <-- NO ENCODING, plain login
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withUsername("admin1")
                .password("{noop}password2")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
