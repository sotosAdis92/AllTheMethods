package com.example.allTheMethods.service.imp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    @Value("${app.image.upload-dir}")
    private String uploadDir;

    @Value("${app.image.base-url}")
    private String baseUrl;

    public String uploadImage(Long id, MultipartFile file) throws IOException {
        String fileName = getExtension(file.getOriginalFilename());
        String imageName = id + fileName;
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        return baseUrl + "/" + fileName;
    }

    private String getExtension(String fileName){
        if(fileName==null || fileName.contains(".")){
            return ".jpg";
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
