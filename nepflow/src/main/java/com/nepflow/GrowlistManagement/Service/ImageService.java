package com.nepflow.GrowlistManagement.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

     String saveImageToStorageWebp(String uploadDirectory,String uniqueFileName, MultipartFile imageFile);

     String saveImageToStorageWebp(String uploadDirectory, MultipartFile imageFile);

     boolean deleteImage(String imageDirectory, String imageName) throws IOException;

     byte[] getImage(String imageDirectory, String imageName) throws IOException;

}