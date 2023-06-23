package acc.webflux.webflux.repository;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import acc.webflux.webflux.model.New;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class NewsRepositoryTest {

  @Autowired
  NewsRepository newsRepository;

  private Flux<New> listNews = Flux.just(
      New.builder().title("A").build(),
      New.builder().title("B").build(),
      New.builder().title("C").build());

  @BeforeEach
  public void setup() {
    Flux<New> deleteAndInsert = newsRepository.deleteAll()
        .thenMany(newsRepository.saveAll(listNews));

    StepVerifier.create(deleteAndInsert)
        .expectNextCount(3)
        .verifyComplete();
  }

  @Test
  public void shouldSaveAndFetchIngredients() {
    StepVerifier.create(newsRepository.findAll())
        .recordWith(ArrayList::new)
        .thenConsumeWhile(x -> true)
        .consumeRecordedWith(ingredients -> {
          assertThat(ingredients).hasSize(3);

        })
        .verifyComplete();
    StepVerifier.create(newsRepository.findByTitle("A"))
        .assertNext(ingredient -> {
          ingredient.equals(New.builder().title("A").build());
        });
  }

}
