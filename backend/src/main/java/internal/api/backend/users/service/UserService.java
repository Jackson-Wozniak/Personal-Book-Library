package internal.api.backend.users.service;

import internal.api.backend.users.entity.User;
import internal.api.backend.users.entity.WebToken;
import internal.api.backend.users.exceptions.RegistrationException;
import internal.api.backend.users.exceptions.UserNotFoundException;
import internal.api.backend.users.payload.UserCredentialsRequest;
import internal.api.backend.users.repository.UserRepository;
import internal.api.backend.users.utils.PasswordValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final WebTokenService webTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException("Cannot find user"));
    }

    public boolean accountExists(String email){
        return userRepository.findById(email).isPresent();
    }

    public String registerUser(UserCredentialsRequest request) {
        if(request.getEmail().isEmpty() || request.getPassword().isEmpty()){
            throw new RegistrationException("All fields must be filled");
        }
        if(accountExists(request.getEmail())){
            throw new RegistrationException("username is taken");
        }
        if(!PasswordValidator.containsRequiredComponents(request.getPassword())){
            throw new RegistrationException("password does not contain necessary characters");
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(request.getEmail(), encodedPassword);
        userRepository.save(user);

        WebToken confirmationToken = webTokenService.generateToken(user);

        webTokenService.saveWebToken(confirmationToken);

        return confirmationToken.getTokenValue();
    }
}
