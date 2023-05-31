package be.technifutur.java.StarRide.models.dto;

import be.technifutur.java.StarRide.models.entity.Activity;
import be.technifutur.java.StarRide.models.enums.StepType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class StepDTO {

    private UUID            id;
    private String          address;
    private LocalDateTime   startDate;
    private LocalDateTime   endDate;
    private StepType        type;
    private Integer         price;
    private List<Activity>  activities;
}
