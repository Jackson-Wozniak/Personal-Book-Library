package internal.api.backend.users.service;

import internal.api.backend.users.entity.User;
import internal.api.backend.users.entity.WebToken;
import internal.api.backend.users.exceptions.WebTokenException;
import internal.api.backend.users.repository.WebTokenRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WebTokenService {

    private final WebTokenRepository webTokenRepository;
    private static final String tokenExceptionMessage = "Cannot find matching account token";

    public void saveWebToken(WebToken token) {
        webTokenRepository.save(token);
    }

    public WebToken findWebToken(String tokenValue) {
        return webTokenRepository.findByTokenValue(tokenValue)
                .orElseThrow(() -> new WebTokenException(tokenExceptionMessage));
    }

    public User findUserFromTokenValue(String tokenValue){
        return webTokenRepository.findByTokenValue(tokenValue)
                .orElseThrow(() -> new WebTokenException(tokenExceptionMessage)).getUser();
    }

    @Transactional
    public long deleteExpiredTokens(){
        webTokenRepository.deleteExpiredTokens(LocalDateTime.now());
        return webTokenRepository.findDeletedRowCount();
    }

    public WebToken generateToken(User user){
        String token = UUID.randomUUID().toString();
        return new WebToken(user, token, LocalDateTime.now());
    }
}
