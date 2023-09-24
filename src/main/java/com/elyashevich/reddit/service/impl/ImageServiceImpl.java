package com.elyashevich.reddit.service.impl;

import com.elyashevich.reddit.mapping.ImageMapping;
import com.elyashevich.reddit.model.Image;
import com.elyashevich.reddit.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageMapping imageMapping;

    @Override
    public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Image> images = new HashSet<>();
        for (MultipartFile file : multipartFiles) {
            Image image = imageMapping.convert(file);
            images.add(image);
        }
        return images;
    }
}