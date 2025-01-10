package com.birds.Birds.service;
import com.birds.Birds.dto.BirdDto;
import com.birds.Birds.model.Bird;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.repository.BirdRepository;

import com.birds.Birds.service.ServiceInterfaces.IBirdService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BirdService implements IBirdService {

    private final BirdRepository birdRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Bird> findAllBirds() {
        return birdRepository.findAll();
    }

    @Override
    public Bird addBird(Bird bird) {
        return birdRepository.save(bird);
    }

    @Override
    public ResponseEntity<BirdDto> getBirdAndConvertItToDto(Long id) {
        Bird bird = getBirdById(id);
        if (bird == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BirdDto birdDto = convertToDto(bird);
        return ResponseEntity.ok(birdDto);
    }

    @Override
    public Bird findBird(Long id) {
        return birdRepository.findById(id).orElse(null);
    }

    @Override
    public Bird getBirdById(long id) {
        return birdRepository.findById(id).orElse(null);
    }

    @Override
    public List<BirdDto> getSongbirds() {
        return getBirdsByType("Songbird");
    }

    @Override
    public List<BirdDto> getFlightlessBirds() {
        return getBirdsByType("FlightlessBird");
    }

    @Override
    public List<BirdDto> getParrots() {
        return getBirdsByType("Parrot");
    }

    @Override
    public List<BirdDto> getRaptors() {
        return getBirdsByType("Raptor");
    }

    @Override
    public List<BirdDto> getWaterfowl() {
        return getBirdsByType("Waterfowl");
    }

    private List<BirdDto> getBirdsByType(String type) {
        List<Bird> birds = birdRepository.findByType(type);
        return birds.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private BirdDto convertToDto(Bird bird) {
        BirdDto birdDto = modelMapper.map(bird, BirdDto.class);
        if (bird.getConservationStatus() != null) {
            birdDto.setConservationStatus(bird.getConservationStatus().getStatus());
        }
        return birdDto;
    }

    public Bird findBirdById(Long id) {
        return birdRepository.findById(id).orElse(null);
    }

    public List<Bird> findByConservationStatus(ConservationStatus status) {
        return birdRepository.findByConservationStatus(status);
    }

    public List<Bird> findAllSongbirds() {
        return birdRepository.findByType("Songbird");
    }

    public List<Bird> findAllFlightlessBirds() {
        return birdRepository.findByFlightlessTrue();
    }
    public List<Bird> findAllParrots() {
        return birdRepository.findByType("Parrot");
    }

}
