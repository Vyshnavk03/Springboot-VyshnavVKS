package com.vyshvks.product.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)// this  annotation is used because in controller class both we have specified a annotation to work that authorication 
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf-> csrf.disable())//csrf we disableing because in this we are not using session and rest API is stateless so no use of this.
                .authorizeHttpRequests(request-> {
                    request.requestMatchers(HttpMethod.GET, "/api/**").permitAll();
                    request.anyRequest().authenticated();
                } ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){// this class is created so that password can be encrypted won't store in raw
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))//that class encryption is used here
                .roles("ADMIN")
                .build();

        UserDetails seller  = User.builder()
                .username("seller")
                .password(passwordEncoder().encode("seller"))
                .roles("SELLER")
                .build();

        return new InMemoryUserDetailsManager(admin, seller);
    }
}
