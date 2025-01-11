package com.birds.Birds.controller;

import com.birds.Birds.dto.ConservationStatusDto;
import com.birds.Birds.dto.ParrotDto;
import com.birds.Birds.dto.SongbirdDto;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.model.Parrot;
import com.birds.Birds.model.Songbird;
import com.birds.Birds.service.ParrotService;
import com.birds.Birds.service.ServiceInterfaces.IParrotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/parrots")
@RequiredArgsConstructor
public class ParrotController {

    private final IParrotService parrotService;

    @GetMapping("/all")
    public ResponseEntity<List<ParrotDto>> getAllParrots() {
        List<Parrot> parrots = parrotService.findAllParrots();
        if (parrots.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<ParrotDto> parrotDtos = parrots.stream()
                .map(parrotService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(parrotDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParrotDto> getRaptorById(@PathVariable Long id) {
        Parrot parrot = parrotService.findParrotById(id);
        if (parrot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ParrotDto parrotDto = parrotService.convertToDto(parrot);
        return ResponseEntity.ok(parrotDto);
    }



}


