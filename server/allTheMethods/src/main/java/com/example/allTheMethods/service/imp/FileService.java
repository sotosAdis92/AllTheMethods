package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    @Value("${app.image.upload-dir}")
    private String uploadDir;

    @Value("${app.image.base-url}")
    private String baseUrl;

    public void uploadImage(Long id, MultipartFile file) throws IOException {}
}
