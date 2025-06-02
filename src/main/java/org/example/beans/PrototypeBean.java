package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class PrototypeBean {
    private static int count = 0;

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
