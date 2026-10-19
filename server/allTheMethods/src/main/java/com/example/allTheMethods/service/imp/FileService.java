package com.example.allTheMethods.service.imp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

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
        Path filePath = uploadPath.resolve(imageName);
        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        return baseUrl + "/" + imageName;
    }

    public void deleteImage(Long id) throws IOException {
        try(Stream<Path> files = Files.list(Paths.get(uploadDir))){
            files.filter(path -> path.getFileName().toString().startsWith(id + ".")).forEach(path -> {
                try {
                    Files.deleteIfExists(path);
                }catch (IOException e){
                    throw new RuntimeException("Failed to delete the image",e);
                }
            });
        }
    }

    private String getExtension(String fileName){
        if(fileName==null || !fileName.contains(".")){
            return ".jpg";
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
