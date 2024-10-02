package com.example.haibazo_entrancetest.service.iml;

import com.example.haibazo_entrancetest.model.Images;
import com.example.haibazo_entrancetest.repository.IImageRepository;
import com.example.haibazo_entrancetest.service.IImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServiceIml implements IImagesService {
    @Autowired
    IImageRepository imageRepository;
    @Override
    public List<Images> createProductImages(List<Images> images) {
        return imageRepository.saveAll(images);
    }
}
