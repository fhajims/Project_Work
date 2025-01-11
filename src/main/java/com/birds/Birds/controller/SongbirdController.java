package com.birds.Birds.controller;

import com.birds.Birds.dto.ConservationStatusDto;
import com.birds.Birds.dto.RaptorDto;
import com.birds.Birds.dto.SongbirdDto;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.model.Raptor;
import com.birds.Birds.model.Songbird;
import com.birds.Birds.service.SongbirdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/songbirds")
@RequiredArgsConstructor
public class SongbirdController {

    private final SongbirdService songbirdService;

    @GetMapping("/all")
    public ResponseEntity<List<SongbirdDto>> getAllSongbirds() {
        List<Songbird> songbirds = songbirdService.findAllSongbirds();
        if (songbirds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<SongbirdDto> songbirdDtos = songbirds.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(songbirdDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongbirdDto> getRaptorById(@PathVariable Long id) {
        Songbird songbird = songbirdService.findSongbirdById(id);
        if (songbird == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        SongbirdDto songbirdDto = songbirdService.convertToDto(songbird);
        return ResponseEntity.ok(songbirdDto);
    }


    public SongbirdDto convertToDto(Songbird songbird) {
        ConservationStatus status = songbird.getConservationStatus();
        ConservationStatusDto statusDto = new ConservationStatusDto(
                status.getId(),
                status.getStatus(),
                status.getName(),
                status.getDescription(),
                status.getIucnCode(),
                status.getYearAssessed(),
                status.getPopulationTrend(),
                status.getGeographicRange()
        );

        return new SongbirdDto(
                songbird.getId(),
                songbird.getSpecies(),
                songbird.getColor(),
                songbird.getFlightless(),
                songbird.getWingSpan(),
                songbird.getBeakLength(),
                songbird.getHabitat(),
                songbird.getDiet(),
                songbird.getAverageLifespan(),
                songbird.getMigrationPattern(),
                songbird.getImageUrl(),
                songbird.getYoutubeLink(),
                songbird.getType(),
                statusDto,
                songbird.getSongType(),
                songbird.getNestingStyle(),
                songbird.getTerritorialBehavior()
        );
    }



}
