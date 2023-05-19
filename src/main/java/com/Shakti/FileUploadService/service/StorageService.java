package com.Shakti.FileUploadService.service;

import com.Shakti.FileUploadService.entity.ImageInfo;
import com.Shakti.FileUploadService.repository.StorageRepo;
import com.Shakti.FileUploadService.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepo repo;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageInfo imageInfo = repo.save(ImageInfo.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());
        if(imageInfo!=null){
            return new String("File uploaded successfully : "+ file.getOriginalFilename());
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageInfo> dbImageInfo = repo.findByName(fileName);
        byte[] image = ImageUtil.decompressImage(dbImageInfo.get().getImageData());
        return image;
    }

}
