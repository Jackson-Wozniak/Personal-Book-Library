package internal.api.backend.library.repository;

import internal.api.backend.library.entity.OwnedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnedBookRepository extends JpaRepository<OwnedBook, String> {
}
