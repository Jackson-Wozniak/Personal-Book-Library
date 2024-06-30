package internal.api.backend.library.client;

import internal.api.backend.library.client.openlibrary.OpenLibraryAPIClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ExternalBookAPIConfig {

    @Bean
    @Primary
    public ExternalBookAPIClient openLibraryAPIClient(){
        return new OpenLibraryAPIClient();
    }
}
