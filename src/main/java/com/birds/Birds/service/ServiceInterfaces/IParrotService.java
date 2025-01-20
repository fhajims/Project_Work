package com.birds.Birds.service.ServiceInterfaces;

import com.birds.Birds.dto.ParrotDto;
import com.birds.Birds.model.Parrot;

import java.util.List;

public interface IParrotService {

    List<Parrot> findAllParrots();

    Parrot findParrotById(Long id);

    ParrotDto convertToDto(Parrot parrot);
    Parrot addBird(Parrot parrot);

}



