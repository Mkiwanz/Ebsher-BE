package project.ebsher.Service.Impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.s3.model.*;
import jakarta.transaction.Transactional;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import project.ebsher.Entity.Image;
import project.ebsher.Repository.ImageRepo;
import project.ebsher.Repository.ProjectRepo;
import project.ebsher.Service.S3Service;

@Service
@Transactional
public class S3ServiceImpl implements S3Service {

    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    private final AmazonS3 amazonS3;
    private final ProjectRepo projectRepo;
    private final ImageRepo imageRepo;

    public S3ServiceImpl(AmazonS3 s3client, ProjectRepo projectRepo, ImageRepo imageRepo) {
        this.amazonS3 = s3client;
        this.projectRepo = projectRepo;
        this.imageRepo = imageRepo;
    }

    public void uploadProjectImages(long projectId, MultipartFile image) throws IOException {
//        String key = projectId + "/" + UUID.randomUUID().toString() + fileName;
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(inputStream.available());
//        PutObjectRequest request = new PutObjectRequest(bucketName, key, inputStream, metadata);
//        s3client.putObject(request);
//        return key;

        String imageName = image.getOriginalFilename();
        String imageType = image.getContentType();
        byte[] imageBytes = image.getBytes();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(imageType);
        objectMetadata.setContentLength(imageBytes.length);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);

        amazonS3.putObject("ebsher", imageName, inputStream, objectMetadata);

        Image newImage = new Image();
        newImage.setName(imageName);
        newImage.setProject(projectRepo.findById(projectId).get());
        newImage.setPath("https://s3.amazonaws.com/ebsher/" + imageName);
        imageRepo.save(newImage);
    }
//
//    public void deleteFile(String key) {
//        amazonS3.deleteObject(bucketName, key);
//    }
//
//    public List<String> getKeysByProjectId(Long projectId) {
//        List<String> keys = new ArrayList<>();
//        String projectPrefix = "project_" + projectId + "/";
//        ListObjectsV2Request request = new ListObjectsV2Request()
//                .withBucketName(bucketName)
//                .withPrefix(projectPrefix);
//        ListObjectsV2Result result;
//        do {
//            result = amazonS3.listObjectsV2(request);
//            List<S3ObjectSummary> objectSummaries = result.getObjectSummaries();
//            for (S3ObjectSummary objectSummary : objectSummaries) {
//                keys.add(objectSummary.getKey());
//            }
//            request.setContinuationToken(result.getNextContinuationToken());
//        } while (result.isTruncated());
//        return keys;
//    }
//
//    public List<byte[]> getImagesByProjectId(@PathVariable Long projectId) {
//
//        List<String> keys = s3ServiceImpl.getKeysByProjectId(projectId);
//        List<byte[]> images = new ArrayList<>();
//        for (String key : keys) {
//            try {
//                S3Object s3object = amazonS3.getObject(bucketName, key);
//                images.add(IOUtils.toByteArray(s3object.getObjectContent()));
//            } catch (IOException e) {
//                throw new RuntimeException("Error retrieving image from S3", e);
//            }
//        }
//        return images;
//    }

}
