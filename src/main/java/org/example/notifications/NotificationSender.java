package org.example.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;

@Component
public class NotificationSender {

    private NotificationService defaultNotificationService;

    private Map<String,NotificationService> notificationServices;

    @Autowired
    public NotificationSender(Map<String,NotificationService> notificationServices,NotificationService defaultNotificationService){
        this.notificationServices = notificationServices;
        this.defaultNotificationService = defaultNotificationService;
    }

    public void sendNotification(String type, String message){
        NotificationService notificationService = notificationServices.get(type);
        if(notificationService == null){
            System.out.println("No notification service found for type: " + type);
        }
        else{
            notificationService.sendNotification(message);
        }
    }

    public void sendDefaultNotification(String message){
        this.defaultNotificationService.sendNotification(message);
    }

    @PostConstruct
    public void init() {
        System.out.println("NotificationSender init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("NotificationSender destroy");
    }
}
