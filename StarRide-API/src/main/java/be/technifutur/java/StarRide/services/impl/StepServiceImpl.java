package be.technifutur.java.StarRide.services.impl;

import be.technifutur.java.StarRide.mapper.StepMapper;
import be.technifutur.java.StarRide.models.dto.StepDTO;
import be.technifutur.java.StarRide.repositories.StepRepository;
import be.technifutur.java.StarRide.services.StepService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepServiceImpl implements StepService {

    private final StepRepository    stepRepository;

    private final StepMapper        stepMapper;

    public StepServiceImpl(StepRepository stepRepository, StepMapper stepMapper) {
        this.stepRepository = stepRepository;
        this.stepMapper = stepMapper;
    }

    @Override
    public List<StepDTO> all() {
        return stepRepository.findAll().stream()
                .map(stepMapper::toDTO)
                .toList();
    }
}
