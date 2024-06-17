package internal.api.backend.users.repository;

import internal.api.backend.users.entity.WebToken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WebTokenRepository extends JpaRepository<WebToken, Long> {

    Optional<WebToken> findByTokenValue(String token);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM web_tokens t " +
            "WHERE t.expires_at <= :now", nativeQuery = true)
    void deleteExpiredTokens(LocalDateTime now);

    @Query(value = "SELECT ROW_COUNT() as DelRowCount", nativeQuery = true)
    int findDeletedRowCount();
}
