package ar.edu.unq.dapp.c2a.services.notifications;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationsServiceImp implements NotificationService{

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationsServiceImp(JavaMailSender javaMailSender){

        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendOrderCollectedNotification(Invoice invoice) {
        SimpleMailMessage msg = new SimpleMailMessage();
        String email = invoice.getClient().getEmail();
        msg.setTo(email);

        msg.setSubject("Notificacion");
        msg.setText("Su orden a sido procesada");

        javaMailSender.send(msg);
    }

}
