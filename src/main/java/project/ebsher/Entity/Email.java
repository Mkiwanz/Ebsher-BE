package project.ebsher.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    String senderName;
    String senderEmail;
    String subject;
    String message;
}
