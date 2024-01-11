package jobapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // Create your UserDetailsService implementation or use an existing one (e.g., custom service)
        // Here, we use an example with InMemoryUserDetailsManager
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$V7b/rCQ.J6.WTFo..I.R5OyhXK9tRpgzKv5P0biYpBDhNRCm5YbAi") // Encoded password "password"
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$V7b/rCQ.J6.WTFo..I.R5OyhXK9tRpgzKv5P0biYpBDhNRCm5YbAi") // Encoded password "admin"
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}

