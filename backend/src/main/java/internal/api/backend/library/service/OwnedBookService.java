package internal.api.backend.library.service;

import internal.api.backend.library.client.ExternalBookAPIClient;
import internal.api.backend.library.entity.OwnedBook;
import internal.api.backend.library.repository.OwnedBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OwnedBookService {

    private final OwnedBookRepository ownedBookRepository;
    private final ExternalBookAPIClient externalBookAPIClient;

    public OwnedBook retrieveBookByISBN(String isbn){
        return ownedBookRepository.findById(isbn)
                .orElseGet(() -> externalBookAPIClient.getBookByISBN(isbn).toOwnedBook());
    }

    public boolean bookExists(String isbn){
        return ownedBookRepository.findById(isbn).isPresent();
    }
}
