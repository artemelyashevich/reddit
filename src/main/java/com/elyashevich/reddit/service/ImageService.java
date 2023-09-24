package com.elyashevich.reddit.service;

import com.elyashevich.reddit.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface ImageService {
    Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException;
}
