package org.example.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class NotificationSender {

    private NotificationService notificationService;

    @Autowired
    public NotificationSender(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostConstruct
    public void init() {
        System.out.println("NotificationSender init");
    }

    public void sendNotification(String message) {
        notificationService.sendNotification(message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("NotificationSender destroy");
    }
}
