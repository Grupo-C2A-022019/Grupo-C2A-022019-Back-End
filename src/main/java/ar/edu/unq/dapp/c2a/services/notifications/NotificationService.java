package ar.edu.unq.dapp.c2a.services.notifications;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

public interface NotificationService {
    void sendOrderCollectedNotification(Invoice invoice);
}
