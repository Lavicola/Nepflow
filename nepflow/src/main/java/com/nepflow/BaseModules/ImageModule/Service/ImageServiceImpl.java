package com.nepflow.BaseModules.ImageModule.Service;

import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    MinioClient minioClient;

    @Value("${minio.url}")
    private String url;

    @Value("${minio.port}")
    private int port;


    @Override
    public String saveImageToStorageWebp(String bucketname, String path, String fileName, MultipartFile imageFile) throws IOException, NoSuchAlgorithmException {
        String pathFileExten;
        ByteArrayInputStream byteArrayInputStream = null;
        pathFileExten = String.format("%s/%s.webp",path,Digest.sha256Hash(fileName));

        if (!createBucketIfNotExists(bucketname)) {
            throw new RuntimeException("Could not create Bucket");
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(convertImageToWebp(imageFile).toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Could not Convert Image to Webp");
        }
        try {
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketname).
                            object(pathFileExten).stream(
                                    byteArrayInputStream, byteArrayInputStream.available(), -1)
                            .contentType("img/webp")
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Could not Upload File:" + e);
        }

        return String.format("%s:%s/%s/%s", url, port, bucketname, pathFileExten);

    }

    @Override
    public ByteArrayOutputStream convertImageToWebp(MultipartFile imageFile) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedImage image = null;
        image = ImageIO.read(imageFile.getInputStream());
        ImageIO.write(image, "webp", byteArrayOutputStream);
        byteArrayOutputStream.close();

        return byteArrayOutputStream;
    }

    private boolean createBucketIfNotExists(String bucketName) {

        try {
            boolean bucketExists;
            bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());

            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }


    @Override
    public boolean deleteImage(String bucketname, String path, String filename) throws NoSuchAlgorithmException {
        String pathFileExten = String.format("%s/%s.webp",path,Digest.sha256Hash(filename));
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder().bucket(bucketname).object(pathFileExten).build();
        try {
            minioClient.removeObject(removeObjectArgs);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public byte[] getImage(String imageDirectory, String imageName) throws IOException {
        // TODO at some point
        return new byte[0];
    }



}
