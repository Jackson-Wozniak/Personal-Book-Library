package internal.api.backend.library.client.openlibrary;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import internal.api.backend.library.client.BookResponse;
import lombok.Getter;
import lombok.Setter;

//Used for RestTemplate.getForObject(URL, OpenLibraryBookResponse.class) mappings
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibraryBookResponse {

    @JsonAlias("title")
    private String title;

    @JsonAlias("number_of_pages")
    private int pageCount;

    @JsonAlias("isbn_13")
    private String isbn;

    @JsonAlias("publish_date")
    private String publishDate;

    public BookResponse toBookResponse(){
        return new BookResponse.Builder(title)
                .publishDate(publishDate)
                .pageCount(pageCount)
                .isbn(isbn)
                .build();
    }
}
