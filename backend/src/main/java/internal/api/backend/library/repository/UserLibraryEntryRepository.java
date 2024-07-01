package internal.api.backend.library.repository;

import internal.api.backend.library.entity.UserLibraryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLibraryEntryRepository extends JpaRepository<UserLibraryEntry, Long> {
}
