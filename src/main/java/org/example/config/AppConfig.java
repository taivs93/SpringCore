package org.example.config;

import org.example.beans.PrototypeBean;
import org.example.beans.SingletonBean;
import org.example.notifications.EmailNotification;
import org.example.notifications.NotificationService;
import org.example.notifications.PushNotification;
import org.example.notifications.SMSNotification;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    @Primary
    public NotificationService emailNotification() {
        return new EmailNotification();
    }

    @Bean
    public NotificationService pushNotification() {
        return new PushNotification();
    }

    @Bean
    public NotificationService smsNotification() {
        return new SMSNotification();
    }


}
