package com.nepflow.GrowlistManagement.Service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;


@Service
public class ImageServiceFileStorageImpl implements ImageService {


    @Override
    public String saveImageToStorageWebp(String uploadDirectory, String uniqueFileName, MultipartFile imageFile) {
        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);
        String filepath = filePath.toString().contains(".webp")?filePath.toString():filePath.toString()+".webp";
        File outputfile = new File(filepath);
        BufferedImage image = null;

        try {
            this.createFolders(outputfile);
            image = ImageIO.read(imageFile.getInputStream());
            ImageIO.write(image, "webp", outputfile);
        } catch (IOException e) {
            return null;
        }
        return outputfile.toString();
    }

    @Override
    public String saveImageToStorageWebp(String uploadDirectory, MultipartFile imageFile) {
        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
        return this.saveImageToStorageWebp(uploadDirectory, uniqueFileName, imageFile);
    }

    @Override
    public boolean deleteImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            Files.delete(imagePath);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public byte[] getImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);
        File file = new File(imagePath.toString());
        String fileExtension = FilenameUtils.getExtension(imageName);
        if(!file.exists()){
            throw new IOException();
        }
        BufferedImage image = ImageIO.read(file);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, fileExtension, baos);
            baos.flush();
            return baos.toByteArray();
        }
    }

    private void createFolders(File file) throws IOException {
        File parentDir = file.getParentFile();
        if(parentDir !=null && ! parentDir.exists() ){
            if(!parentDir.mkdirs()){
                throw new IOException("error creating directories");
            }
        }
    }

}
