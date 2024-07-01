package internal.api.backend.library.repository;

import internal.api.backend.library.entity.UserLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLibraryRepository extends JpaRepository<UserLibrary, String> {
}
