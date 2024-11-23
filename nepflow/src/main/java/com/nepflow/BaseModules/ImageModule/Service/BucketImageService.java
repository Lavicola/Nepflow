package com.nepflow.BaseModules.ImageModule.Service;

import com.nepflow.BaseModules.Exception.CouldNotSaveImage;
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

public interface BucketImageService {


    /**
     * @param bucketname
     * @return
     */
    boolean createPublicBucketIfNotExists(String bucketname);

    /**
     * @param bucketname
     * @return
     */
    boolean makeBucketPublic(String bucketname);


    /**
     * @param bucketname name of the bucket to store the image into
     * @param path       path of where the  bucket can be found
     * @param filename   name of the file
     * @param imageFile  image as MultipartFile
     * @return absolute Path where the Image can be found
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    String convertAndSaveImageRoutine(String bucketname, String path, String filename, MultipartFile imageFile)
            throws IOException, NoSuchAlgorithmException;


    /**
     * @param bucketname
     * @param path
     * @param filename
     * @param extension
     * @param bytes
     * @param mediaType
     * @return
     * @throws NoSuchAlgorithmException
     */
    String saveImageToBucket(String bucketname, String path, String filename, String extension,
                             byte[] bytes, String mediaType) throws CouldNotSaveImage;

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

    /**
     * @param bucketname
     * @param absolutePath
     * @return
     */
    boolean objectExist(final String bucketname, final String absolutePath);


    /**
     * @param url
     * @param bucketname
     * @param path
     * @return absolute Path where the Image can be found
     */
    String copyImageByUrl(String url, String bucketname, String path) throws IOException;

    /**
     * @param url
     * @return byte Array of the Resource
     */
    byte[] downloadResourceByUrl(String url) throws IOException;


}
