package com.birds.Birds.service.ServiceInterfaces;

import com.birds.Birds.model.ConservationStatus;

import java.util.List;

public interface IConservationStatusService {

    ConservationStatus findConservationStatusById(Long id);
    ConservationStatus findConservationStatusByName(String name);
    List<ConservationStatus> findAllConservationStatuses();
    ConservationStatus addConservationStatus(ConservationStatus status);
    ConservationStatus updateConservationStatus(ConservationStatus status);

    ConservationStatus findById(Long statusId);

    void deleteConservationStatus(Long id);
}




