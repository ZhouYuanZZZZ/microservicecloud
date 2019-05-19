package com.zy.se.test.exception;

import org.junit.Test;

public class Test0 {

    public int returnMethod() {

        try {

            throw new RuntimeException("xxx");

        } catch (Exception e) {

            System.out.println("catch");
            return 10;

        } finally {
            System.out.println("finally");
            return 100;
        }
    }

    @Test
    public void test0(){
        System.out.println(returnMethod());
    }
}
