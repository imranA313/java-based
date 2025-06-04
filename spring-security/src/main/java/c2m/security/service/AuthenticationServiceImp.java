package c2m.security.service;

import c2m.security.dto.JwtAuthenticationResponse;
import c2m.security.dto.RefreshTokenRequest;
import c2m.security.dto.SignInRequest;
import c2m.security.dto.SignupRequest;
import c2m.security.entity.Role;
import c2m.security.entity.User;
import c2m.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User signupUser(SignupRequest signupRequest){
        User user = new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(Role.valueOf((Role.USER).toString()));
        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signInRequest(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        User user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid emil or password"));
        String token = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
        return new JwtAuthenticationResponse(token, refreshToken);
    }

    public JwtAuthenticationResponse refreshTokenRequest(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getRefreshToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getRefreshToken(), user)){
            String token = jwtService.generateToken(user);
            String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
            return new JwtAuthenticationResponse(token, refreshToken);
        }
        return null;
    }

}
