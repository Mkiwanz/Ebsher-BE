package project.ebsher.Entity.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import project.ebsher.Entity.Helpers.MultipartFileDeserializer;
import project.ebsher.Entity.Image;

import java.time.LocalDate;
import java.util.List;

@Data
public class NewProject {

    long id;
    String title;
    String description;
    String projectDescription;
    String location;
    LocalDate date;
    String note;

    @JsonDeserialize(contentUsing = MultipartFileDeserializer.class)
    List<MultipartFile> images;
}
