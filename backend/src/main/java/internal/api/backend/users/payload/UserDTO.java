package internal.api.backend.users.payload;

import internal.api.backend.users.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {

    private String email;

    public UserDTO(User user){
        this.email = user.getEmail();
    }
}
