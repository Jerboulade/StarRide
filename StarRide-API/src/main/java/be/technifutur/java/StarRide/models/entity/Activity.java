package be.technifutur.java.StarRide.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Activity {

    @Id
    @Column(name = "activity_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Future
    private LocalDateTime   startDate;

    @Column(nullable = false)
    @Future
    private LocalDateTime   endDate;

    @PositiveOrZero
    private Integer         price;

    private String          description;

    @Column(name = "step_id")
    private Step            step;
}
