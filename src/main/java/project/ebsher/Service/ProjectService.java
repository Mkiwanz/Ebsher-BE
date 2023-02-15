package project.ebsher.Service;

import org.springframework.stereotype.Service;
import project.ebsher.Entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findAllById(long id);
}
