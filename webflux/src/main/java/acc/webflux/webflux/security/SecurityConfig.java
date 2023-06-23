package acc.webflux.webflux.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import acc.webflux.webflux.repository.UserRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@AllArgsConstructor
public class SecurityConfig {
  private UserRepository userRepository;

  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    http.csrf().disable();
    
    http.authorizeExchange()
        .pathMatchers(HttpMethod.GET, "/api/**").permitAll()
        .anyExchange().permitAll();

    return http.build();
  }

  @Bean
  ReactiveUserDetailsService reactiveUserDetailsService() {
    return new ReactiveUserDetailsService() {
      @Override
      public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
            .map(userMono -> {
              return (UserDetails) userMono;
            });
      }
    };
  }
}
