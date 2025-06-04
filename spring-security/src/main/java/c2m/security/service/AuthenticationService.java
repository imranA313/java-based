package c2m.security.service;

import c2m.security.dto.JwtAuthenticationResponse;
import c2m.security.dto.RefreshTokenRequest;
import c2m.security.dto.SignInRequest;
import c2m.security.dto.SignupRequest;
import c2m.security.entity.User;

public interface AuthenticationService {
    User signupUser(SignupRequest signupRequest);
    JwtAuthenticationResponse signInRequest(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshTokenRequest(RefreshTokenRequest refreshTokenRequest);
}
