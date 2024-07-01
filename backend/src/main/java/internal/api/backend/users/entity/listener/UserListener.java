package internal.api.backend.users.entity.listener;

import internal.api.backend.library.entity.OwnedBook;
import internal.api.backend.library.service.OwnedBookService;
import internal.api.backend.users.entity.User;
import internal.api.backend.users.service.UserService;
import jakarta.persistence.PrePersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class UserListener {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger("userLogger");

    public UserListener(@Lazy UserService userService) {
        this.userService = userService;
    }

    @PrePersist
    public void beforeSave(User user){
        if(!userService.accountExists(user.getEmail())){
            logger.info("New User Created");
        }
    }
}
