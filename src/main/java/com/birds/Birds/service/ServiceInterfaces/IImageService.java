package com.birds.Birds.service.ServiceInterfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {

    public String saveImage(MultipartFile file) throws IOException;

}
