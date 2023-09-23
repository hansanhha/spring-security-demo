package study.security.this_will_protect_you.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    private final CustomAuthenticationProvider authenticationProvider;
//    private final CustomInMemeryUserDetailsService userDetailsService;
//    private final DataSource dataSource;

//    public ProjectConfig(CustomAuthenticationProvider authenticationProvider, CustomInMemeryUserDetailsService userDetailsService, DataSource dataSource) {
//        this.authenticationProvider = authenticationProvider;
//        this.userDetailsService = userDetailsService;
//        this.dataSource = dataSource;
//    }

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }


//    public ProjectConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authz) -> authz
                        .requestMatchers("/save").permitAll().anyRequest().authenticated()
                );

        http.httpBasic(c -> {
            c.realmName("OTHER");
            c.authenticationEntryPoint(new CustomEntryPoint());
        });
//                .userDetailsService(new JdbcUserDetailsManager(dataSource));
        http.authenticationProvider(authenticationProvider);
        return http.build();
    }

//    @Bean // BeanCreationException
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().anyRequest().requestMatchers("/save");
//    }
}
