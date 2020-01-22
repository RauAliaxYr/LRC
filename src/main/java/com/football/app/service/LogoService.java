package com.football.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class LogoService {

    @Value("${upload.path}")
    private String uploadPath;

    public String logo(MultipartFile multipartFile) throws IOException {

        if (multipartFile != null && !multipartFile.getOriginalFilename().isEmpty()) {
            File uploaddir = new File(uploadPath);
            if (!uploaddir.exists()) {
                uploaddir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resulteFilename = uuidFile + "." + multipartFile.getOriginalFilename();

            multipartFile.transferTo(new File(uploadPath + "/" + resulteFilename));

            return resulteFilename;
        }
        return "Файл отсутствует";
    }
}
