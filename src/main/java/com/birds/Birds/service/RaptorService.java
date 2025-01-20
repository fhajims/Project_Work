package com.birds.Birds.service;

import com.birds.Birds.dto.ConservationStatusDto;
import com.birds.Birds.dto.RaptorDto;
import com.birds.Birds.model.Bird;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.repository.RaptorRepository;
import com.birds.Birds.service.ServiceInterfaces.IRaptorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.birds.Birds.model.Raptor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaptorService implements IRaptorService {

    private final RaptorRepository raptorRepository;

    public Raptor findRaptorById(Long id) {
        return raptorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Raptor> findAllRaptors() {
        return raptorRepository.findAll();
    }

    @Override
    public Raptor addRaptor(Raptor raptor) {
        return raptorRepository.save(raptor);
    }

    public RaptorDto convertToDto(Raptor raptor) {

        ConservationStatusDto statusDto = null;
        ConservationStatus status = raptor.getConservationStatus();

        if(status!= null) {


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

        return new RaptorDto(
                raptor.getId(),
                raptor.getSpecies(),
                raptor.getColor(),
                raptor.getFlightless(),
                raptor.getWingSpan(),
                raptor.getBeakLength(),
                raptor.getHabitat(),
                raptor.getDiet(),
                raptor.getAverageLifespan(),
                raptor.getMigrationPattern(),
                raptor.getImageUrl(),
                raptor.getYoutubeLink(),
                raptor.getType(),
                statusDto,
                raptor.getTalonLength(),
                raptor.getNestingHabitat(),
                raptor.getHuntingStyle()
        );
    }


}
