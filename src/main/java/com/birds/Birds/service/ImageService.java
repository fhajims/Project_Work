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
import org.springframework.web.util.UriComponentsBuilder;


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

    @Value("${base}")
    private String base;

    @Value("${host}")
    private String host;

    @Value("${port}")
    private String port;



    public String saveImage(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }


        try {

            Path uploadPath = Paths.get(uploadDir);


            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }


            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            System.out.println("Saving file to: " + filePath.toAbsolutePath());
            Path realFilePath = filePath.toAbsolutePath();

            Path lastSegment = realFilePath.getFileName();

            Files.write(realFilePath, file.getBytes());

            String imageUrl = UriComponentsBuilder
                    .newInstance()
                    .host(host)
                    .port(port)
                    .path("/images/")
                    .pathSegment(lastSegment.toString())
                    .toUriString();

            return imageUrl;
        } catch (IOException e) {

            throw new IOException("Failed to upload file", e);
        }

    }
}
