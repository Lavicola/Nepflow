package com.nepflow.BaseModules.ImageModule.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Interface which defines Methods in order store convert and store webp Images.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

public interface ImageService {

    /**
     * @param bucketname name of the bucket to store the image into
     * @param path       path of where the  bucket can be found
     * @param filename   name of the file
     * @param imageFile  image
     * @return absolute Path where the Image can be found
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    String saveImageToStorageWebp(String bucketname, String path, String filename, MultipartFile imageFile) throws IOException, NoSuchAlgorithmException;

    /**
     * @param imageFile file to be converted to webp
     * @return bytes of the converted Image
     * @throws IOException
     */
    ByteArrayOutputStream convertImageToWebp(MultipartFile imageFile) throws IOException;

    /**
     * @param bucketname name of the bucket to store the image into
     * @param url        absolute path to the image
     * @return true if image could be deleted
     */
    boolean deleteImage(String bucketname, String url);


}
