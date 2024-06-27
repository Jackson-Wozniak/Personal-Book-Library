package internal.api.backend.library.entity;

import internal.api.backend.library.enums.OwnedBookSource;
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
public class OwnedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "number_of_pages")
    private Integer pageCount;

    @Enumerated(value = EnumType.STRING)
    private OwnedBookSource source;

    public OwnedBook(String title,
                     String isbn,
                     String author,
                     Integer pageCount,
                     OwnedBookSource source) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.pageCount = pageCount;
        this.source = source;
    }
}
