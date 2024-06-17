package internal.api.backend.users.controller;

import internal.api.backend.users.entity.User;
import internal.api.backend.users.entity.WebToken;
import internal.api.backend.users.payload.UserCredentialsRequest;
import internal.api.backend.users.service.UserService;
import internal.api.backend.users.service.WebTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
@AllArgsConstructor
public class UserSecurityController {

    private final UserService userService;
    private final WebTokenService webTokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserCredentialsRequest request){
        String webTokenValue = userService.registerUser(request);
        return ResponseEntity.ok(webTokenValue);
    }

    @PutMapping(value = "/login")
    public ResponseEntity<String> loginAsUser(@RequestBody UserCredentialsRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));

        WebToken token = webTokenService.generateToken(
                (User) userService.loadUserByUsername(authentication.getName()));
        webTokenService.saveWebToken(token);

        return ResponseEntity.ok(token.getTokenValue());
    }

    @GetMapping(value = "/test")
    public boolean testToken(@RequestParam("token") String token){
        User user = webTokenService.findUserFromTokenValue(token);
        return user != null;
    }
}
