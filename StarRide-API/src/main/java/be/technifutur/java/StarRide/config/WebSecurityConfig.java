package be.technifutur.java.StarRide.config;


import be.technifutur.java.StarRide.config.jwt.JWTAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http, JWTAuthFilter jwtAuthFilter) throws Exception {
        http.csrf().disable();
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        // http.httpBasic().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests( (registry) -> {
            // registry.requestMatchers( request -> request.getRequestURI().length() > 500 ).denyAll()
            registry//.requestMatchers( HttpMethod.GET, "/room/**" ).permitAll()
                    //.requestMatchers( HttpMethod.POST, "/booking/**" ).authenticated()
                    //.requestMatchers( HttpMethod.PATCH, "/booking/{id:[0-9]+}/*" ).hasRole("ADMIN")
                    //.requestMatchers( HttpMethod.POST, "/auth/login").permitAll()
                    .anyRequest().permitAll();
        });

        return http.build();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
