package internal.api.backend.library.client;

import java.util.Map;

public interface ExternalBookAPIClient<T> {

    //key is the ISBN, value is the full title of the edition
    Map<String, String> getISBNsByTitle(String title);

    T getBookByISBN();
}
