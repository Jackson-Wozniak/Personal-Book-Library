package internal.api.backend.library.entity;

import internal.api.backend.library.enums.OwnedBookStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "userLibraryEntry")
@Table(name = "user_library_entries")
@Getter
@Setter
@NoArgsConstructor
public class UserLibraryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_library_id")
    private UserLibrary userLibrary;

    @Enumerated(value = EnumType.STRING)
    private OwnedBookStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_title", nullable = false)
    private OwnedBook ownedBook;

    public UserLibraryEntry(UserLibrary library, OwnedBook ownedBook, OwnedBookStatus status){
        this.userLibrary = library;
        this.ownedBook = ownedBook;
        this.status = status;
    }
}
