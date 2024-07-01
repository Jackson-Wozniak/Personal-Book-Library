package internal.api.backend.library.service;

import internal.api.backend.library.repository.UserLibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserLibraryService {

    private final UserLibraryRepository userLibraryRepository;
    private final OwnedBookService ownedBookService;
}
