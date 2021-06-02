package com.zqz.blog.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class FileUtil {


    public static String MultipartFileToBase64(MultipartFile file) {
        try {
            return Base64Utils.encodeToString(file.getBytes());
        } catch (IOException e) {
            log.error("===>>>MultipartFile转换Base64异常", e);
            throw new RuntimeException("MultipartFile转换Base64异常");
        }
    }


    public static String fileToBase64(InputStream fis) {
        try {
            byte[] buff = new byte[fis.available()];
            return Base64Utils.encodeToString(buff);
        } catch (IOException e) {
            log.error("===>>>InputStream转换Base64异常", e);
            throw new RuntimeException("InputStream转换Base64异常");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void base64ToFile(String base64, String fileName) {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buff = Base64Utils.decodeFromString(base64);
            fos.write(buff);
        } catch (IOException e) {
            log.error("===>>>Base64转换File异常", e);
            throw new RuntimeException("===>>>Base64转换File异常");
        }
    }

}
