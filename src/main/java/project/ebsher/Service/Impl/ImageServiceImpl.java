package project.ebsher.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.ebsher.Entity.Image;
import project.ebsher.Repository.ImageRepo;
import project.ebsher.Service.ImageService;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {
//    @Value("${image.upload.path}")
//    private String imageUploadPath;

    @Autowired
    private ImageRepo imageRepository;

    public Image saveImageMetadata(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> getImagesByProjectId(Long projectId) {
        return imageRepository.findAllByProject_Id(projectId);
    }

//    @Override
//    public void saveImage(MultipartFile file) throws IOException {
//        Path uploadPath = Paths.get(imageUploadPath);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        try (InputStream inputStream = file.getInputStream()) {
//            Path filePath = uploadPath.resolve(file.getOriginalFilename());
//            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//        }
//    }
//
//    @Override
//    public List<Resource> getImages(Long projectId) {
//        try {
//            Path projectPath = Paths.get(imageUploadPath).resolve(String.valueOf(projectId));
//            if (Files.exists(projectPath)) {
//                return Files.list(projectPath)
//                        .filter(Files::isRegularFile)
//                        .map(this::loadImageResource)
//                        .collect(Collectors.toList());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();
//    }
//
//    private Resource loadImageResource(Path imagePath) {
//        try {
//            Resource resource = new UrlResource(imagePath.toUri());
//            if (resource.exists() || resource.isReadable()) {
//                return resource;
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public Resource loadImage(Long projectId, String imageName) {
//        try {
//            Path imagePath = Paths.get(imageUploadPath).resolve(String.valueOf(projectId)).resolve(imageName).normalize();
//            Resource resource = new UrlResource(imagePath.toUri());
//            if (resource.exists()) {
//                return resource;
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }


}

