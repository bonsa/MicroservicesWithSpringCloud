package demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RefreshScope
@ConfigurationProperties(prefix="wordConfig")
public class LuckyWordController {

    String luckyWord;
    String preamble;
    String fullStatement;

    @PostConstruct
    private void init() {
        fullStatement = preamble + ": " + luckyWord;
    }

    @GetMapping("/lucky-word")
    public String showLuckyWord() {
        return fullStatement;
    }

    public String getLuckyWord() {
        return luckyWord;
    }

    public void setLuckyWord(String luckyWord) {
        this.luckyWord = luckyWord;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }
}
