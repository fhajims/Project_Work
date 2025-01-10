package com.birds.Birds.service;

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
}



