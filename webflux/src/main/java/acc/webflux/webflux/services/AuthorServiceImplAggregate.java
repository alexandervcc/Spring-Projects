package acc.webflux.webflux.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import acc.webflux.webflux.model.Author;
import acc.webflux.webflux.model.New;
import acc.webflux.webflux.repository.AuthorRepository;
import acc.webflux.webflux.repository.NewsRepository;
import acc.webflux.webflux.services.interfaces.AuthorService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AuthorServiceImplAggregate implements AuthorService {
  private final AuthorRepository authorRepository;
  private final NewsRepository newsRepository;

  @Override
  public Mono<Author> saveAuthor(Mono<Author> author) {
    /*
     * return author
     * .flatMap(a -> {
     * List<New> authorNews = a.getNews();
     * a.setNews(new ArrayList<>());
     * a.setNewsIds(new HashSet<>());
     * return newsRepository.saveAll(authorNews)
     * .map(oneNew -> {
     * a.addNew(oneNew);
     * return a;
     * }).last();
     * })
     * .flatMap(authorRepository::save);
     */
    return null;
  }

  @Override
  public Mono<Author> findById(Integer authorId) {
    /*
     * return authorRepository.findById(authorId)
     * .flatMap(author -> {
     * return this.newsRepository.findAllById(author.getNewsIds())
     * .map(dbNew -> {
     * author.addNew(dbNew);
     * return author;
     * })
     * .last();
     * });
     */

    return null;
  }

}
