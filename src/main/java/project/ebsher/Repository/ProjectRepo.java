package project.ebsher.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.ebsher.Entity.Project;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    List<Project> findAll();

    Project findAllById(long id);

}