package com.eafit.tutorial09b.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorage {
    void store(MultipartFile file);
}