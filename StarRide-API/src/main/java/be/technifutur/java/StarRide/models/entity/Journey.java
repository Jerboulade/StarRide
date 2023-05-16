package be.technifutur.java.StarRide.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Journey {

    @Id
    @Column(name = "journey_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID        id;

    @OneToMany
    private List<Step>  steps;

    @OneToMany
    private List<Route> routes;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking     booking;


}
