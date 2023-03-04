package project.ebsher.Entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewProject {

    long id;
    String title;
    String description;
    String projectDescription;
    String location;
    LocalDate date;
    String note;
}
