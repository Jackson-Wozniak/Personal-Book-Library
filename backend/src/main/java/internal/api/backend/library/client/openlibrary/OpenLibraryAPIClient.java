package internal.api.backend.library.client.openlibrary;

import internal.api.backend.library.client.BookResponse;
import internal.api.backend.library.client.ExternalBookAPIClient;
import org.springframework.stereotype.Component;

import java.util.Map;

public class OpenLibraryAPIClient implements ExternalBookAPIClient {

    @Override
    public Map<String, String> mapISBNsToTitles(String title) {
        return Map.of();
    }

    @Override
    public BookResponse getBookByISBN(String isbn) {
        return null;
    }

    @Override
    public String getCoverURL(String title) {
        return null;
    }
}
