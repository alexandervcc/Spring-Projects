package acc.webflux.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import acc.webflux.webflux.model.Author;

public interface AuthorRepository extends ReactiveCrudRepository<Author, String> {

}
