package com.Shakti.FileUploadService.repository;

import com.Shakti.FileUploadService.entity.ImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepo extends JpaRepository<ImageInfo,Long> {

    Optional<ImageInfo> findByName(String fileName);
}
