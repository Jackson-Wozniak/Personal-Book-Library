package internal.api.backend.library.service;

import internal.api.backend.library.entity.UserLibrary;
import internal.api.backend.library.repository.UserLibraryRepository;
import internal.api.backend.users.entity.User;
import internal.api.backend.users.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserLibraryService {

    private final UserLibraryRepository userLibraryRepository;
    private final OwnedBookService ownedBookService;

    public UserLibrary findLibraryByUser(User user){
        return userLibraryRepository.findByUser(user)
                .orElseThrow(() -> new UserNotFoundException("Cannot find library for user"));
    }
}
