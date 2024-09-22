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

/**
 * Implements Methods in order convert and store webp Images to a MinIO server.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@Service
public class ImageServiceImpl implements ImageService {

    /**
     *
     */
    @Autowired
    private MinioClient minioClient;

    /**
     *
     */
    @Value("${minio.url}")
    private String url;

    /**
     *
     */
    @Value("${minio.port}")
    private int port;


    /**
     * @param bucketname name of the bucket to store the image into
     * @param path       path of where the  bucket can be found
     * @param filename   name of the file
     * @param imageFile  image
     * @return absolute Path where the Image can be found
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Override
    public String saveImageToStorageWebp(final String bucketname, final String path,
                                         final String filename, final MultipartFile imageFile)
            throws IOException, NoSuchAlgorithmException {
        String pathFileExten;
        ByteArrayInputStream byteArrayInputStream = null;
        pathFileExten = String.format("%s/%s.webp", path, Digest.sha256Hash(filename));

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

    /**
     * @param imageFile file to be converted to webp
     * @return bytes of the converted Image
     * @throws IOException
     */
    @Override
    public ByteArrayOutputStream convertImageToWebp(final MultipartFile imageFile) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedImage image = null;
        image = ImageIO.read(imageFile.getInputStream());
        ImageIO.write(image, "webp", byteArrayOutputStream);
        byteArrayOutputStream.close();

        return byteArrayOutputStream;
    }

    /**
     * @param bucketName name of the bucket to be created
     * @return true if bucket could be created or already did exist
     */
    private boolean createBucketIfNotExists(final String bucketName) {

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


    /**
     * @param bucketname name of the bucket to store the image into
     * @param url        absolute path to the image
     * @return true if image could be deleted
     */
    @Override
    public boolean deleteImage(final String bucketname, final String url) {
        String pathFileExten = url.split(bucketname)[1];
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder().
                bucket(bucketname).object(pathFileExten).build();
        try {
            minioClient.removeObject(removeObjectArgs);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
