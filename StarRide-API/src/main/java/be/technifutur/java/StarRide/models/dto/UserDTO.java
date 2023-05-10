package be.technifutur.java.StarRide.models.dto;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDTO {
    private UUID    id;
    private String  username;
}
