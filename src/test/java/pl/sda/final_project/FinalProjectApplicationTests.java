package pl.sda.final_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = "local")
@SpringBootTest
class FinalProjectApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("javawro27@gmail.com");
        simpleMailMessage.setTo("marek80k@wp.pl");
        simpleMailMessage.setText("Hello World");

        javaMailSender.send(simpleMailMessage);
    }



}
