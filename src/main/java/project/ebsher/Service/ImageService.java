package project.ebsher.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import project.ebsher.Entity.Image;

import java.io.IOException;
import java.util.List;

public interface ImageService {
//    void saveImage(MultipartFile file) throws IOException;
//
//    List<Resource> getImages(Long projectId);
//    Resource loadImage(Long projectId, String imageName);

    Image saveImageMetadata(Image image);

    List<Image> getImagesByProjectId(Long projectId);
}
