package acc.webflux.webflux.services;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.annotation.DirtiesContext;

import acc.webflux.webflux.model.Author;
import acc.webflux.webflux.model.New;
import acc.webflux.webflux.repository.AuthorRepository;
import acc.webflux.webflux.repository.NewsRepository;
import acc.webflux.webflux.services.interfaces.AuthorService;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.hamcrest.MatcherAssert.assertThat;

@DataR2dbcTest
@DirtiesContext
public class AuthorServiceImplAggregateTest {
/*   @Autowired
  AuthorRepository authorRepository;

  @Autowired
  NewsRepository newsRepository;

  AuthorService authorService;

  @BeforeEach
  void setUp() {
    this.authorService = new AuthorServiceImplAggregate(authorRepository, newsRepository);
  }

  @Test
  void shouldSaveAndFetchData() {
    New n1 = New.builder().title("TA").description("DA").content("CA").build();
    New n2 = New.builder().title("TB").description("DB").content("CB").build();

    Author author = Author
        .builder()
        .name("Author A")
        .newsIds(new HashSet<Integer>())
        .news(new ArrayList<New>())
        .build();

    author.addNew(n1);
    author.addNew(n2);

    // TODO: corregir prueba que siempre es True cuando debe ser false
    StepVerifier
        .create(this.authorService.saveAuthor(Mono.just(author)))
        .assertNext(authorDb -> {
          System.out.print("xd:" + authorDb.getName());
          assertThat(authorDb.getName(), equals("Author B"));
        });
    ;

  } */

}