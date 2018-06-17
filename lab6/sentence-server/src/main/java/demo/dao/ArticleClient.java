package demo.dao;

import demo.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ARTICLE")
public interface ArticleClient {

    @GetMapping("/")
    public Word getWord();
}
