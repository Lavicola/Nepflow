package com.nepflow.Growlistmanagement.Service;

import com.nepflow.GrowlistManagement.Service.ImageServiceFileStorageImpl;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImageServiceHandlerTest {

    ImageServiceFileStorageImpl imageService = new ImageServiceFileStorageImpl();

    Path resourceDirectory = Paths.get("src", "test", "resources", "Images");
    Path outputdirectory = Paths.get("src", "test", "resources", "Images", "Test");

    String directoryPath = resourceDirectory.toFile().getAbsolutePath();
    String testImageInputJPG = "JPGTest.jpg";
    String testImageInputPNG = "PNGTest.png";
    Path absInputJPGpath = Paths.get(directoryPath, testImageInputJPG);
    Path absInputPNGpath = Paths.get(directoryPath, testImageInputPNG);

    String testImagePNGOutput = "PNGTestOutput.webp";
    String testImageJPGOutput = "JPGTestOutput.webp";
    Path absOutputJPGpath = Paths.get(outputdirectory.toString(), testImageJPGOutput);
    Path absOutputPNGpath = Paths.get(outputdirectory.toString(), testImagePNGOutput);


    @BeforeEach
    public void deleteFolderAndFiles() {
        deleteFolder();

    }

    @AfterEach
    public void delete() {
        deleteFolder();
    }

    public void deleteFolder() {
        try {
            if (outputdirectory.toFile().exists()) {
                FileUtils.cleanDirectory(outputdirectory.toFile());
                FileUtils.deleteDirectory(outputdirectory.toFile());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void ImageServiceTest() throws IOException {
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

        assertTrue(this.imageService.saveImageToStorageWebp(outputdirectory.toString(), testImageJPGOutput, multipartFileJPG));
        assertTrue(this.imageService.saveImageToStorageWebp(outputdirectory.toString(), testImagePNGOutput, multipartFilePNG));
        assertTrue(absOutputJPGpath.toFile().exists());
        assertTrue(absOutputPNGpath.toFile().exists());
        // Save Image Test ends
        // get image Test begins (both are actually webp
        // not much to test, using the c lib does show tiny difference in size
        byte[] jpgBytes = this.imageService.getImage(outputdirectory.toString(),testImageJPGOutput);
        byte[] pngBytes = this.imageService.getImage(outputdirectory.toString(),testImagePNGOutput);
        assertNotNull(jpgBytes);
        assertNotNull(pngBytes);
        // get image Test end
        // delete image Test begins
        assertTrue(this.imageService.deleteImage(outputdirectory.toString(),testImageJPGOutput));
        assertTrue(this.imageService.deleteImage(outputdirectory.toString(),testImagePNGOutput));
    }

}
