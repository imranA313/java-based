package c2m.security.controller;

import c2m.security.dto.JwtAuthenticationResponse;
import c2m.security.dto.RefreshTokenRequest;
import c2m.security.dto.SignInRequest;
import c2m.security.dto.SignupRequest;
import c2m.security.entity.User;
import c2m.security.service.AuthenticationService;
import c2m.security.service.JwtService;
import c2m.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authenticationService.signupUser(signupRequest));
    }

    @GetMapping("/signing")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signInRequest(signInRequest));
    }

}
