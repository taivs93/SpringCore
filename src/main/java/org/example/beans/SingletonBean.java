package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class SingletonBean {
    private static int count = 0;

    @PostConstruct
    public void init() {
        count++;
        System.out.println("SingletonBean init");
    }

    public void printCount() {
        System.out.println("SingletonBean count: " + count);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SingletonBean destroy");
    }
}
