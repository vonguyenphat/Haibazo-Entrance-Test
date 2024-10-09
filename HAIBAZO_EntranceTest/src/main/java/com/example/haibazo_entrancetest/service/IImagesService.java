package com.example.haibazo_entrancetest.service;

import com.example.haibazo_entrancetest.model.Images;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Set;

@Service
public interface IImagesService {
    List<Images> createProductImages(List<Images> images);
}
