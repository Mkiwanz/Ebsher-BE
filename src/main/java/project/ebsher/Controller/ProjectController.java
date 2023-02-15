package project.ebsher.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.ebsher.Entity.Project;
import project.ebsher.Service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
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
}
