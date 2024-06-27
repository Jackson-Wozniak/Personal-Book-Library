package internal.api.backend.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "userLibrary")
@Table(name = "user_libraries")
@Getter
@Setter
@NoArgsConstructor
public class UserLibrary {

    @Id
    private String username;

    @OneToMany(mappedBy = "userLibrary", cascade = CascadeType.ALL)
    private List<UserLibraryEntry> entries = new ArrayList<>();

    /*
    TODO: Operations allowed
        1. get all books of type source
        2. boolean if exists in library
        3. add to library
        4. remove from library
     */
}
