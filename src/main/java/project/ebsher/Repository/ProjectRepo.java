package project.ebsher.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.ebsher.Entity.Project;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    List<Project> findAll();

    Project findAllById(long id);

    @Query("select max(e.id) from Project e")
    long findMaxId();


}
