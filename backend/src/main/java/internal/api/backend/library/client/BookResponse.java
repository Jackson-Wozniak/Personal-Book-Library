package internal.api.backend.library.client;

import internal.api.backend.library.entity.OwnedBook;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class BookResponse {

    private String title;
    private String isbn;
    private String author;
    private Integer pageCount;

    public BookResponse(Builder builder){
        this.title = builder.title.orElse("N/A");
        this.isbn = builder.isbn.orElse("N/A");
        this.author = builder.author.orElse("N/A");
        this.pageCount = builder.pageCount.orElse(-1);
    }

    public OwnedBook toOwnedBook(){
        return new OwnedBook(title, isbn, author, pageCount);
    }

    /*uses Optional<> because it is mapped from unique
    ExternalAPIBookResponse classes that may not contain every field*/
    public static class Builder{
        private final Optional<String> title;
        private Optional<String> isbn;
        private Optional<String> author;
        private Optional<Integer> pageCount;

        public Builder(String title){
            this.title = Optional.of(title);
        }

        public Builder isbn(String isbn){
            this.isbn = Optional.of(isbn);
            return this;
        }

        public Builder info(String author, int pageCount){
            this.author = Optional.of(author);
            this.pageCount = Optional.of(pageCount);
            return this;
        }

        public BookResponse build(){
            return new BookResponse(this);
        }
    }
}
