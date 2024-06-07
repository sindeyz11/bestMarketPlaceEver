package com.example.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageDTO {
    private Integer image_id;
    private byte[] image;
    private String alt;
}
