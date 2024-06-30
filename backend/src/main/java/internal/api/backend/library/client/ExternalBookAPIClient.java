package internal.api.backend.library.client;

import java.util.Map;

public interface ExternalBookAPIClient {

    Map<String, String> mapISBNsToTitles(String title);

    BookResponse getBookByISBN(String isbn);

    String getCoverURL(String isbn);
}
