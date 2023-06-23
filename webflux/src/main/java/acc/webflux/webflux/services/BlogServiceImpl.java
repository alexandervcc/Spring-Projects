package acc.webflux.webflux.services;

import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import acc.webflux.webflux.model.New;
import acc.webflux.webflux.services.interfaces.BlogService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {
    private WebClient webClient;

    @Override
    public Mono<New> apiGetAuthorBlogs(Integer blogId) {
        Mono<New> blog = webClient
                .get()
                .uri("/blogs/{id}", blogId)
                .retrieve()
                .bodyToMono(New.class);

        blog
                .timeout(Duration.ofSeconds(1))
                .subscribe(
                    blogObtained -> {                }, 
                    error -> {                }
                );

        return null;
    }

}
