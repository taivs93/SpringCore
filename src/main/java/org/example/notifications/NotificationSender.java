package org.example.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class NotificationSender {


    private NotificationService notificationService;

    private NotificationService smsmNotificationService;

    private NotificationService emailNotification;

    private NotificationService pushNotification;

    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Autowired
    @Qualifier("smsNotification")
    public void setSmsNotificationService(NotificationService smsmNotificationService) {
        this.smsmNotificationService = smsmNotificationService;
        this.notificationService = smsmNotificationService;
    }

    @Autowired
    @Qualifier("emailNotification")
    public void setEmailNotification(NotificationService emailNotification) {
        this.emailNotification = emailNotification;
        this.notificationService = emailNotification;
    }

    @Autowired
    @Qualifier("pushNotification")
    public void setPushNotification(NotificationService pushNotification) {
        this.pushNotification = pushNotification;
        this.notificationService = pushNotification;
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
