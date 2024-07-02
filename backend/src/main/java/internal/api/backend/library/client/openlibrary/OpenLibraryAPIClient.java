package internal.api.backend.library.client.openlibrary;

import internal.api.backend.library.client.BookResponse;
import internal.api.backend.library.client.ExternalBookAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class OpenLibraryAPIClient implements ExternalBookAPIClient {

    private final RestTemplate restTemplate;

    public OpenLibraryAPIClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private static final String ROOT_URL = "https://openlibrary.org";
    private static final String ROOT_COVER_URL = "https://covers.openlibrary.org";

    @Override
    public Map<String, String> mapISBNsToTitles(String title) {
        return Map.of();
    }

    @Override
    public BookResponse getBookByISBN(String isbn) {
        return null;
    }

    @Override
    public String getCoverURL(String isbn) {
        String URL = ROOT_COVER_URL + "/b/isbn/" + isbn + ".json";
        OpenLibraryCoverReponse response = restTemplate.getForObject(URL, OpenLibraryCoverReponse.class);
        if(response != null) return response.getSourceURL();
        return "None found";
    }
}
