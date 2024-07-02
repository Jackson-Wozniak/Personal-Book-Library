package internal.api.backend.library.entity;

import internal.api.backend.library.entity.listener.OwnedBookListener;
import internal.api.backend.library.payload.BookDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
This entity is specifically used as a way to store information about books for user libraries.
    With that said is not stored in the library directly
There will be other entities that store more information about books (using the external book API)
    but this one is a simplified version to get the basics of books in a users library
 */
@Entity(name = "ownedBook")
@Table(name = "owned_books")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(OwnedBookListener.class)
public class OwnedBook {

    @Id
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "number_of_pages")
    private Integer pageCount;

    public OwnedBook(String title,
                     String isbn,
                     String author,
                     Integer pageCount) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.pageCount = pageCount;
    }

    public BookDTO toDTO(){
        return new BookDTO(this);
    }
}
