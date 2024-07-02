package internal.api.backend.library.client;

import internal.api.backend.library.client.openlibrary.OpenLibraryAPIClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
@AllArgsConstructor
public class ExternalBookAPIConfig {

    private final RestTemplate restTemplate;

    @Bean
    @Primary
    public ExternalBookAPIClient openLibraryAPIClient(){
        return new OpenLibraryAPIClient(restTemplate);
    }
}
