package com.eafit.tutorial09b.config;

import com.eafit.tutorial09b.interfaces.ImageStorage;
import com.eafit.tutorial09b.utils.ImageLocalStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageServiceProvider {

    @Bean
    public ImageStorage imageStorage() {
        return new ImageLocalStorage();
    }
}