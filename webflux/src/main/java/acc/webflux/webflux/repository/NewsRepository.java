package acc.webflux.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import acc.webflux.webflux.model.New;
import reactor.core.publisher.Mono;

public interface NewsRepository extends ReactiveCrudRepository<New, String> {
  Mono<New> findByTitle(String title);
}
