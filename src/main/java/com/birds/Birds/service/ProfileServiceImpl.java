package com.birds.Birds.service;


import com.birds.Birds.dto.ProfileDto;
import com.birds.Birds.exceptions.ItemExistsException;
import com.birds.Birds.model.ProfileEntity;
import com.birds.Birds.repository.ProfileRepository;
import com.birds.Birds.service.ServiceInterfaces.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;

    /**
     * It will save the user details to database
     * @param profileDto
     * @return profileDto
     * */

    @Override
    public ProfileDto createProfile(ProfileDto profileDto) {
        if (profileRepository.existsByEmail(profileDto.getEmail())) {
            throw new ItemExistsException("Profile already exists " + profileDto.getEmail());
        }
        profileDto.setPassword(encoder.encode(profileDto.getPassword()));
        ProfileEntity profileEntity = mapToProfileEntity(profileDto);
        profileEntity.setProfileId(UUID.randomUUID().toString());
        profileEntity = profileRepository.save(profileEntity);
        log.info("Printing the profile entity details {}", profileEntity);
        return mapToProfileDto(profileEntity);
    }



    /**
     * Mapper method to map values from profile dto  to profile entity
     * @param profileEntity
     * @return profileResponse
     */

    private ProfileDto mapToProfileDto(ProfileEntity profileEntity) {
        return modelMapper.map(profileEntity, ProfileDto.class);
    }

    /**
     * Mapper method to map values from profile dto to profile entity
     * @param profileDto
     * @return profileEntity
     */

    private ProfileEntity mapToProfileEntity(ProfileDto profileDto) {
        return modelMapper.map(profileDto, ProfileEntity.class);

    }


}
