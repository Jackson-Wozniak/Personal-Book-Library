package internal.api.backend.users.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCredentialsRequest {

    private String email;
    private String password;
}
