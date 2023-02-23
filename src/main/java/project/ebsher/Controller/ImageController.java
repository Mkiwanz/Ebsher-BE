//package project.ebsher.Controller;
//
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import project.ebsher.Entity.Image;
//import project.ebsher.Service.ImageService;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/images")
//public class ImageController {
//
//    String projectPath = System.getProperty("user.dir");
//
//    private final ImageService imageService;
//    private final ImageService imageService;
//
//    public ImageController(ImageService imageService) {
//        this.imageService = imageService;
//    }
//
//
//    @PostMapping("/{projectId}")
//    public ResponseEntity<?> uploadImage(@PathVariable Long projectId, @RequestParam("file") MultipartFile file) throws IOException {
//        // First, generate a unique filename for the uploaded file
//        String originalFileName = file.getOriginalFilename();
//        String extension = FilenameUtils.getExtension(originalFileName);
//        String newFileName = UUID.randomUUID().toString() + "." + extension;
//
//        // Next, save the file to the server file system
//        String uploadDir = projectPath + "/Images"; // Replace with your upload directory path
//        File uploadPath = new File(uploadDir);
//        if (!uploadPath.exists()) {
//            uploadPath.mkdirs();
//        }
//        String filePath = uploadDir + "/" + newFileName;
//        File dest = new File(filePath);
//        file.transferTo(dest);
//
//        // Finally, save the image metadata to the database
//        Image image = new Image();
//        image.setName(newFileName);
//        image.setProject(projectId);
//        image.setPath(filePath);
//        image.setSize(file.getSize());
//        image.setCreatedAt(LocalDateTime.now());
//        Image savedImage = imageService.saveImageMetadata(image);
//
//        return ResponseEntity.ok(savedImage);
//    }
//
//    @GetMapping("/{projectId}")
//    public ResponseEntity<?> getImagesByProjectId(@PathVariable Long projectId) {
//        List<Image> images = imageService.getImagesByProjectId(projectId);
//        return ResponseEntity.ok(images);
//    }
//}
