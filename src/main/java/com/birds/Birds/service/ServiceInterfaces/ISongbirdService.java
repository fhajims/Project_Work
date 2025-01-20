package com.birds.Birds.service.ServiceInterfaces;

import com.birds.Birds.model.Songbird;

import java.util.List;

public interface ISongbirdService {

    List<Songbird> findAllSongbirds();

    Songbird addSongbird(Songbird songbird);

    Songbird findSongbirdById(Long id);


}
