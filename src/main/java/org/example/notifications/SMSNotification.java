package org.example.notifications;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SMSNotification implements NotificationService{

    @Value("notification.sms.prefix")
    private String prefix;

    @PostConstruct
    public void init() {
        System.out.println("SMSNotification init with prefix: " + prefix);
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SMSNotification destroy");
    }

}
