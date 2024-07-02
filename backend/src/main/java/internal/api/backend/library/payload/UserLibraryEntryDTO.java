package internal.api.backend.library.payload;

import internal.api.backend.library.entity.UserLibraryEntry;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLibraryEntryDTO {

    private BookDTO book;
    private String status;
    private String source;

    public UserLibraryEntryDTO(UserLibraryEntry userLibraryEntry){
        this.book = userLibraryEntry.getOwnedBook().toDTO();
        this.status = userLibraryEntry.getStatus().toString();
        this.source = userLibraryEntry.getSource().toString();
    }
}
