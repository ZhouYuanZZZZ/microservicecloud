package com.zy.springboot.conf.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Entity0 {

    @Value("${test.a1}")
    private String a1;
    @Value("${test.a2}")
    private int a2;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    @Override
    public String toString() {
        return "Entity0{" +
                "a1='" + a1 + '\'' +
                ", a2=" + a2 +
                '}';
    }
}
