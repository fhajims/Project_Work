package com.birds.Birds.service.ServiceInterfaces;

import org.springframework.http.ResponseEntity;
import com.birds.Birds.dto.BirdDto;
import com.birds.Birds.model.Bird;

import java.util.List;

public interface IBirdService {

    List<Bird> findAllBirds();
    Bird addBird(Bird bird);
    ResponseEntity<BirdDto> getBirdAndConvertItToDto(Long id);
    Bird findBird(Long id);
    Bird getBirdById(long id);

    List<BirdDto> getSongbirds();
    List<BirdDto> getFlightlessBirds();
    List<BirdDto> getParrots();
    List<BirdDto> getRaptors();
    List<BirdDto> getWaterfowl();
}

