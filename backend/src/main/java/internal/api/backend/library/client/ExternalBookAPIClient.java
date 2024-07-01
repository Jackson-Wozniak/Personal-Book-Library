package internal.api.backend.library.client;

import java.util.Map;

/*
The idea here is to allow for seamless migration to different APIs if needed.
To change the API provider, go to ExternalBookAPIConfig and set a different API as the primary bean,
    or use @Qualifier in class constructors that define the ExternalBookAPIClient as dependency
 */
public interface ExternalBookAPIClient {

    Map<String, String> mapISBNsToTitles(String title);

    BookResponse getBookByISBN(String isbn);

    String getCoverURL(String isbn);
}
