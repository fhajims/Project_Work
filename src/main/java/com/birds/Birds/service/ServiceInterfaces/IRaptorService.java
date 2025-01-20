package com.birds.Birds.service.ServiceInterfaces;

import com.birds.Birds.dto.RaptorDto;
import com.birds.Birds.model.Parrot;
import com.birds.Birds.model.Raptor;

import java.util.List;

public interface IRaptorService {


    Raptor findRaptorById(Long id);

    List<Raptor> findAllRaptors();

    RaptorDto convertToDto(Raptor raptor);

    Raptor addRaptor(Raptor raptor);

}
