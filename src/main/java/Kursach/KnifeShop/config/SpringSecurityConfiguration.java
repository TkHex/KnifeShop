package Kursach.KnifeShop.config;

import Kursach.KnifeShop.model.UserAuthority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .requestMatchers("/registration", "/login", "/knifes/**", "/firms/**", "/cart/**", "/review/**").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/knifes").hasAuthority(UserAuthority.PLACE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.DELETE, "/complect").hasAuthority(UserAuthority.PLACE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.GET, "/computer/**").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.POST, "/computer").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.POST, "/review").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.DELETE, "/review").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.GET, "/user").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.POST, "/user").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.DELETE, "/user").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
                                .anyRequest().hasAuthority(UserAuthority.FULL.getAuthority()))
                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
