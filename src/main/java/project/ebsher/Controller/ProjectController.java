package project.ebsher.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.ebsher.Entity.Project;
import project.ebsher.Entity.dto.NewProject;
import project.ebsher.Service.ProjectService;
import project.ebsher.Service.S3Service;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
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

    @PostMapping("/{projectId}/images")
    void uploadProjectImages(@RequestParam("images") List<MultipartFile> images, @PathVariable(value = "projectId") long projectId) throws IOException {
        s3Service.uploadProjectImages(projectId, images);
    }

    @DeleteMapping("{projectId}")
    void RemoveProjects(@PathVariable(value = "projectId") long projectId) {
        projectService.deleteProjectById(projectId);
    }

}


