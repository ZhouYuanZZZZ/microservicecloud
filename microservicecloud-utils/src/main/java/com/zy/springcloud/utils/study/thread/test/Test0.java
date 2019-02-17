package com.zy.springcloud.utils.study.thread.test;

import org.junit.Test;

public class Test0 {

    @Test
    public void test0(){
        short s1 = 1;
        s1+=1;
        System.out.println(s1);
    }

    @Test
    public void test1(){

        System.out.println(Math.floor(3.1));
        System.out.println(Math.floor(3.12));
        System.out.println(Math.floor(3.147));
        System.out.println(Math.floor(3.1785));
        System.out.println(Math.floor(-3.7575757));

        System.out.println(Math.round(3.648));
    }
}
