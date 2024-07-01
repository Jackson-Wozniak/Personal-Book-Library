package internal.api.backend.library.entity.listener;

import internal.api.backend.library.entity.OwnedBook;
import internal.api.backend.library.service.OwnedBookService;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OwnedBookListener {

    private final OwnedBookService ownedBookService;
    private static final Logger logger = LoggerFactory.getLogger("bookLogger");

    public OwnedBookListener(@Lazy OwnedBookService ownedBookService) {
        this.ownedBookService = ownedBookService;
    }

    @PrePersist
    public void beforeSave(OwnedBook ownedBook){
        if(!ownedBookService.bookExists(ownedBook.getIsbn())){
            //print to log that new book is saved from API
            logger.info("New book saved isbn={}, title={}", ownedBook.getIsbn(), ownedBook.getTitle());
        }
    }
}
