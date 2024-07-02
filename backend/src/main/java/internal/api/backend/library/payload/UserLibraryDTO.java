package internal.api.backend.library.payload;

import internal.api.backend.library.entity.UserLibrary;
import internal.api.backend.library.entity.UserLibraryEntry;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserLibraryDTO {

    private List<UserLibraryEntryDTO> entries;

    public UserLibraryDTO(UserLibrary userLibrary){
        this.entries = userLibrary.getEntries().stream()
                .map(UserLibraryEntry::toDTO)
                .toList();
    }
}
