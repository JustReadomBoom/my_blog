package com.zqz.blog.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 14:09 2021/4/14
 */
@Service
@Slf4j
public class OssFileService {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String keyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String secret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    public String fileUpload(MultipartFile file, String fileName) {
        String folder = "zqz";
        fileName = folder + "/" + fileName;
        return upload(file, fileName);
    }

    private String upload(MultipartFile file, String fileName) {
        InputStream inputStream = null;
        OSS ossClient = null;
        try {
            //获取文件输入流
            inputStream = file.getInputStream();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("*/*");
            //创建OSSClient实例
            ossClient = new OSSClientBuilder().build(endpoint, keyId, secret);
            ossClient.putObject(bucketName, fileName, inputStream, metadata);
            return "https://" + bucketName + "." + endpoint + "/" + fileName;
        } catch (Exception e) {
            log.error("File upload error:[{}]", e.getMessage(), e);
            return null;
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != ossClient) {
                    ossClient.shutdown();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
