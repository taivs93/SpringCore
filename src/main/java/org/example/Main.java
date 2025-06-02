package org.example;

import org.example.beans.PrototypeBean;
import org.example.beans.SingletonBean;
import org.example.config.AppConfig;
import org.example.notifications.NotificationSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        singletonBean1.printCount();
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        singletonBean2.printCount();

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        prototypeBean1.printCount();
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        prototypeBean2.printCount();

        NotificationSender notificationSender = context.getBean(NotificationSender.class);
        notificationSender.sendDefaultNotification("Hi");
        notificationSender.sendNotification("sms","Hi");
        notificationSender.sendNotification("email","Hi");
        notificationSender.sendNotification("push","Hi");

        ((AnnotationConfigApplicationContext) context).close();
    }
}