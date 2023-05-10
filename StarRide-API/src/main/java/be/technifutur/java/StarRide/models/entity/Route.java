package be.technifutur.java.StarRide.models.entity;

import be.technifutur.java.StarRide.models.enums.Conveyance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Route {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column(name = "route_id")
    private UUID id;

    @Column(nullable = false)
    private Conveyance  conveyance;


    private List<User>  passengers;

    private String      company;
}
