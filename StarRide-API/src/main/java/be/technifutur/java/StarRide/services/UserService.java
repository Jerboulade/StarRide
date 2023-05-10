package be.technifutur.java.StarRide.services;


import be.technifutur.java.StarRide.models.dto.UserDTO;

import java.util.UUID;

public interface UserService {


    UserDTO getUserProfileById(UUID id);
}
