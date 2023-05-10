package be.technifutur.java.StarRide.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
public class Journey {

    @Id
    @Column(name = "journey_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
