package com.nepflow.BaseModules.ImageModule.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface ImageService {

     String saveImageToStorageWebp(String bucketname,String path, String filename, MultipartFile imageFile) throws IOException, NoSuchAlgorithmException;

     ByteArrayOutputStream convertImageToWebp(MultipartFile imageFile) throws IOException;
     boolean deleteImage(String bucketname,String url);

     byte[] getImage(String imageDirectory, String imageName) throws IOException;



}