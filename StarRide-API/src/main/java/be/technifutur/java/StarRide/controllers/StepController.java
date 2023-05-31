package be.technifutur.java.StarRide.controllers;

import be.technifutur.java.StarRide.models.dto.StepDTO;
import be.technifutur.java.StarRide.services.StepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/step")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping("/all")
    public List<StepDTO> all() {
        return stepService.all();
    }
}
