package project.ebsher.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.ebsher.Entity.Email;
import project.ebsher.Service.EmailService;

@RestController
@RequestMapping("api/v1/emails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void sendEmail(@RequestBody Email email) {
        emailService.sendEmail(email);
    }
}
