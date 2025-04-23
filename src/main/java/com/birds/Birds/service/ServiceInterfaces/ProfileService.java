package com.birds.Birds.service.ServiceInterfaces;

import com.birds.Birds.dto.ProfileDto;
import com.birds.Birds.model.ProfileEntity;

import java.util.Optional;

public interface ProfileService {

    ProfileDto createProfile(ProfileDto profileDto);

}
