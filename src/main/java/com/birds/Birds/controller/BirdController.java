package com.birds.Birds.controller;

import com.birds.Birds.service.ServiceInterfaces.IBirdService;
import com.birds.Birds.service.ServiceInterfaces.IConservationStatusService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.birds.Birds.dto.BirdDto;
import com.birds.Birds.model.Bird;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.service.BirdService;
import com.birds.Birds.service.ConservationStatusService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/birds")
@RestController
public class BirdController {

    private final IBirdService birdService;
    private final IConservationStatusService conservationStatusService;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<Bird> addBird(@RequestBody Bird bird) {
        Bird savedBird = birdService.addBird(bird);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBird);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BirdDto> getBirdById(@PathVariable Long id) {
        Bird bird = birdService.findBirdById(id);
        if (bird == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BirdDto birdDto = convertToDto(bird);
        return ResponseEntity.ok(birdDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BirdDto>> getAllBirds() {
        List<Bird> birds = birdService.findAllBirds();
        if (birds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<BirdDto> birdDtos = birds.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(birdDtos);
    }

    @GetMapping("/conservation-status/{statusId}")
    public ResponseEntity<List<BirdDto>> getBirdsByConservationStatus(@PathVariable Long statusId) {
        ConservationStatus status = conservationStatusService.findById(statusId);
        if (status == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<Bird> birds = birdService.findByConservationStatus(status);
        List<BirdDto> birdDtos = birds.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(birdDtos);
    }

    @GetMapping("/songbirds")
    public ResponseEntity<List<BirdDto>> getSongbirds() {
        List<Bird> birds = birdService.findAllSongbirds();
        if (birds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<BirdDto> birdDtos = birds.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(birdDtos);
    }

    @GetMapping("/flightless")
    public ResponseEntity<List<BirdDto>> getFlightlessBirds() {
        List<Bird> birds = birdService.findAllFlightlessBirds();
        if (birds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<BirdDto> birdDtos = birds.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(birdDtos);
    }

    @GetMapping("/parrots")
    public ResponseEntity<List<BirdDto>> getParrots() {
        List<Bird> birds = birdService.findAllParrots();
        if (birds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<BirdDto> birdDtos = birds.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(birdDtos);
    }

    private BirdDto convertToDto(Bird bird) {
        BirdDto birdDto = modelMapper.map(bird, BirdDto.class);
        if (bird.getConservationStatus() != null) {
            birdDto.setConservationStatus(bird.getConservationStatus().getStatus());
        }
        return birdDto;
    }
}
