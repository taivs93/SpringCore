package org.example.notifications;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PushNotification implements NotificationService{

    @Value("{notification.push.title}")
    private String title;

    @PostConstruct
    public void init() {
        System.out.println("Push notification service started with title: " + title);
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Push Notification: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Push notification service stopped");
    }
}
