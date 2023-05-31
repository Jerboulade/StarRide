package be.technifutur.java.StarRide.repositories;

import be.technifutur.java.StarRide.models.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StepRepository extends JpaRepository<Step, UUID> {

}
