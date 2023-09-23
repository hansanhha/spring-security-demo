package study.security.this_will_protect_you.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    private final CustomAuthenticationProvider authenticationProvider;
    private final CustomInMemeryUserDetailsService userDetailsService;

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider, CustomInMemeryUserDetailsService userDetailsService) {
        this.authenticationProvider = authenticationProvider;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authz) -> authz
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .userDetailsService(userDetailsService)
                .authenticationProvider(authenticationProvider);
        return http.build();
    }
}
