package com.birds.Birds.controller;

import com.birds.Birds.dto.BirdDto;
import com.birds.Birds.dto.RaptorDto;
import com.birds.Birds.model.Bird;
import com.birds.Birds.model.Raptor;
import com.birds.Birds.service.RaptorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/raptors")
@RequiredArgsConstructor
public class RaptorController {


    private final RaptorService raptorService;


    @GetMapping("/all")
    public ResponseEntity<List<RaptorDto>> getAllRaptors() {
        List<Raptor> raptors = raptorService.findAllRaptors();
        if (raptors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<RaptorDto> raptorDtos = raptors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(raptorDtos);
    }

    private RaptorDto convertToDto(Raptor raptor) {
        if (raptor == null) {
            return null;
        }
        return new RaptorDto(
                raptor.getId(),
                raptor.getTalonLength(),
                raptor.getNestingHabitat(),
                raptor.getHuntingStyle()
        );
    }


}
