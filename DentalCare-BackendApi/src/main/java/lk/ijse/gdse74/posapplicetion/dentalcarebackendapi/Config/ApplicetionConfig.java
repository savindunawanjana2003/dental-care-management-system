package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Config;

import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Repositry.SystemUserRepoSitory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.List;
/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 4:36 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */
@Configuration
@RequiredArgsConstructor
public class ApplicetionConfig {
    private final SystemUserRepoSitory userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByusername(username)
                .map(user -> new org.springframework.security.core.userdetails
                        .User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority
                                ("ROLE_"+user.getRole().name()))
                )).orElseThrow(
                        () -> new UsernameNotFoundException
                                ("User not found with username: " + username)
                );
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
