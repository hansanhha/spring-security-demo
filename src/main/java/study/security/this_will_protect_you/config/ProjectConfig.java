package study.security.this_will_protect_you.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class ProjectConfig {

//    private final DBAuthenticationProviderService authenticationProvider;
//    private final JpaTokenRepository jpaTokenRepository;
//    private final StaticAuthenticationFilter staticAuthenticationFilter;

//    public ProjectConfig(DBAuthenticationProviderService authenticationProvider, JpaTokenRepository jpaTokenRepository) {
//        this.authenticationProvider = authenticationProvider;
//        this.jpaTokenRepository = jpaTokenRepository;
//    }




//    public ProjectConfig(DBAuthenticationProviderService authenticationProvider, StaticAuthenticationFilter staticAuthenticationFilter) {
//        this.authenticationProvider = authenticationProvider;
//        this.staticAuthenticationFilter = staticAuthenticationFilter;
//    }


//    @Bean
//    public CsrfTokenRepository customTokenRepository() {
//        return new CustomCsrfTokenRepository(jpaTokenRepository);
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers(HttpMethod.GET, "/a/b/**").authenticated()
//                        .requestMatchers(HttpMethod.POST, "/a").permitAll()
//                        .requestMatchers("/product/{code:^[0-9]*$}").permitAll()
//                        .requestMatchers("/email/{email:.*@.+\\.com}").permitAll()
                        .anyRequest().permitAll()
                );

//        http.formLogin(c -> {
//            c.defaultSuccessUrl("/", true);
//        });

        http.httpBasic(Customizer.withDefaults());
//        http.addFilterBefore(new RequestVlidationFilter(), BasicAuthenticationFilter.class);
//        http.addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class);
//        http.addFilterAt(staticAuthenticationFilter, BasicAuthenticationFilter.class);
//        http.addFilterAfter(new CsrfTokenLoggerFilter(), CsrfFilter.class);
//        http.authenticationProvider(authenticationProvider);

        http.csrf(c -> {
//            c.csrfTokenRepository(customTokenRepository());
            c.ignoringRequestMatchers("/ciao");
        });

        http.cors(c -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(
                        List.of("example.com", "example.org"));
                config.setAllowedMethods(
                        List.of("GET", "POST", "PUT", "DELETE"));
                return config;
            };
            c.configurationSource(source);
        });

        return http.build();
    }
}
