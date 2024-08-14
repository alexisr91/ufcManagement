package ufc.managementfighters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //ENABLE IT FOR THE URL PATH
public class SecurityConfig {

    /**
     * A series of Spring Security filters intercept each request & work together to identify if Authentication is required or not
     * 
     * 
     */
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(auth -> auth

                // The security filter chain is a sequence of filters that Spring Security applies to each incoming HTTP request. These filters work together to perform various security-related tasks.
                // In this example the security rule is saying every route be public and require the user authentication 
                            .requestMatchers("/").permitAll()
                            .requestMatchers("/contact").permitAll() 
                            .requestMatchers("/store/**").permitAll()
                            .requestMatchers("/register", "/images/**").permitAll() 
                            .requestMatchers("/login").permitAll() 
                            .requestMatchers("/profile/**").permitAll()
                            .requestMatchers("/logout").permitAll()
                            .requestMatchers("/css/**","/js/**", "/image/**").permitAll()
                            .anyRequest().authenticated()
                )
                

                .formLogin(form -> form

                // Redirect the user if successfull authentication
                            .defaultSuccessUrl("/",true)
                            
                )
                .logout(config-> config.logoutSuccessUrl("/"))
                // Redirect the user if log the f out
                .build();
    }

    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
