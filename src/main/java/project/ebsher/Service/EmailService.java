package project.ebsher.Service;

import org.springframework.stereotype.Service;
import project.ebsher.Entity.Email;

public interface EmailService {
    void sendEmail(Email email);
}
