package be.technifutur.java.StarRide.repositories;

import be.technifutur.java.StarRide.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("""
            SELECT user
            FROM User user
            WHERE user.id = :id
            """)
    Optional<User> getUserById(UUID id);

    Optional<User> findByUsername(String username);
}
