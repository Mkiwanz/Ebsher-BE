package project.ebsher.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import project.ebsher.Entity.Project;
import project.ebsher.Entity.dto.NewProject;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findAllById(long id);

    long addNewProject(NewProject project) throws IOException;
}
