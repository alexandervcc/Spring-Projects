package acc.webflux.webflux.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import acc.webflux.webflux.model.New;
import acc.webflux.webflux.repository.NewsRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class NewsControllerTest {
    NewsRepository newsRepository;
    WebTestClient testClient;

    @BeforeEach
    void setUp() {
        newsRepository = Mockito.mock(NewsRepository.class);
        testClient = WebTestClient.bindToController(
                new NewsController(newsRepository))
                .build();
    }

    @Test
    public void whenGetRequestWhenRecentThenReturnNews() {
        New[] news = {
                createNew("1"),
                createNew("2"),
                createNew("3"),
                createNew("4"),
                createNew("5"),
                createNew("6"),
                createNew("7"),
                createNew("8"),
                createNew("9"),
                createNew("10"),
                createNew("11"),
                createNew("12"),
                createNew("13"),
                createNew("14"),
                createNew("15"),
                createNew("16"),
        };

        Flux<New> NewFlux = Flux.just(news);

        when(newsRepository.findAll()).thenReturn(NewFlux);

        testClient.get().uri("/api/news")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$").isNotEmpty()
                .jsonPath("$[0].id").isEqualTo(news[0].getId().toString())
                .jsonPath("$[0].title").isEqualTo("New 1")
                .jsonPath("$[1].id").isEqualTo(news[1].getId().toString())
                .jsonPath("$[11].id").isEqualTo(news[11].getId().toString())
                .jsonPath("$[12]").doesNotExist();

        testClient.get().uri("/api/news")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(New.class)
                .contains(Arrays.copyOf(news, 12));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldSaveNew() {
        Mono<New> unsavedNewMono = Mono.just(createNew("1"));
        New savedNew = createNew("1");
        Flux<New> savedNewMono = Flux.just(savedNew);

        when(newsRepository.saveAll(any(Mono.class))).thenReturn(savedNewMono);

        testClient.post()
                .uri("/api/news/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(unsavedNewMono, New.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(New.class)
                .isEqualTo(savedNew);
    }

    private New createNew(String newId) {
        return New.builder().id(newId).title("New " + newId).build();
    }
}
