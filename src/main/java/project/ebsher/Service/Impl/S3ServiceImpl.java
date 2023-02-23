package project.ebsher.Service.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.amazonaws.services.s3.model.*;
import jakarta.transaction.Transactional;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.web.bind.annotation.PathVariable;
import project.ebsher.Service.S3Service;

@Service
@Transactional
public class S3ServiceImpl implements S3Service {

    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    private final AmazonS3 s3client;
    private final S3ServiceImpl s3ServiceImpl;

    public S3ServiceImpl(AmazonS3 s3client, S3ServiceImpl s3ServiceImpl) {
        this.s3client = s3client;
        this.s3ServiceImpl = s3ServiceImpl;
    }

    public String uploadFile(InputStream inputStream, String fileName, Long projectId) throws IOException {
        String key = projectId + "/" + UUID.randomUUID().toString() + fileName;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(inputStream.available());
        PutObjectRequest request = new PutObjectRequest(bucketName, key, inputStream, metadata);
        s3client.putObject(request);
        return key;
    }

    public void deleteFile(String key) {
        s3client.deleteObject(bucketName, key);
    }

    public List<String> getKeysByProjectId(Long projectId) {
        List<String> keys = new ArrayList<>();
        String projectPrefix = "project_" + projectId + "/";
        ListObjectsV2Request request = new ListObjectsV2Request()
                .withBucketName(bucketName)
                .withPrefix(projectPrefix);
        ListObjectsV2Result result;
        do {
            result = s3client.listObjectsV2(request);
            List<S3ObjectSummary> objectSummaries = result.getObjectSummaries();
            for (S3ObjectSummary objectSummary : objectSummaries) {
                keys.add(objectSummary.getKey());
            }
            request.setContinuationToken(result.getNextContinuationToken());
        } while (result.isTruncated());
        return keys;
    }

    public List<byte[]> getImagesByProjectId(@PathVariable Long projectId){

        List<String> keys = s3ServiceImpl.getKeysByProjectId(projectId);
        List<byte[]> images = new ArrayList<>();
        for (String key : keys) {
            try {
                S3Object s3object = s3client.getObject(bucketName, key);
                images.add(IOUtils.toByteArray(s3object.getObjectContent()));
            } catch (IOException e) {
                throw new RuntimeException("Error retrieving image from S3", e);
            }
        }
        return images;
    }

}
