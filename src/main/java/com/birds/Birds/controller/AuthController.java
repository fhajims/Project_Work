package com.birds.Birds.controller;


import com.birds.Birds.dto.ProfileDto;
import com.birds.Birds.io.AuthRequest;
import com.birds.Birds.io.AuthResponse;
import com.birds.Birds.io.ProfileRequest;
import com.birds.Birds.io.ProfileResponse;
import com.birds.Birds.service.CustomUserDetailsService;
import com.birds.Birds.service.ServiceInterfaces.ProfileService;
import com.birds.Birds.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor

public class AuthController {

    private final ModelMapper modelMapper;
    private final ProfileService profileService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final CustomUserDetailsService userDetailsService;


    /**
     * API endpoint to register new user
     * @param profileRequest
     * @return profileResponse
     */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public ProfileResponse createProfile(@Valid @RequestBody ProfileRequest profileRequest) {
        log.info("API /register is called", profileRequest);
        ProfileDto profileDto = mapToProfileDto(profileRequest);
        profileDto = profileService.createProfile(profileDto);
        log.info("Printing the profile dto details {}", profileDto);
        return mapToProfileResponse(profileDto);

    }


    @PostMapping("/login")
    public AuthResponse authenticateProfile(@RequestBody AuthRequest authRequest) throws Exception {
        log.info("API /login is called {}", authRequest);
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        authenticate(authRequest);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new AuthResponse(token, authRequest.getEmail());

    }

    private void authenticate(AuthRequest authRequest) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        } catch (DisabledException ex) {
            throw new Exception("Profile disabled");
        } catch (BadCredentialsException ex) {
            throw new Exception("Bad credentials");
        }

    }

    /**
     * Mapper method to map values from profile request to profile dto
     * @param profileRequest
     * @return profileDto
     */

    private ProfileDto mapToProfileDto(ProfileRequest profileRequest) {
        return modelMapper.map(profileRequest, ProfileDto.class);
    }

    /**
     * Mapper method to map values from profile dto  to profile response
     * @param profileDto
     * @return profileResponse
     */

    private ProfileResponse mapToProfileResponse(ProfileDto profileDto) {
        return modelMapper.map(profileDto, ProfileResponse.class);
    }


}
