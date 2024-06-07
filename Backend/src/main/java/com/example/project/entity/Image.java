package com.example.project.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.sql.Blob;

@Data
@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    @Column(name = "alt")
    private String alt;
}
