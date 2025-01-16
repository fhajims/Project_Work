package com.birds.Birds.service;
import com.birds.Birds.repository.ImageRepository;
import com.birds.Birds.service.ServiceInterfaces.IImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@RequiredArgsConstructor
@Service
public class ImageService implements IImageService {

    private final ImageRepository imageRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    public String saveImage(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        try {
            // Resolve the upload directory
            Path uploadPath = Paths.get(uploadDir);

            // Ensure the directory exists
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            System.out.println("Saving file to: " + filePath.toAbsolutePath());

            // Write file to the specified path
            Files.write(filePath, file.getBytes());

            // Return the file path as a string
            return filePath.toString();
        } catch (IOException e) {
            // Log the exception (if logging is available) and rethrow
            throw new IOException("Failed to upload file", e);
        }

    }
}
