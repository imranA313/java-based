package c2m.security.service;

import c2m.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    Boolean isTokenValid(String token, UserDetails userDetails);

    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
