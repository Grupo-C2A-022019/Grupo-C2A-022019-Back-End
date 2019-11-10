package ar.edu.unq.dapp.c2a.aspects;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class SendMail {

    @Autowired
    private JavaMailSender javaMailSender;

    @Around("@annotation(SendMailAnnotation)")
    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("tobiascalvento@hotmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
}



