package acc.webflux.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acc.webflux.webflux.model.Author;
import acc.webflux.webflux.services.interfaces.AuthorService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/author")
@AllArgsConstructor
public class AuthorController {
  private AuthorService authorService;

  @GetMapping(path = "/{id}")
  public Mono<Author> getAuthorById(@PathVariable("id") Integer id) {
    return this.authorService.findById(id);
  }

  @PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
  public Mono<Author> createNewAuthor(@RequestBody Mono<Author> author) {
    return this.authorService.saveAuthor(author);
  }
}
