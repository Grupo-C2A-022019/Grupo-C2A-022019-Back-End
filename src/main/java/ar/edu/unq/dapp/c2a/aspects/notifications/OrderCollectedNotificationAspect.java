package ar.edu.unq.dapp.c2a.aspects.notifications;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.services.notifications.NotificationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class OrderCollectedNotificationAspect {

    private NotificationService notificationService;

    @Autowired
    public OrderCollectedNotificationAspect(NotificationService notificationService) { this.notificationService = notificationService;}





    @Around("@annotation(ar.edu.unq.dapp.c2a.aspects.SendMailAnnotation)")
    void sendEmail(JoinPoint jp) {
        Client clienteInyectado = (Client) jp.getThis();
        Invoice invoice = (Invoice) jp.getArgs()[0];

        clienteInyectado.getAccount();

        notificationService.notifyOrderCollected(clienteInyectado,invoice);
    }


}



