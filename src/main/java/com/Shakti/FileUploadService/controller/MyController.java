package com.Shakti.FileUploadService.controller;

import com.Shakti.FileUploadService.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class MyController {
    @Autowired
    private StorageService service;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
       String uploadImage = service.uploadImage(file);
       return ResponseEntity.status(HttpStatus.OK)
               .body(uploadImage);
    }
    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable("fileName") String fileName){
        byte[] dbImage = service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(dbImage);
    }
}
