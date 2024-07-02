package internal.api.backend.library.repository;

import internal.api.backend.library.entity.UserLibrary;
import internal.api.backend.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserLibraryRepository extends JpaRepository<UserLibrary, String> {

    @Query("SELECT ul FROM userLibrary ul LEFT JOIN FETCH ul.entries WHERE ul.user = :user")
    Optional<UserLibrary> findByUser(User user);
}
