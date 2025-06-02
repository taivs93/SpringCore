package org.example.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PrototypeBean {
    private int count = 0;

    @PostConstruct
    public void init() {
        count++;
        System.out.println("PrototypeBean init");
    }

    public void printCount() {
        System.out.println("PrototypeBean count: " + count);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PrototypeBean destroy");
    }

}
