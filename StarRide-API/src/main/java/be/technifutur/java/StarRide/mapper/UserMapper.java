package be.technifutur.java.StarRide.mapper;

import be.technifutur.java.StarRide.models.dto.UserDTO;
import be.technifutur.java.StarRide.models.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO toDTO(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }
}
