package be.technifutur.java.StarRide.services.impl;

import be.technifutur.java.StarRide.mapper.UserMapper;
import be.technifutur.java.StarRide.models.dto.UserDTO;
import be.technifutur.java.StarRide.repositories.UserRepository;
import be.technifutur.java.StarRide.services.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository    userRepository;
    private final UserMapper        userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserDTO getUserProfileById(UUID id) {
        return userMapper.toDTO(userRepository.getUserById(id).orElseThrow());
    }
}
