package pl.sda.final_project.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final JavaMailSender javaMailSender;


    public MessageService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    void sendResetMail(String token, String mail){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setSubject("Reset your password");
        simpleMailMessage.setText("localhost:8080/reset/" + token);
        javaMailSender.send(simpleMailMessage);
    }
}
