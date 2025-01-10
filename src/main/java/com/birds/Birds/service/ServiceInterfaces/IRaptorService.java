package com.birds.Birds.service.ServiceInterfaces;

import com.birds.Birds.model.Raptor;

import java.util.List;

public interface IRaptorService {


    Raptor findRaptorById(Long id);

    List<Raptor> findAllRaptors();

}
