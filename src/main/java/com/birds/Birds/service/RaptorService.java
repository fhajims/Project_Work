package com.birds.Birds.service;

import com.birds.Birds.model.Bird;
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
}
