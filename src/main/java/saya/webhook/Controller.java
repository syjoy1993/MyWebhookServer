package saya.webhook;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class Controller {


    private final WebClient webClient = WebClient.create();
    @Value("${discordToken}")
    private String discordToken;

    @PostMapping("/notion-webhook")
    public Mono<String> notionWebhook(@RequestBody Map<String, Object> payload) {
        String content = "Notion update!";
        return webClient.post()
                .uri(discordToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("content",content))
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> "Notion response: " + response);

    }
}
