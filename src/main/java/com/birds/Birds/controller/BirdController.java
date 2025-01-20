package com.birds.Birds.controller;

import com.birds.Birds.model.*;
import com.birds.Birds.service.ServiceInterfaces.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.birds.Birds.dto.BirdDto;
import com.birds.Birds.service.BirdService;
import com.birds.Birds.service.ConservationStatusService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/birds")
@RestController
public class BirdController {

    private final IBirdService birdService;
    private final IConservationStatusService conservationStatusService;
    private final ModelMapper modelMapper;
    private final IRaptorService raptorService;
    private final IParrotService parrotService;
    private final ISongbirdService songbirdService;

    private final ImageController imageController;

    @PostMapping("/add")
    public ResponseEntity<?> addBird(
            @RequestParam("species") String species,
            @RequestParam("color") String color,
            @RequestParam("flightless") boolean flightless,
            @RequestParam("wingSpan") String wingSpan,
            @RequestParam("beakLength") String beakLength,
            @RequestParam("habitat") String habitat,
            @RequestParam("diet") String diet,
            @RequestParam("averageLifespan") String averageLifespan,
            @RequestParam("migrationPattern") String migrationPattern,
            @RequestParam("youtubeLink") String youtubeLink,
            @RequestParam("type") String type,
            @RequestParam(value = "image", required = false) MultipartFile image) {

        try {
            Bird bird;

            // Instantiate the correct subclass based on the type
            if ("Parrot".equalsIgnoreCase(type)) {
                bird = new Parrot();
            } else if ("Songbird".equalsIgnoreCase(type)) {
                bird = new Songbird(); }
                else if ("Raptor".equalsIgnoreCase(type)) {
                    bird = new Raptor();
            } else {
                return ResponseEntity.badRequest().body("Invalid bird type: " + type);
            }

            bird.setSpecies(species);
            bird.setColor(color);
            bird.setFlightless(flightless);
            bird.setWingSpan(Double.parseDouble(wingSpan));
            bird.setBeakLength(Double.parseDouble(beakLength));
            bird.setHabitat(habitat);
            bird.setDiet(diet);
            bird.setAverageLifespan(Integer.parseInt(averageLifespan));
            bird.setMigrationPattern(migrationPattern);
            bird.setYoutubeLink(youtubeLink);
            bird.setType(type);

            if (image != null && !image.isEmpty()) {
                try {
                    String filePath = imageController.uploadImage(image);
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
                return ResponseEntity.badRequest().body("Unhandled bird type: " + type);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(savedBird);

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid number format: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }



/*
    @PostMapping("/add")
    public ResponseEntity<?> addBird(
            @RequestParam("species") String species,
            @RequestParam("color") String color,
            @RequestParam("flightless") boolean flightless,
            @RequestParam("wingSpan") String wingSpan,
            @RequestParam("beakLength") String beakLength,
            @RequestParam("habitat") String habitat,
            @RequestParam("diet") String diet,
            @RequestParam("averageLifespan") String averageLifespan,
            @RequestParam("migrationPattern") String migrationPattern,
            @RequestParam("youtubeLink") String youtubeLink,
            @RequestParam("type") String type,
            @RequestParam(value = "image", required = false) MultipartFile image) {

        try {

            Bird bird = new Bird();
            bird.setSpecies(species);
            bird.setColor(color);
            bird.setFlightless(flightless);
            bird.setWingSpan(Double.parseDouble(wingSpan));
            bird.setBeakLength(Double.parseDouble(beakLength));
            bird.setHabitat(habitat);
            bird.setDiet(diet);
            bird.setAverageLifespan(Integer.parseInt(averageLifespan));
            bird.setMigrationPattern(migrationPattern);
            bird.setYoutubeLink(youtubeLink);
            bird.setType(type);


            if (image != null && !image.isEmpty()) {
                try {
                    String filePath = imageController.uploadImage(image);
                    bird.setImageUrl(filePath);
                } catch (IOException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Failed to upload image: " + e.getMessage());
                }
            }

            // Save the bird and return the response
            Bird savedBird = birdService.addBird(bird);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBird);

        } catch (NumberFormatException e) {
            // Handle invalid number format
            return ResponseEntity.badRequest().body("Invalid number format: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }
/*
    @PostMapping("/add")
    public ResponseEntity<Bird> addBird(@RequestBody Bird bird) {
        Bird savedBird = birdService.addBird(bird);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBird);
    }


 */

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
