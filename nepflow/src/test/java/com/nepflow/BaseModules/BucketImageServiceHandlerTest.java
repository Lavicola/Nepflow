package com.nepflow.BaseModules;

import com.nepflow.BaseModules.ImageModule.Service.BucketImageService;
import io.minio.MinioClient;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.testcontainers.containers.MinIOContainer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BucketImageServiceHandlerTest {


    @Autowired
    BucketImageService bucketImageService;

    @Value("${minio.port}")
    String port;

    Path resourceDirectory = Paths.get("src", "test", "resources", "Images");

    String directoryPath = resourceDirectory.toFile().getAbsolutePath();
    String testImageInputJPG = "JPGTest.jpg";
    String testImageInputPNG = "PNGTest.png";
    Path absInputJPGpath = Paths.get(directoryPath, testImageInputJPG);
    Path absInputPNGpath = Paths.get(directoryPath, testImageInputPNG);

    String testImagePNGOutput = "PNGTestOutput.webp";
    String testImageJPGOutput = "JPGTestOutput.webp";

    String bucketName = "nepflow";
    String path = "upload-species";

    static String mappedPort;


    @TestConfiguration
    static class MinioConfig {

        @Value("${minio.access.name}")
        private String name;

        @Value("${minio.access.secret}")
        private String secret;

        @Value("${minio.port}")
        private int port;

        @Bean
        public MinioClient customClient() {
            MinIOContainer container = new MinIOContainer("minio/minio:RELEASE.2023-09-04T19-57-37Z")
                    .withUserName(this.name)
                    .withPassword(this.secret);
            container.start();
            String minioUrl = "http://" + container.getHost() + ":" + container.getMappedPort(port);
            BucketImageServiceHandlerTest.mappedPort = String.valueOf(container.getMappedPort(port));
            return MinioClient.builder()
                    .endpoint(minioUrl)
                    .credentials("testuser", "testpassword")
                    .build();
        }
    }


    @Test
    public void createBucketIfNotExistsTest() {
        assertTrue(this.bucketImageService.createPublicBucketIfNotExists(this.bucketName));
    }

    @Test
    public void makeBucketPublicTest() {
        this.bucketImageService.createPublicBucketIfNotExists(this.bucketName);
        assertTrue(this.bucketImageService.makeBucketPublic(this.bucketName));
    }


    @Test
    public void saveImageToBucketTest() throws IOException {
        FileInputStream inputJPG = new FileInputStream(absInputJPGpath.toString());
        String url = null;

        this.bucketImageService.createPublicBucketIfNotExists(this.bucketName);
        url = this.bucketImageService.saveImageToBucket(this.bucketName, path, this.testImageInputJPG, "jpg"
                , IOUtils.toByteArray(inputJPG), "img/jpg");
        assertNotNull(url);
    }

    @Test
    public void copyImageByUrlTest() throws IOException, NoSuchAlgorithmException {
        FileInputStream inputJPG = new FileInputStream(absInputJPGpath.toString());
        String secondPath = "upload2";
        String url = null;
        String urlOfCopiedImg;


        this.bucketImageService.createPublicBucketIfNotExists(this.bucketName);
        url = this.bucketImageService.saveImageToBucket(this.bucketName, path, this.testImageInputJPG, "jpg"
                , IOUtils.toByteArray(inputJPG), "img/jpg");
        // due to the mapping, change port in url
        url = url.replace(this.port, BucketImageServiceHandlerTest.mappedPort);
        urlOfCopiedImg = this.bucketImageService.copyImageByUrl(url, this.bucketName, secondPath);
        assertNotNull(urlOfCopiedImg);
    }


    @Test
    public void convertAndSaveImageRoutineTest() throws IOException, NoSuchAlgorithmException {
        String imagePathAndDataJPG;
        String filename = "test";
        MultipartFile multipartFileJPG;
        String url;
        FileInputStream inputJPG = new FileInputStream(absInputJPGpath.toString());
        multipartFileJPG = new MockMultipartFile("fileItem",
                testImageJPGOutput, "image/jpg", IOUtils.toByteArray(inputJPG));
        url = this.bucketImageService.convertAndSaveImageRoutine(this.bucketName, this.path,
                filename, multipartFileJPG);
        assertNotNull(url);


    }


    @Test
    public void saveImageToStorageTest() throws IOException {
        String urlString = "http://192.168.188.44:9000/nepflow/upload-specimens/ee53af7c24c5ded565dd9b99945d0f75fad0b1f70473b47d5f9e8cf670def94f.webp";

    }


    @Test
    public void deleteImageTest() throws IOException {
        String urlString = "http://192.168.188.44:9000/nepflow/upload-specimens/ee53af7c24c5ded565dd9b99945d0f75fad0b1f70473b47d5f9e8cf670def94f.webp";

    }


    @Test
    public void objectExistTest() throws IOException {
        String urlString = "http://192.168.188.44:9000/nepflow/upload-specimens/ee53af7c24c5ded565dd9b99945d0f75fad0b1f70473b47d5f9e8cf670def94f.webp";

    }


}