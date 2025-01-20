package com.birds.Birds.service;

import com.birds.Birds.dto.ConservationStatusDto;
import com.birds.Birds.dto.RaptorDto;
import com.birds.Birds.dto.SongbirdDto;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.model.Raptor;
import com.birds.Birds.model.Songbird;
import com.birds.Birds.repository.RaptorRepository;
import com.birds.Birds.repository.SongbirdRepository;
import com.birds.Birds.service.ServiceInterfaces.ISongbirdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongbirdService implements ISongbirdService {


    private final SongbirdRepository songbirdRepository;

    @Override
    public Songbird findSongbirdById(Long id) {
        return songbirdRepository.findById(id).orElse(null);
    }

    @Override
    public List<Songbird> findAllSongbirds() {
        return songbirdRepository.findAll();
    }

    @Override
    public Songbird addSongbird(Songbird songbird) {
        return songbirdRepository.save(songbird);
    }

    public SongbirdDto convertToDto(Songbird songbird) {
        ConservationStatus status = songbird.getConservationStatus();

        ConservationStatusDto statusDto = null;

        if (status != null) {

            statusDto = new ConservationStatusDto(
                    status.getId(),
                    status.getStatus(),
                    status.getName(),
                    status.getDescription(),
                    status.getIucnCode(),
                    status.getYearAssessed(),
                    status.getPopulationTrend(),
                    status.getGeographicRange()
            );

        }

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
                songbird.getTerritorialBehavior(),
                songbird.getNestingStyle()
        );
    }
}



