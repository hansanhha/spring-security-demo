package study.security.this_will_protect_you.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

//@Configuration
//public class PasswordEncoderConfig {
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SCryptPasswordEncoder sCryptPasswordEncoder() {
//        return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
//    }
//}
