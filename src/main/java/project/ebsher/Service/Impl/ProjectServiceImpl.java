package project.ebsher.Service.Impl;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.ebsher.Entity.Image;
import project.ebsher.Entity.Project;
import project.ebsher.Entity.dto.NewProject;
import project.ebsher.Repository.ProjectRepo;
import project.ebsher.Service.ProjectService;
import project.ebsher.Service.S3Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;
    private final S3Service s3Service;

    public ProjectServiceImpl(ProjectRepo projectRepo, S3Service s3Service) {
        this.projectRepo = projectRepo;
        this.s3Service = s3Service;

    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public Project findAllById(long id) {
        return projectRepo.findAllById(id);
    }

    @Override
    public void deleteProjectById(long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public long addNewProject(NewProject project) throws IOException {
        Project newProject = new Project();
        newProject.setProjectDescription(project.getProjectDescription());
        newProject.setDescription(project.getDescription());
        newProject.setNote(project.getNote());
        newProject.setDate(project.getDate());
        newProject.setTitle(project.getTitle());
        newProject.setLocation(project.getLocation());
        projectRepo.save(newProject);
        long projId = projectRepo.findMaxId();
        return projId;

    }

//    @Override
//    public void addNewProject(NewProject project) throws IOException {
//        Project newProject = new Project();
//        newProject.setProjectDescription(project.getProjectDescription());
//        newProject.setDescription(project.getDescription());
//        newProject.setNote(project.getNote());
//        newProject.setDate(project.getDate());
//        newProject.setTitle(project.getTitle());
//        newProject.setLocation(project.getLocation());
//        List<Image> imagesList = new ArrayList<>();
//        for (MultipartFile file : project.getImages()) {
//            Image image = new Image();
//            image.setSize(file.getSize());
//            image.setName(file.getOriginalFilename());
//            image.setPath("https://s3.amazonaws.com/ebsher/" + file.getOriginalFilename());
//            image.setCreatedAt(LocalDateTime.now());
//            imagesList.add(image);
//        }
//        newProject.setImages(imagesList);
//        projectRepo.save(newProject);
//        s3Service.uploadProjectImages(projectRepo.findMaxId().getId() + 1, project.getImages());
//    }
}
