package acc.webflux.webflux.services.interfaces;

import acc.webflux.webflux.model.Author;
import reactor.core.publisher.Mono;

public interface AuthorService {
  Mono<Author> saveAuthor(Mono<Author> author);

  Mono<Author> findById(Integer authorId);

}
