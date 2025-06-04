package c2m.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class JwtAuthenticationResponse {
    private String token;
    private String refreshToken;
}
