package com.birds.Birds.factory;

import com.birds.Birds.controller.ImageController;
import com.birds.Birds.model.Bird;
import com.birds.Birds.model.Parrot;
import com.birds.Birds.model.Raptor;
import com.birds.Birds.model.Songbird;
import com.birds.Birds.request.BirdRequest;
import com.birds.Birds.request.ParrotRequest;
import com.birds.Birds.request.RaptorRequest;
import com.birds.Birds.request.SongbirdRequest;
import com.birds.Birds.service.BirdService;
import com.birds.Birds.service.ParrotService;
import com.birds.Birds.service.RaptorService;
import com.birds.Birds.service.SongbirdService;
import lombok.RequiredArgsConstructor;
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

    @Override
    public ResponseEntity<?> createBird(BirdRequest birdRequest) {

        try {
            Bird bird;
            if ("Parrot".equalsIgnoreCase(birdRequest.getType())) {
                ParrotRequest parrotRequest = (ParrotRequest) birdRequest;
                Parrot parrot = new Parrot();
                parrot.setColorVariation(parrotRequest.getColorVariation());
                parrot.setIntelligenceLevel(parrotRequest.getIntelligenceLevel());
                parrot.setVocalAbility(parrotRequest.getVocalAbility());
                bird = parrot;
            } else if ("Songbird".equalsIgnoreCase(birdRequest.getType())) {
                SongbirdRequest songbirdRequest = (SongbirdRequest) birdRequest;
                Songbird songbird = new Songbird();
                songbird.setNestingStyle(songbirdRequest.getNestingStyle());
                songbird.setSongType(songbirdRequest.getSongType());
                songbird.setTerritorialBehavior(songbirdRequest.getTerritorialBehavior());
                bird = songbird; }
            else if ("Raptor".equalsIgnoreCase(birdRequest.getType())) {
                RaptorRequest raptorRequest = (RaptorRequest) birdRequest;
                Raptor raptor = new Raptor();
                raptor.setTalonLength(raptorRequest.getTalonLength());
                raptor.setNestingHabitat(raptorRequest.getNestingHabitat());
                raptor.setHuntingStyle(raptorRequest.getHuntingStyle());
                bird = raptor;
            } else {
                bird = new Bird();
            }

            bird.setSpecies(birdRequest.getSpecies());
            bird.setColor(birdRequest.getColor());
            bird.setFlightless(birdRequest.isFlightless());
            bird.setWingSpan(Double.parseDouble(birdRequest.getWingSpan()));
            bird.setBeakLength(Double.parseDouble(birdRequest.getBeakLength()));
            bird.setHabitat(birdRequest.getHabitat());
            bird.setDiet(birdRequest.getDiet());
            bird.setAverageLifespan(Integer.parseInt(birdRequest.getAverageLifespan()));
            bird.setMigrationPattern(birdRequest.getMigrationPattern());
            bird.setYoutubeLink(birdRequest.getYoutubeLink());
            bird.setType(birdRequest.getType());

            if (birdRequest.getImage() != null && !birdRequest.getImage().isEmpty()) {
                try {
                    String filePath = imageController.uploadImage(birdRequest.getImage());
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
}
