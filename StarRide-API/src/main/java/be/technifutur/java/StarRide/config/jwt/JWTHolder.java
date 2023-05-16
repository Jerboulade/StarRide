package be.technifutur.java.StarRide.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTHolder {
    private String token;
    private String username;
}
