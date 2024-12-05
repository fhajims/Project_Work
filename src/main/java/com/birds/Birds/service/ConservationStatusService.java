package com.birds.Birds.service;

import com.birds.Birds.model.ConservationStatus;
import com.birds.Birds.repository.ConservationStatusRepository;
import com.birds.Birds.service.ServiceInterfaces.IConservationStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConservationStatusService implements IConservationStatusService {

    private final ConservationStatusRepository statusRepository;


    @Override
    public ConservationStatus findConservationStatusById(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public ConservationStatus findConservationStatusByName(String name) {
        return statusRepository.findByName(name);
    }

    @Override
    public List<ConservationStatus> findAllConservationStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public ConservationStatus addConservationStatus(ConservationStatus status) {
        return statusRepository.save(status);
    }

    @Override
    public ConservationStatus updateConservationStatus(ConservationStatus status) {
        if (status.getId() == null || !statusRepository.existsById(status.getId())) {
            return null;
        }
        return statusRepository.save(status);
    }

    @Override
    public void deleteConservationStatus(Long id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
        }
    }

        public ConservationStatus findById(Long statusId) {
            return statusRepository.findById(statusId).orElse(null);

        }
}
