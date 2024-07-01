package internal.api.backend.library.client;

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
    private Integer pageCount;

    public BookResponse(Builder builder){
        this.title = builder.title.orElse("N/A");
        this.isbn = builder.isbn.orElse("N/A");
        this.pageCount = builder.pageCount.orElse(-1);
    }

    /*uses Optional<> because it is mapped from unique
    ExternalAPIBookResponse classes that may not contain every field*/
    public static class Builder{
        private final Optional<String> title;
        private Optional<String> isbn;
        private Optional<Integer> pageCount;

        public Builder(String title){
            this.title = Optional.of(title);
        }

        public Builder isbn(String isbn){
            this.isbn = Optional.of(isbn);
            return this;
        }

        public Builder info(int pageCount){
            this.pageCount = Optional.of(pageCount);
            return this;
        }

        public BookResponse build(){
            return new BookResponse(this);
        }
    }
}
