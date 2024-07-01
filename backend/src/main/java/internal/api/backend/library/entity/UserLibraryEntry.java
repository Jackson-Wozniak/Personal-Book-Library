package internal.api.backend.library.entity;

import internal.api.backend.library.enums.OwnedBookSource;
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

    @Enumerated(value = EnumType.STRING)
    private OwnedBookSource source;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_title", nullable = false)
    private OwnedBook ownedBook;

    public UserLibraryEntry(UserLibrary library, OwnedBook ownedBook,
                            OwnedBookSource source, OwnedBookStatus status){
        this.userLibrary = library;
        this.ownedBook = ownedBook;
        this.source = source;
        this.status = status;
    }
}
