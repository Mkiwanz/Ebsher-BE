package project.ebsher.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name = "image")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

//    @Column(name = "project_id")
//    private Long projectId;

    private String path;

    private Long size;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonBackReference
    Project project;

    // Getters and setters
}
