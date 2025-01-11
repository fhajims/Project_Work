package com.birds.Birds.service;

import com.birds.Birds.dto.ConservationStatusDto;
import com.birds.Birds.dto.ParrotDto;
import com.birds.Birds.dto.SongbirdDto;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.model.Parrot;
import com.birds.Birds.model.Songbird;
import com.birds.Birds.repository.ParrotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParrotService {

    private final ParrotRepository parrotRepository;

    public List<Parrot> findAllParrots() {
        return parrotRepository.findAll();
    }

    public Parrot findParrotById(Long id) {
        return parrotRepository.findById(id).orElse(null);
    }

    public ParrotDto convertToDto(Parrot parrot) {
        ConservationStatus status = parrot.getConservationStatus();
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

        return new ParrotDto(
                parrot.getId(),
                parrot.getSpecies(),
                parrot.getColor(),
                parrot.getFlightless(),
                parrot.getWingSpan(),
                parrot.getBeakLength(),
                parrot.getHabitat(),
                parrot.getDiet(),
                parrot.getAverageLifespan(),
                parrot.getMigrationPattern(),
                parrot.getImageUrl(),
                parrot.getYoutubeLink(),
                parrot.getType(),
                statusDto,
                parrot.getColorVariation(),
                parrot.getIntelligenceLevel(),
                parrot.getVocalAbility()
        );
    }


}
