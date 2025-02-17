package com.Festify.EventManagement.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Festify.EventManagement.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private MyUserDetailService userdetails;

    public SecurityConfig(MyUserDetailService userdetails) {
        this.userdetails = userdetails;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/events**","/venue/**").permitAll()
                .requestMatchers("/eventhosting/**", "/venuehosting/**").permitAll()
                .requestMatchers("/signin/**", "/signup/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // standard oauth2 endpoints
                .requestMatchers("/oauth2/**", "/login/**", "/error").permitAll()
                .anyRequest().authenticated()
            )
            // .formLogin(form -> form
            //                     .loginPage("/signin")
            //                     .defaultSuccessUrl("/", true)
            // )   
            .oauth2Login(oauth -> oauth
                                    .loginPage("/signup")
                                    .defaultSuccessUrl("/", true)
            )
            .logout(logout -> logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/")  
                                .permitAll()                  
            )       
            // Use stateless session management if desired
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
            .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userdetails);
        return provider;
    }
}
