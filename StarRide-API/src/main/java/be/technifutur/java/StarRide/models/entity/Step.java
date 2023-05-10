package be.technifutur.java.StarRide.models.entity;

import be.technifutur.java.StarRide.models.enums.StepType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Step {

    @Id
    @Column(name = "step_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID            id;

    @Column(nullable = false)
    private String          address;

    @Column(nullable = false)
    @Future
    private LocalDateTime   startDate;

    @Column(nullable = false)
    @Future
    private LocalDateTime   endDate;

    @Enumerated
    @Column(nullable = false)
    private StepType        type;

    @OneToMany
    @JoinColumn(name = "step_id")
    private List<Activity>  activities;
}
