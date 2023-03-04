package project.ebsher.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.ebsher.Entity.Project;
import project.ebsher.Entity.dto.NewProject;
import project.ebsher.Service.Impl.S3ServiceImpl;
import project.ebsher.Service.ProjectService;
import project.ebsher.Service.S3Service;

import java.io.IOException;
import java.util.List;
import java.io.InputStream;

@RestController
@RequestMapping("api/v1/projects")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
    //String projectPath = System.getProperty("user.dir");
    private final S3Service s3Service;
    private final ProjectService projectService;

    public ProjectController(S3Service s3Service, ProjectService projectService) {
        this.s3Service = s3Service;
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> GetAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("{id}")
    public Project GetAllProjectsById(@PathVariable(name = "id") long id) {
        return projectService.findAllById(id);
    }

    @PostMapping
    public long AddNewProject(@RequestBody NewProject project) throws IOException {
        return projectService.addNewProject(project);
    }

//    @PostMapping("/{projectId}")
//    public String uploadImage(@PathVariable Long projectId, @RequestParam("file") MultipartFile file) throws IOException {
//        InputStream inputStream = file.getInputStream();
//        String fileName = file.getOriginalFilename();
//        return s3Service.uploadProjectImages(inputStream, fileName, projectId);
//    }

    @PostMapping("/{projectId}/images")
    void uploadProjectImages(@RequestParam("images") List<MultipartFile> images, @PathVariable(value = "projectId") long projectId) throws IOException {
        s3Service.uploadProjectImages(projectId, images);
    }
//
//    @GetMapping("/project/{projectId}")
//    public List<byte[]> getImagesByProjectId(@PathVariable Long projectId) {
//        return s3Service.getImagesByProjectId(projectId);
//    }
}


//
//    @PostMapping("/{projectId}/images")
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
//        Image savedImage = new Image();
//
//        // Finally, save the image metadata to the database
//        var project = projectService.findAllById(projectId);
//        if (project != null) {
//            Image image = new Image();
//            image.setName(newFileName);
//            image.setProject(project);
//            image.setPath(filePath);
//            image.setSize(file.getSize());
//            image.setCreatedAt(LocalDateTime.now());
//            savedImage = imageService.saveImageMetadata(image);
//        }
//
//        return ResponseEntity.ok(savedImage);
//    }
//
//    @GetMapping("/{projectId}/images")
//    public ResponseEntity<?> getImagesByProjectId(@PathVariable Long projectId) {
//        List<Image> images = imageService.getImagesByProjectId(projectId);
//        return ResponseEntity.ok(images);
//    }

