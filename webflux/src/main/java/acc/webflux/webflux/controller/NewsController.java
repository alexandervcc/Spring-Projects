package acc.webflux.webflux.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import acc.webflux.webflux.model.New;
import acc.webflux.webflux.repository.NewsRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(path = "/api/news")
@AllArgsConstructor
public class NewsController {
    private NewsRepository newsRepository;

    @GetMapping(path = "")
    public Flux<New> getRecentNews() {
        return this.newsRepository.findAll().take(12);
    }

    @GetMapping(path = "/{id}")
    public Mono<New> getNewById(@PathVariable("id") String id) {
        return this.newsRepository.findById(id);
    }

    @PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<New> createNew1(@RequestBody Mono<New> monoNew) {
        return this.newsRepository.saveAll(monoNew).next();
    }

    @PostMapping(path = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<New> createNew2(@RequestBody Mono<New> monoNew) {
        return monoNew.flatMap(newsRepository::save);
    }

}
