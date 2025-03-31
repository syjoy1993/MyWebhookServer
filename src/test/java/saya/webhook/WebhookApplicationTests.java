package saya.webhook;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-secret.properties") // ✅ 요거 한 줄!
class WebhookApplicationTests {

    @Test
    void contextLoads() {
    }

}
