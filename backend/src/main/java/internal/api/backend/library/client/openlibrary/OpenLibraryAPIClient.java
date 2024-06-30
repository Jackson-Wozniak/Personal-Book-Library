package internal.api.backend.library.client.openlibrary;

import internal.api.backend.library.client.ExternalBookAPIClient;

import java.util.Map;

public class OpenLibraryAPIClient implements ExternalBookAPIClient<OpenLibraryBookResponse> {
    @Override
    public Map<String, String> getISBNsByTitle(String title) {
        return Map.of();
    }

    @Override
    public OpenLibraryBookResponse getBookByISBN() {
        return null;
    }
}
