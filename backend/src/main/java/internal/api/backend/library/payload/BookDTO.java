package internal.api.backend.library.payload;

import internal.api.backend.library.entity.OwnedBook;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private String isbn;
    private String title;
    private String author;
    private Integer pageCount;

    public BookDTO(OwnedBook book){
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.pageCount = book.getPageCount();
    }
}
