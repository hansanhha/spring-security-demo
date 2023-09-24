package study.security.this_will_protect_you.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import study.security.this_will_protect_you.config.SecurityUser;
import study.security.this_will_protect_you.entity.User;
import study.security.this_will_protect_you.repository.UserRepository;

//@Service
//public class JpaUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public JpaUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Problem during authentication !"));
//        return new SecurityUser(user);
//    }
//}
