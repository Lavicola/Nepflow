package com.nepflow.BaseModules.ImageModule.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nepflow.BaseModules.Exception.CouldNotReachStorage;
import com.nepflow.BaseModules.Exception.CouldNotSaveImage;
import io.minio.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

/**
 * Implements Methods in order convert and store webp Images to a MinIO server.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@Service
public class BucketImageServiceMinio implements BucketImageService {

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
     * converts a jpg/png file to webp and then stores it into a bucket while returning the location.
     * If a Bucket does not exist, a public Bucket will be created.
     *
     * @param bucketname name of the bucket to store the image into
     * @param path       path of where the  bucket can be found
     * @param filename   name of the file
     * @param imageFile  image
     * @return absolute Path where the Image can be found
     * @throws NoSuchAlgorithmException
     */
    @Override
    public String convertAndSaveImageRoutine(final String bucketname, final String path, final String filename, final MultipartFile imageFile) throws IOException {
        if (!createPublicBucketIfNotExists(bucketname)) {
            throw new RuntimeException("Could not create Bucket");
        }
        String filenameRandom = this.generateRandomFilename(filename);
        byte[] bytes = this.convertImageToWebp(imageFile).toByteArray();

        return this.saveImageToBucket(bucketname, path, filenameRandom, "webp", bytes, "img/webp");
    }

    /**
     * Method to store an image to a specific bucket with path. Assume the Bucket already exists.
     *
     * @param bucketname
     * @param path
     * @param filename
     * @param extension
     * @param bytes
     * @param contentType
     * @return absolute Path where the Image can be found
     */
    @Override
    public String saveImageToBucket(final String bucketname, final String path, final String filename, final String extension, final byte[] bytes, final String contentType) throws CouldNotSaveImage {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        String absolutePath = this.generatePath(path, filename, extension);

        try {
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketname).object(absolutePath).stream(byteArrayInputStream, byteArrayInputStream.available(), -1).contentType(contentType).build());
        } catch (Exception e) {
            throw new CouldNotSaveImage(e.getMessage());
        }
        return this.generateUrl(bucketname, path, filename, extension);
    }

    /**
     * Converts a Jpg or Png Image into a webp.
     *
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
     * @param bucketname name of the bucket to be created
     * @return true if bucket could be created or already did exist
     */
    public boolean createPublicBucketIfNotExists(final String bucketname) {

        try {
            boolean bucketExists;
            bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketname).build());
            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketname).build());
                this.makeBucketPublic(bucketname);
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * @param bucketname
     * @return true if Policy could set without Exception
     */
    @Override
    public boolean makeBucketPublic(final String bucketname) {
        try {
            String test = String.format("{\n" + "  \"Version\": \"2012-10-17\",\n" + "  \"Statement\": [\n" + "    {\n" + "      \"Action\": [\n" + "        \"s3:GetObject\"\n" + "      ],\n" + "      \"Effect\": \"Allow\",\n" + "      \"Principal\": {\n" + "        \"AWS\": [\n" + "          \"*\"\n" + "        ]\n" + "      },\n" + "      \"Resource\": [\n" + "        \"arn:aws:s3:::%s/*\"\n" + "      ],\n" + "      \"Sid\": \"\"\n" + "    }\n" + "  ]\n" + "}", bucketname);
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketname).config(test).build());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
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

        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder().bucket(bucketname).object(pathFileExten).build();
        try {
            minioClient.removeObject(removeObjectArgs);
        } catch (Exception e) {
            return false;
        }
        return true;

    }


    /**
     * Download an Image via url and copy it into bucket.
     * If collision is detected, the method will assume it´s the same Image and won´t
     * overwrite it.
     *
     * @param url
     * @param bucketname
     * @param path
     * @return
     */
    @Override
    public String copyImageByUrl(final String url, final String bucketname, final String path) throws IOException, CouldNotSaveImage {
        byte[] imageBytes = null;
        String filenameWithExtension = url.split("/")[url.split("/").length - 1];
        String filename = filenameWithExtension.split("\\.")[0];
        //TODO index out of range possible?
        String extension = filenameWithExtension.split("\\.")[1];
        imageBytes = this.downloadResourceByUrl(url);
        if (this.objectExist(bucketname, filename)) {
            // since file filenames are random and collisions unlikely, we can assume that in this case the image was already copied
            return this.generateUrl(bucketname, path, filename, extension);
        } else {
            //TODO for now leave img/webp as hardcoded string, at a later date check the mime
            return this.saveImageToBucket(bucketname, path, filename, extension, imageBytes, "img/webp");
        }

    }

    /**
     * @param url
     * @return byte Array of the Resource
     */
    @Override
    public byte[] downloadResourceByUrl(final String url) throws IOException {
        HttpResponse<InputStream> response = null;
        try {
            response = Unirest.get(url).asBinary();
        } catch (UnirestException e) {
            throw new CouldNotReachStorage(e.getMessage());
        }
        if (response.getStatus() != 200) {
            throw new CouldNotReachStorage(response.getBody().toString());
        }
        return IOUtils.toByteArray(response.getBody());
    }

    /**
     * @param filename
     * @return random filename using either sha256 with Mat.random or just Mat.random
     */
    private String generateRandomFilename(final String filename) {
        try {
            return String.format("%s", Digest.sha256Hash(filename + Math.random()));
        } catch (NoSuchAlgorithmException e) {
            return String.format("%s", filename + Math.random());
        }

    }

    /**
     * @param path
     * @param filename
     * @param extension
     * @return
     */
    private String generatePath(final String path, final String filename, final String extension) {
        return String.format("%s/%s.%s", path, filename, extension);

    }


    /**
     * @param bucketname
     * @param absolutePath
     * @return true if object exists, else false
     */
    public boolean objectExist(final String bucketname, final String absolutePath) {
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketname).object(absolutePath).build());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param bucketname
     * @param path
     * @param filename
     * @param extension
     * @return url with the precise location of the resource.
     */
    private String generateUrl(final String bucketname, final String path, final String filename,
                               final String extension) {
        return String.format("%s:%s/%s/%s/%s.%s", url, port, bucketname, path, filename, extension);

    }

}
