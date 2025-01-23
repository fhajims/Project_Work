package com.birds.Birds.service.ServiceInterfaces;

import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.request.FormData;
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

    Bird findBirdById(Long id);

    public List<Bird> findByConservationStatus(ConservationStatus status);

    public List<Bird> findAllSongbirds();

    public List<Bird> findAllFlightlessBirds();

    public List<Bird> findAllParrots();

    List<BirdDto> getSongbirds();
    List<BirdDto> getFlightlessBirds();
    List<BirdDto> getParrots();
    List<BirdDto> getRaptors();
    List<BirdDto> getWaterfowl();

    ResponseEntity<?> editBird(FormData formData, Long id);

    ResponseEntity<?> deleteBird(Long id);
}

