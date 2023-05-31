package be.technifutur.java.StarRide.mapper;

import be.technifutur.java.StarRide.models.dto.StepDTO;
import be.technifutur.java.StarRide.models.entity.Step;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class StepMapper {

    public StepDTO toDTO(Step entity) {
        return StepDTO.builder()
                .price(entity.getPrice())
                .type(entity.getType())
                .id(entity.getId())
                .address(entity.getAddress())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .activities(entity.getActivities())
                .build();
    }
}
