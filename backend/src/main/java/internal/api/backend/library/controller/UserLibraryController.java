package internal.api.backend.library.controller;

import internal.api.backend.library.entity.UserLibrary;
import internal.api.backend.library.payload.UserLibraryDTO;
import internal.api.backend.library.service.UserLibraryService;
import internal.api.backend.users.entity.User;
import internal.api.backend.users.service.WebTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/library")
@AllArgsConstructor
public class UserLibraryController {

    private final UserLibraryService userLibraryService;
    private final WebTokenService webTokenService;

    @GetMapping
    public ResponseEntity<UserLibraryDTO> getUserLibrary(@RequestParam("token") String token){
        User user = webTokenService.findUserFromTokenValue(token);

        return ResponseEntity.ok(userLibraryService.findLibraryByUser(user).toDTO());
    }
}
