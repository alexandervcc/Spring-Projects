package acc.webflux.webflux.services.interfaces;

import acc.webflux.webflux.model.New;
import reactor.core.publisher.Mono;

public interface BlogService {
    public Mono<New> apiGetAuthorBlogs(Integer blogId);
    
}
