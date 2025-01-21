package com.birds.Birds.factory;

import com.birds.Birds.model.Bird;
import com.birds.Birds.request.BirdRequest;
import com.birds.Birds.request.FormData;
import org.springframework.http.ResponseEntity;

public interface BirdFactory {
    ResponseEntity<?> createBird(FormData formData);
}
