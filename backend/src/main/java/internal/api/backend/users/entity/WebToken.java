package internal.api.backend.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "webToken")
@Table(name = "web_tokens")
@Getter
@Setter
@NoArgsConstructor
public class WebToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token_value", nullable = false)
    private String tokenValue;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    private User user;

    public WebToken(User user, String tokenValue, LocalDateTime createdAt){
        this.user = user;
        this.tokenValue = tokenValue;
        this.createdAt = createdAt;
        this.expiresAt = createdAt.plusHours(12);
    }
}
