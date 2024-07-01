package internal.api.backend.library.service;

import internal.api.backend.library.client.ExternalBookAPIClient;
import internal.api.backend.library.repository.OwnedBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OwnedBookService {

    private final OwnedBookRepository ownedBookRepository;
    private final ExternalBookAPIClient externalBookAPIClient;
}
