package acc.webflux.webflux.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import acc.webflux.webflux.model.New;
import acc.webflux.webflux.repository.NewsRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Configuration
@AllArgsConstructor
public class NewsFunctionalController {
    private NewsRepository newsRepository;

    @Bean
    public RouterFunction<?> newsControllerFunction() {
        return route(GET("/api2/news")
                .and(queryParam("recent", t -> t != null)),
                this::recents)
                .andRoute(POST("/api2/news"), this::postNew);
    }

    public Mono<ServerResponse> recents(ServerRequest request) {
        return ServerResponse.ok()
                .body(newsRepository.findAll().take(12), New.class);
    }

    public Mono<ServerResponse> postNew(ServerRequest request) {
        return request.bodyToMono(New.class)
                .flatMap(monoNew -> newsRepository.save(monoNew))
                .flatMap(savedNew -> {
                    return ServerResponse
                            .created(URI.create("http:/ /localhost:8080/api2/news/" + savedNew.getId()))
                            .body(savedNew, New.class);
                });
    }
}
