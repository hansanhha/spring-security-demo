package study.security.this_will_protect_you.service.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import study.security.this_will_protect_you.config.SecurityUser;

//@Service
//public class DBAuthenticationProviderService implements AuthenticationProvider {
//
//    private final JpaUserDetailsService userDetailsService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final SCryptPasswordEncoder sCryptPasswordEncoder;
//
//    public DBAuthenticationProviderService(JpaUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, SCryptPasswordEncoder sCryptPasswordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.sCryptPasswordEncoder = sCryptPasswordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String name = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        SecurityUser user = (SecurityUser) userDetailsService.loadUserByUsername(name);
//
//        switch (user.getUser().getAlgorithm()) {
//            case BCRYPT -> {
//                return checkPassword(user, password, bCryptPasswordEncoder);
//            }
//            case SCRYPT -> {
//                return checkPassword(user, password, sCryptPasswordEncoder);
//            }
//        }
//
//        throw new BadCredentialsException("Bad credentials");
//    }
//
//    private Authentication checkPassword(SecurityUser user, String rawPassword, PasswordEncoder passwordEncoder) {
//        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
//        } else {
//            throw new BadCredentialsException("Bad credentials");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
