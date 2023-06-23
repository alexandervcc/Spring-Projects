package acc.webflux.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import acc.webflux.webflux.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
  Mono<User> findByUsername(String username);

}
