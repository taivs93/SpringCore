package org.example.notifications;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("email")
@Primary
public class EmailNotification implements NotificationService {

    @Value("${notification.email.domain}")
    private String domain;

    @PostConstruct
    public void init() {
        System.out.println("Email notification service initialized with domain: " + domain);
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notification: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Email notification service destroyed");
    }
}
