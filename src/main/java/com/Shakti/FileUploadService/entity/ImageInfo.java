package com.Shakti.FileUploadService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ImageInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ImageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    @Lob//anotation to store any binary format in db
    @Column(name = "imageData")
    private byte[] imageData;
}
