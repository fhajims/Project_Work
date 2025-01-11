package com.birds.Birds.controller;

import com.birds.Birds.dto.BirdDto;
import com.birds.Birds.dto.ConservationStatusDto;
import com.birds.Birds.dto.RaptorDto;
import com.birds.Birds.model.Bird;
import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.model.Raptor;
import com.birds.Birds.service.RaptorService;
import com.birds.Birds.service.ServiceInterfaces.IRaptorService;
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
@RequestMapping("/raptors")
@RequiredArgsConstructor
public class RaptorController {


    private final IRaptorService raptorService;


    @GetMapping("/all")
    public ResponseEntity<List<RaptorDto>> getAllRaptors() {
        List<Raptor> raptors = raptorService.findAllRaptors();
        if (raptors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<RaptorDto> raptorDtos = raptors.stream()
                .map(raptorService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(raptorDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaptorDto> getRaptorById(@PathVariable Long id) {
        Raptor raptor = raptorService.findRaptorById(id);
        if (raptor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        RaptorDto raptorDto = raptorService.convertToDto(raptor);
        return ResponseEntity.ok(raptorDto);
    }




}
