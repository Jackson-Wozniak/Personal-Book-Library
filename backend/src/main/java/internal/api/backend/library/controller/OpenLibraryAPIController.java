package internal.api.backend.library.controller;

import internal.api.backend.library.client.BookResponse;
import internal.api.backend.library.client.ExternalBookAPIClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/open_library")
public class OpenLibraryAPIController {

    private final ExternalBookAPIClient openLibraryAPIClient;

    public OpenLibraryAPIController(@Qualifier("openLibraryAPIClient") ExternalBookAPIClient externalBookAPIClient){
        this.openLibraryAPIClient = externalBookAPIClient;
    }

    @GetMapping(value = "/isbn_title_map/{title}")
    public ResponseEntity<Map<String, String>> getISBNWithTitles(@PathVariable("title") String title){
        return ResponseEntity.ok(openLibraryAPIClient.mapISBNsToTitles(title));
    }

    @GetMapping(value = "/{isbn}")
    public ResponseEntity<BookResponse> getBookByISBN(@PathVariable("isbn") String isbn){
        return ResponseEntity.ok(openLibraryAPIClient.getBookByISBN(isbn));
    }
}
