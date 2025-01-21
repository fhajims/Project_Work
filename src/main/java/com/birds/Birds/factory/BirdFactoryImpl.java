package com.birds.Birds.factory;

import com.birds.Birds.controller.ImageController;
import com.birds.Birds.model.Bird;
import com.birds.Birds.model.Parrot;
import com.birds.Birds.model.Raptor;
import com.birds.Birds.model.Songbird;
import com.birds.Birds.request.*;
import com.birds.Birds.service.BirdService;
import com.birds.Birds.service.ParrotService;
import com.birds.Birds.service.RaptorService;
import com.birds.Birds.service.SongbirdService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.awt.*;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class BirdFactoryImpl implements BirdFactory {

    private final ImageController imageController;
    private final SongbirdService songbirdService;
    private final ParrotService parrotService;
    private final RaptorService raptorService;
    private final BirdService birdService;

    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> createBird(FormData formData) {

        try {
            Bird bird;
            if ("Parrot".equalsIgnoreCase(formData.getType())) {

                ParrotRequest parrotRequest = mapToParrotRequest(formData);
                Parrot parrot = new Parrot();
                parrot.setColorVariation(parrotRequest.getColorVariation());
                parrot.setIntelligenceLevel(parrotRequest.getIntelligenceLevel());
                parrot.setVocalAbility(parrotRequest.getVocalAbility());
                bird = parrot;
            } else if ("Songbird".equalsIgnoreCase(formData.getType())) {
                SongbirdRequest songbirdRequest = mapToSongbirdRequest(formData);
                Songbird songbird = new Songbird();
                songbird.setNestingStyle(songbirdRequest.getNestingStyle());
                songbird.setSongType(songbirdRequest.getSongType());
                songbird.setTerritorialBehavior(songbirdRequest.getTerritorialBehavior());
                bird = songbird; }
            else if ("Raptor".equalsIgnoreCase(formData.getType())) {
                RaptorRequest raptorRequest = mapToRaptorRequest(formData);
                Raptor raptor = new Raptor();
                raptor.setTalonLength(raptorRequest.getTalonLength());
                raptor.setNestingHabitat(raptorRequest.getNestingHabitat());
                raptor.setHuntingStyle(raptorRequest.getHuntingStyle());
                bird = raptor;
            } else {
                bird = new Bird();
            }

            bird.setSpecies(formData.getSpecies());
            bird.setColor(formData.getColor());
            bird.setFlightless(formData.isFlightless());
            bird.setWingSpan(Double.parseDouble(String.valueOf(formData.getWingSpan())));
            bird.setBeakLength(Double.parseDouble(formData.getBeakLength()));
            bird.setHabitat(formData.getHabitat());
            bird.setDiet(formData.getDiet());
            bird.setAverageLifespan(Integer.parseInt(String.valueOf(formData.getAverageLifespan())));
            bird.setMigrationPattern(formData.getMigrationPattern());
            bird.setYoutubeLink(formData.getYoutubeLink());
            bird.setType(formData.getType());

            if (formData.getImage() != null && !formData.getImage().isEmpty()) {
                try {
                    String filePath = imageController.uploadImage(formData.getImage());
                    bird.setImageUrl(filePath);
                } catch (IOException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Failed to upload image: " + e.getMessage());
                }
            }

            Bird savedBird;
            if (bird instanceof Parrot) {
                savedBird = parrotService.addParrot((Parrot) bird);
            } else if (bird instanceof Songbird) {
                savedBird = songbirdService.addSongbird((Songbird) bird);
            } else if (bird instanceof Raptor) {
                savedBird = raptorService.addRaptor((Raptor) bird); }
            else {
                savedBird = birdService.addBird((Bird) bird);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(savedBird);

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid number format: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }

    }

    public BirdRequest mapToBirdRequest(FormData formData) {

        BirdRequest birdRequest = modelMapper.map(formData, BirdRequest.class);
        return birdRequest;

    }

    public ParrotRequest mapToParrotRequest (FormData formData) {
        ParrotRequest parrotRequest = modelMapper.map(formData, ParrotRequest.class);
        return parrotRequest;
    }

    public SongbirdRequest mapToSongbirdRequest (FormData formData) {
        SongbirdRequest songbirdRequest = modelMapper.map(formData, SongbirdRequest.class);
        return songbirdRequest;
    }

    public RaptorRequest mapToRaptorRequest (FormData formData) {
        RaptorRequest raptorRequest = modelMapper.map(formData, RaptorRequest.class);
        return raptorRequest;
    }

}
