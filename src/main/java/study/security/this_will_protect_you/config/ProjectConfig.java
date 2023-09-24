package study.security.this_will_protect_you.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import study.security.this_will_protect_you.service.security.DBAuthenticationProviderService;

@Configuration
public class ProjectConfig {

    private final DBAuthenticationProviderService authenticationProvider;


    public ProjectConfig(DBAuthenticationProviderService authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/hello").hasRole("ADMIN")
                        .requestMatchers("/ciao").hasRole("MANAGER")
                        .anyRequest().permitAll()
                );

        http.formLogin(c -> {
            c.defaultSuccessUrl("/", true);
        });

        http.httpBasic(Customizer.withDefaults());

        http.authenticationProvider(authenticationProvider);
        return http.build();
    }
}
