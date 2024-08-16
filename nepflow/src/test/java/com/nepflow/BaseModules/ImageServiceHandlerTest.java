package com.nepflow.BaseModules;

import com.nepflow.BaseModules.ImageModule.Service.ImageService;
import com.nepflow.BaseModules.ImageModule.Service.ImageServiceImpl;
import io.minio.MinioClient;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageServiceHandlerTest {


    @MockBean
    MinioClient minioClient;

    ImageService imageService = new ImageServiceImpl();

    Path resourceDirectory = Paths.get("src", "test", "resources", "Images");

    String directoryPath = resourceDirectory.toFile().getAbsolutePath();
    String testImageInputJPG = "JPGTest.jpg";
    String testImageInputPNG = "PNGTest.png";
    Path absInputJPGpath = Paths.get(directoryPath, testImageInputJPG);
    Path absInputPNGpath = Paths.get(directoryPath, testImageInputPNG);

    String testImagePNGOutput = "PNGTestOutput.webp";
    String testImageJPGOutput = "JPGTestOutput.webp";

    String bucketName = "nepflow";
    String bucketPath = "upload-species";


    @Test
    public void ImageServiceTest() throws IOException {
        String imagePathAndDataJPG;
        String imagePathAndDataPNG;
        // Save Image Test begins
        FileInputStream inputJPG = new FileInputStream(absInputJPGpath.toString());
        FileInputStream inputPNG = new FileInputStream(absInputPNGpath.toString());
        MultipartFile multipartFilePNG;
        MultipartFile multipartFileJPG;
        BufferedImage image;

        multipartFilePNG = new MockMultipartFile("fileItem",
                testImagePNGOutput, "image/png", IOUtils.toByteArray(inputPNG));

        multipartFileJPG = new MockMultipartFile("fileItem",
                testImageJPGOutput, "image/jpg", IOUtils.toByteArray(inputJPG));



        int i = 4;
        long j = 2;
        j = i + j;
        System.out.println(i);



    }


}
