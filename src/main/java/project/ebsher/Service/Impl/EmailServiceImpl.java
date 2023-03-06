package project.ebsher.Service.Impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import project.ebsher.Entity.Email;
import project.ebsher.Service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getSenderEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getMessage());
        mailSender.send(message);
    }
}
